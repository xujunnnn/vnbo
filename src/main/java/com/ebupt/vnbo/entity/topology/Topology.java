package com.ebupt.vnbo.entity.topology;

import java.util.HashSet;
import java.util.Iterator;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.annotation.JSONField;
import com.ebupt.vnbo.entity.abstracts.Operational;
import com.ebupt.vnbo.entity.exception.ODL_IO_Exception;
import com.ebupt.vnbo.entity.exception.ODL_IO_Exception;
import com.ebupt.vnbo.util.BaseUtil;
import com.ebupt.vnbo.util.HttpUtil;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;


/**
 * 
 * @author xu
 *
 */
public class Topology implements Operational {
	@JSONField(name="topology-id")
	private String topology_id;
	@JSONField(name="node")
	public HashSet<Node> nodes=new HashSet<Node>();
	@JSONField(name="link")
	public HashSet<Link> links=new HashSet<Link>();
	public String getTopology_id() {
	
		return topology_id;
	}
	public void setTopology_id(String topology_id) {
		this.topology_id = topology_id;
	}
	public HashSet<Node> getNodes() throws ODL_IO_Exception {
		return nodes;
	}
	public void setNodes(HashSet<Node> nodes) {
		
		this.nodes = nodes;
	}
	public HashSet<Link> getLinks() throws ODL_IO_Exception {
		return links;
	}
	public void setLinks(HashSet<Link> links) {
		this.links = links;
	}

	public Topology read(String node) throws ODL_IO_Exception {
		// TODO Auto-generated method stub
		String url="http://"+ BaseUtil.getOperationalUrl()+"//network-topology:network-topology/topology/"+topology_id;
		String []result=HttpUtil.Get_request(url);
		String responsecode=result[0];
		String json=result[1];
		if(!"200".equals(responsecode) && !"201".equals(responsecode))
			throw new ODL_IO_Exception("failed to read the topologu from the controller "+"deatil: "+result[1]);

		JSONObject jsonObject=JSONObject.parseObject(json);
		JSONArray jsonArray=jsonObject.getJSONArray("topology");
		Topology topology=JSONObject.toJavaObject(jsonArray.getJSONObject(0), Topology.class);
		return topology;
		
	}	

}
