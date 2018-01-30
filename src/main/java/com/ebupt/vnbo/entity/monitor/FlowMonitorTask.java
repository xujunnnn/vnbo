package com.ebupt.vnbo.entity.monitor;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ebupt.vnbo.entity.enums.EtherType;
import com.ebupt.vnbo.entity.enums.Protocol_Type;
import com.ebupt.vnbo.entity.exception.ODL_IO_Exception;
import com.ebupt.vnbo.entity.flow.FlowEntry;
import com.ebupt.vnbo.entity.flow.match.Ethernet_destination;
import com.ebupt.vnbo.entity.flow.match.Ethernet_source;
import com.ebupt.vnbo.entity.table.TableRead;
import com.ebupt.vnbo.entity.topology.Node;
import com.ebupt.vnbo.service.topology.TopologyService;
import com.ebupt.vnbo.util.InfluxDBUtil;
/**
 * 
* 类名: FlowMonitorTask.java <br/>
* 包名 : com.ebupt.vnbo.entity.monitor <br/>
* 详细描述: TODO(监控flow状态) <br/>
* 开发人员： xujun   <br/>
* 开发日期：2018年1月2日 <br/>
* 发布版本： V1.0  <br/>
 */
public class FlowMonitorTask implements Runnable{
		private final TopologyService service;
		private static Logger logger=LoggerFactory.getLogger(FlowMonitorTask.class);
		private static final String FLOWTABLE="0";
		private static final String FLOWMEASUREMENT="flow_load";
		private volatile boolean isactive;
		//private NetMonitorMap netMonitorMap=new NetMonitorMap();
		private HashSet<Node> nodes=new HashSet<Node>();
		//每4秒进行一次轮询
		private static final long interval=3500;
		private String tableid;
		public FlowMonitorTask(final TopologyService service) {
			// TODO Auto-generated constructor stub
			this.service=service;
		}
		public boolean isIsactive() {
			return isactive;
		}
		
		public static Logger getLogger() {
			return logger;
		}

		public static void setLogger(Logger logger) {
			FlowMonitorTask.logger = logger;
		}

		public HashSet<Node> getNodes() {
			return nodes;
		}

		public void setNodes(HashSet<Node> nodes) {
			this.nodes = nodes;
		}

		public String getTableid() {
			return tableid;
		}

		public void setTableid(String tableid) {
			this.tableid = tableid;
		}

		public static String getFlowtable() {
			return FLOWTABLE;
		}

		public static String getFlowmeasurement() {
			return FLOWMEASUREMENT;
		}

		public static long getInterval() {
			return interval;
		}

		public void setIsactive(boolean isactive) {
			this.isactive = isactive;
		}

		@Override
		public void run() {
			// TODO Auto-generated method stub
		
			Map<MonTag, NetStatic> netMonitorMap=new HashMap<>();
			while(isactive){
				long timestamp=System.currentTimeMillis();		
			try {
				for(Node node:service.get_access_node()){
					TableRead tableRead=new TableRead();
					tableRead.setTableid(FLOWTABLE);
					try {
						for(FlowEntry flowEntry:tableRead.read(node.getNode_id()).getFlow()){
							MonTag monTag=new MonTag();
							monTag.setNode(node.getNode_id());
							if(flowEntry.getMatch()!=null){
								if(flowEntry.getMatch().getIn_port()!=null){
									String in_port=flowEntry.getMatch().getIn_port();	
									monTag.setInport(in_port);
								}
								if(flowEntry.getMatch().getEthernet_Match()!=null){
									if(flowEntry.getMatch().getEthernet_Match().getEthernet_source()!=null){
										Ethernet_source source=flowEntry.getMatch().getEthernet_Match().getEthernet_source();
										monTag.setSrcmac(source.getAddress());
									}
									if(flowEntry.getMatch().getEthernet_Match().getEthernet_destination()!=null){
										Ethernet_destination destination=flowEntry.getMatch().getEthernet_Match().getEthernet_destination();
										monTag.setDestmac(destination.getAddress());
									}
									if(flowEntry.getMatch().getEthernet_Match().getEthernet_type()!=null){
										EtherType type=EtherType.Valueof(flowEntry.getMatch().getEthernet_Match().getEthernet_type().getType());
										monTag.setEtherType(type);
									}
									
								}
								if(flowEntry.getMatch().getIp_Match()!=null && flowEntry.getMatch().getIp_Match().getIp_protocol()!=null){
									String ipProtocol=flowEntry.getMatch().getIp_Match().getIp_protocol();
									Protocol_Type protocol_Type=Protocol_Type.Valueof(Integer.parseInt(ipProtocol));
									monTag.setProtocol_Type(protocol_Type);
								}
								if(flowEntry.getMatch().getIpv4_source()!=null){
									monTag.setSrcip(flowEntry.getMatch().getIpv4_source());
								}
								if(flowEntry.getMatch().getIpv4_destination()!=null){
									monTag.setDestip(flowEntry.getMatch().getIpv4_destination());
								}
								if(flowEntry.getMatch().getTcp_source_port()!=null){
									monTag.setTcp_srcport(flowEntry.getMatch().getTcp_source_port());
								}
								if(flowEntry.getMatch().getTcp_destination_port()!=null){
									monTag.setTcp_destport(flowEntry.getMatch().getTcp_destination_port());
								}
								if(flowEntry.getMatch().getUdp_source_port()!=null){
									monTag.setUdp_srcport(flowEntry.getMatch().getUdp_source_port());
								}
								if(flowEntry.getMatch().getUdp_destination_port()!=null){
									monTag.setUdp_destport(flowEntry.getMatch().getUdp_destination_port());
								}
							}	
							NetStatic netStatic=new NetStatic();
							long nowbyte=flowEntry.getFlow_Statistic().getByte_count();
							long nowpkt=flowEntry.getFlow_Statistic().getPacket_count();
							long nowtime=flowEntry.getFlow_Statistic().getDuration().getSecond();	
							netStatic.setBytecount(nowbyte).setPacketcount(nowpkt).setTimestamp(nowtime);
							if(netMonitorMap.get(monTag)!=null){
								long oldbyte=netMonitorMap.get(monTag).getBytecount();
								long oldpkt=netMonitorMap.get(monTag).getPacketcount();
								long oldtime=netMonitorMap.get(monTag).getTimestamp();
								if(nowbyte < oldbyte){
									nowbyte=oldbyte+nowbyte;
								}
								long bytespeed=0;
								long pktspeed=0;
								if((nowtime-oldtime)!=0){
									 bytespeed=(nowbyte-oldbyte)/(nowtime-oldtime);
								     pktspeed=(nowpkt-oldpkt)/(nowtime-oldtime);
								}
								else {
									bytespeed=netMonitorMap.get(monTag).getBytespeed();
									pktspeed=netMonitorMap.get(monTag).getPacketspeed();
								}
								netStatic.setPacketspeed(pktspeed).setBytespeed(bytespeed);				
							}

							netMonitorMap.put(monTag, netStatic);	
							}
					} catch (NumberFormatException | ODL_IO_Exception e) {
						// TODO Auto-generated catch block
						logger.error("IpMonitorTask running error, error details {} ",e.getMessage());
						e.printStackTrace();
					}		
				  }
			} catch (ODL_IO_Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			InfluxDBUtil.put(timestamp,FLOWMEASUREMENT,netMonitorMap);
			System.out.println("Flow_load><><><>><><><><>>< Monitoring"+"  thread= "+Thread.currentThread().getName());
			try {
				Thread.sleep(interval);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			}
			}
		
		

			
			

			




}
