package com.ebupt.vnbo.util;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import com.ebupt.vnbo.ServiceImpl.topology.TopologyServiceImpl;
import com.ebupt.vnbo.entity.exception.ODL_IO_Exception;
import com.ebupt.vnbo.entity.exception.OperationalException;
import com.ebupt.vnbo.entity.topology.Node;
import com.ebupt.vnbo.service.topology.TopologyService;

public class FlowUtil {
	private static Map<Node, Long> flowIdMap=new HashMap<>();
	
	public static boolean isInited(){
		if(flowIdMap.size()==0){
			return false;
		}
		return true;
	}
	
	public static void initMap(Set<Node> nodes) throws OperationalException{
			for(Node node:nodes){
				flowIdMap.put(node, (long) 1);
			}
		
	}
	public static long getFlowId(Node node){
		long id=flowIdMap.get(node);
		long newid=id+1;
		flowIdMap.put(node,newid);
		return id;
	}

}
