package com.ebupt.vnbo.entity.monitor;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

import com.ebupt.vnbo.ServiceImpl.topology.TopologyServiceImpl;
import com.ebupt.vnbo.entity.exception.ODL_IO_Exception;
import com.ebupt.vnbo.entity.exception.OperationalException;
import com.ebupt.vnbo.entity.node_static.NodeStatic;
import com.ebupt.vnbo.entity.node_static.Node_connector;
import com.ebupt.vnbo.entity.node_static.Queue;
import com.ebupt.vnbo.entity.topology.Node;
import com.ebupt.vnbo.service.topology.TopologyService;
import com.ebupt.vnbo.util.InfluxDBUtil;

/**
 * 
* ����: QueueMonitorTask.java <br/>
* ���� : com.ebupt.vnbo.classes.monitor <br/>
* ��ϸ����: TODO(���м�ض��߳�ʵ����) <br/>
* ������Ա�� xujun   <br/>
* �������ڣ�2017��6��19�� <br/>
* �����汾�� V1.0  <br/>
 */
public class QueueMonitorTask implements Runnable{
	private HashSet<Node> nodes;
	private long interval=4000;
	private static final String measurement="queue_load";
	private Map<MonTag, NetStatic> netMonitorMap=new HashMap<>();
	private volatile boolean isactive;
	private TopologyService topologyService;
	
	public TopologyService getTopologyService() {
		return topologyService;
	}

	public void setTopologyService(TopologyService topologyService) {
		this.topologyService = topologyService;
	}

	public HashSet<Node> getNodes() {
		return nodes;
	}

	public void setNodes(HashSet<Node> nodes) {
		this.nodes = nodes;
	}

	public boolean isIsactive() {
		return isactive;
	}

	public QueueMonitorTask setIsactive(boolean isactive) {
		this.isactive = isactive;
		return this;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(isactive=true){
			long timestamp=System.currentTimeMillis();
			try {
				for(Node node:topologyService.get_access_node()){
					NodeStatic nodeStatic=new NodeStatic();
					nodeStatic.setId(node.getNode_id());
					try {
						nodeStatic=(NodeStatic)nodeStatic.read(node.getNode_id());
						for(Node_connector node_connector:nodeStatic.getNode_connector()){
							if(node_connector.getQueues()!=null){
							for(Queue queue:node_connector.getQueues()){
								MonTag monTag=new MonTag();
								monTag.setNode(node.getNode_id());
								monTag.setInport(node_connector.getId());
								monTag.setQueueid(queue.getQueue_id());
								NetStatic netStatic=new NetStatic();
								long nowbyte=queue.getQueue_Static().getTransmitted_bytes();
								long nowpkt=queue.getQueue_Static().getTransmitted_packets();
								long nowtime=queue.getQueue_Static().getDuration().getSecond();
								netStatic.setBytecount(nowbyte);
								netStatic.setBytespeed(nowpkt);
								netStatic.setTimestamp(nowtime);
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
								else {
									netStatic.setPacketspeed(0).setBytespeed(0);
								}
								this.netMonitorMap.put(monTag, netStatic);
							}
						  }
						}
					} catch (ODL_IO_Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			} catch (ODL_IO_Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			InfluxDBUtil.put(timestamp,measurement,netMonitorMap);
			System.out.println("queue  Monitoring "+" Thread "+Thread.currentThread().getName());
			try {
				Thread.sleep(interval);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}


}
