package com.ebupt.vnbo.ServiceImpl.init;

import java.util.HashSet;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.ebupt.vnbo.entity.enums.Protocol_Type;
import com.ebupt.vnbo.entity.enums.RespCode;
import com.ebupt.vnbo.entity.exception.ODL_IO_Exception;
import com.ebupt.vnbo.entity.exception.OperationalException;
import com.ebupt.vnbo.entity.flow.FlowEntry;
import com.ebupt.vnbo.entity.flow.instruction.Instruction;
import com.ebupt.vnbo.entity.flow.instruction.Instructions;
import com.ebupt.vnbo.entity.flow.match.Match;
import com.ebupt.vnbo.entity.monitor.FlowMonitorTask;
import com.ebupt.vnbo.entity.monitor.IpMonitorTask;
import com.ebupt.vnbo.entity.monitor.LatencyMonitorTask;
import com.ebupt.vnbo.entity.monitor.PortMonitorTask;
import com.ebupt.vnbo.entity.monitor.ProtocolMonTask;
import com.ebupt.vnbo.entity.monitor.QueueMonitorTask;
import com.ebupt.vnbo.entity.result.Result;
import com.ebupt.vnbo.entity.table.Table;
import com.ebupt.vnbo.entity.topology.Node;
import com.ebupt.vnbo.entity.topology.Termination_point;
import com.ebupt.vnbo.service.initialize.InitService;
import com.ebupt.vnbo.service.topology.TopologyService;
import com.ebupt.vnbo.util.FlowUtil;

@Service
public class InitServiceImpl implements InitService{
	public static String CUSTOMIZETABLE="1";
	public static String QOSFLOWTABLE="0";
	public static String VTNFLOWTABLE="5";
	public static String MONFLOWTABLE="3";
	public static String LOWPRIORITY="200";
	public static String MIDPRIORITY="210";
	public static String HIGHPRIORITY="220";
	public static String IDLE_TIME_OUT="0";
	public static String HARD_TIME_OUT="0";
	public static String VTN_FLOW_IDLE="3600";
	public static String VTN_FLOW_HARD="0";
	private static int mondelay=1;
	private static int moninterval=5;
	private ExecutorService service=Executors.newFixedThreadPool(2);
	private ScheduledExecutorService timerService=Executors.newScheduledThreadPool(10);
	private static volatile boolean isMonFlowInstalled=false;
	@Autowired
	private TopologyService topologyService;
	@Override
	public Result initBaseFlow() {
		// TODO Auto-generated method stub
		Result result=new Result<>();
		service.execute(initBaseFlowTask());
		result.setStatus(RespCode.success);
		result.setDescription("success to init base flow");
		return result;
	}
	@Override
	public Result initMonitor() {
		// TODO Auto-generated method stub
		Result result=new Result<>();
		if(!isMonFlowInstalled){
			//service.execute(initMonitorFlowTask());
			//ProtocolMonTask protocolMonTask=new ProtocolMonTask().setIsactive(true);
			//IpMonitorTask ipMonitorTask=new IpMonitorTask().setIsactive(true);
			//LatencyMonitorTask latencyMonitorTask=new LatencyMonitorTask().setIsactive(true);
			//QueueMonitorTask queueMonitorTask=new QueueMonitorTask().setIsactive(true);
			 
			//PortMonitorTask portMonitorTask=new PortMonitorTask().setIsactive(true);
			FlowMonitorTask flowMonitorTask=new FlowMonitorTask(topologyService);
			flowMonitorTask.setIsactive(true);
			
	
				timerService.scheduleAtFixedRate(flowMonitorTask, mondelay, moninterval, TimeUnit.SECONDS);
				/**
				 * protocolMonTask.setNodes(topologyService.get_switch());
				ipMonitorTask.setNodes(topologyService.get_switch());
				queueMonitorTask.setNodes(topologyService.get_switch());
				
				portMonitorTask.setNodes(topologyService.get_switch());
				
				timerService.scheduleWithFixedDelay(latencyMonitorTask, mondelay, moninterval, TimeUnit.SECONDS);
				timerService.scheduleWithFixedDelay(protocolMonTask, mondelay, moninterval, TimeUnit.SECONDS);
				timerService.scheduleWithFixedDelay(queueMonitorTask, mondelay, moninterval, TimeUnit.SECONDS);
				
				timerService.scheduleAtFixedRate(portMonitorTask, mondelay, moninterval, TimeUnit.SECONDS);
				 */
		
		}
		result.setDescription("success to init monitor");
		result.setStatus(RespCode.success);
		return result;
		
	}


	private Runnable initBaseFlowTask(){
		return new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				try {
					for(Node node:topologyService.get_switch()){
						FlowEntry flow=new FlowEntry();
						Match match=new Match();
						Instructions instructions=new Instructions();
						Instruction instruction=new Instruction().Set_Go_To_Table_Id(CUSTOMIZETABLE).setOrder("0");
						instructions.addInstruction(instruction);
						/*
						 * send flow gototable 1
						 */
						flow.setId("0")
							.setFlow_name("initflow"+flow.getId())
							.setCookie(String.valueOf(flow.getId().hashCode()))
							.setHard_timeout("0")
							.setIdle_timeout("0")
							.setPriority(LOWPRIORITY)
							.setTable_id(QOSFLOWTABLE)
							.setMatch(match)
							.setInstructions(instructions)
							.send(node.getNode_id());
						Instructions instructions2=new Instructions();
						Instruction instruction2=new Instruction().Set_Go_To_Table_Id(MONFLOWTABLE).setOrder("0");
						instructions2.addInstruction(instruction2);
						/*
						 * send flow gototable 5
						 */
						flow.setId("BaseFlow_"+"0")
							.setFlow_name("initflow"+flow.getId())
							.setCookie(String.valueOf(flow.getId().hashCode()))
							.setInstructions(instructions2)
							.setTable_id(CUSTOMIZETABLE)
							.setHard_timeout("0")
							.setIdle_timeout("0")
							.setPriority(LOWPRIORITY)
							.setMatch(match)
							.send(node.getNode_id());
						Instructions instructions3=new Instructions();
						Instruction instruction3=new Instruction().Set_Go_To_Table_Id(VTNFLOWTABLE).setOrder("0");
						instructions3.addInstruction(instruction3);
						flow.setId("BaseFlow_"+"0")
						.setFlow_name("initflow"+flow.getId())
						.setCookie(String.valueOf(Math.abs(flow.getId().hashCode())))
						.setInstructions(instructions3)
						.setTable_id(MONFLOWTABLE)
						.setHard_timeout("0")
						.setIdle_timeout("0")
						.setPriority(LOWPRIORITY)
						.setMatch(match)
						.send(node.getNode_id());
						}
				} catch (ODL_IO_Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				
				
				
			}
		};
	}
	
	
	private Runnable initMonitorFlowTask(){
		return new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				if(!FlowUtil.isInited()){
					try {
						FlowUtil.initMap(topologyService.get_switch());
					} catch (OperationalException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (ODL_IO_Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				HashSet<Protocol_Type> protocol_Types=new HashSet<>();
				protocol_Types.add(Protocol_Type.ICMP);
				protocol_Types.add(Protocol_Type.TCP);
				protocol_Types.add(Protocol_Type.UDP);
				protocol_Types.add(Protocol_Type.UNKNOW);
				try {
					for(Node node:topologyService.get_switch()){
						Table table=new Table().setTableid(MONFLOWTABLE);
						table.remove(node.getNode_id());
					}
					for(Node node:topologyService.get_switch()){
						Table table=new Table().setTableid(MONFLOWTABLE);
						table.remove(node.getNode_id());
						Instructions instructions=new Instructions();
						Instruction instruction=new Instruction().Set_Go_To_Table_Id(VTNFLOWTABLE).setOrder("0");
						instructions.addInstruction(instruction);
						//鑾峰彇涓庝富鏈虹浉杩炴帴鐨勭鍙�
						HashSet<Termination_point> termination_points=topologyService.getOutPorts(node.getNode_id());
						for(Termination_point t:termination_points){
							System.out.println(t.getTp_id());
							for(Protocol_Type p:protocol_Types){
								FlowEntry flow2=new FlowEntry();
								Match match2=new Match();
								if(!(Protocol_Type.UNKNOW==p)){
								 match2.Set_Ip_Match(String.valueOf(p.value()), null, null,null)
												.setIn_port(t.getTp_id())
												.Set_Mac_Match(null, null, "2048");
								 flow2.setPriority(HIGHPRIORITY);
								}
								else{
								 match2.setIn_port(t.getTp_id());	
								 flow2.setPriority(MIDPRIORITY);
								}
								flow2.setId("MonitorFlow"+Long.toString(FlowUtil.getFlowId(node)))
									 .setFlow_name("MonitorFlow"+flow2.getId())
									 .setCookie(String.valueOf(Math.abs(flow2.getId().hashCode())))
									 .setIdle_timeout("0")
									 .setHard_timeout("0")
									 .setTable_id(MONFLOWTABLE)
									 .setInstructions(instructions)
									 .setMatch(match2)
									 .send(node.getNode_id());
								System.out.println(JSON.toJSON(flow2));
								
							}
						}
			 }	
				} catch (ODL_IO_Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}	
				
				
			}
		};
	}
	

}
