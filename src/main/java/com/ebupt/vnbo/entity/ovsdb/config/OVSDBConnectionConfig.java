package com.ebupt.vnbo.entity.ovsdb.config;

import java.util.List;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.annotation.JSONField;
import com.ebupt.vnbo.entity.abstracts.Config;
import com.ebupt.vnbo.entity.exception.ConfigException;
import com.ebupt.vnbo.entity.exception.ODL_IO_Exception;
import com.ebupt.vnbo.util.BaseUtil;
import com.ebupt.vnbo.util.HttpUtil;

public class OVSDBConnectionConfig implements Config{
	private static final String ConfigUrl=BaseUtil.getODL_IP()+"/restconf/config";
	private static final String VtnConfigUrl=BaseUtil.getODL_IP()+"/restconf/operations";
	@JSONField(serialize=false)
	private String topo_id;
	
	public String getTopo_id() {
		return topo_id;
	}

	public void setTopo_id(String topo_id) {
		this.topo_id = topo_id;
	}

	@JSONField(name="network-topology:node")
	private List<NetworkNode> nodes;

	public List<NetworkNode> getNodes() {
		return nodes;
	}

	public void setNodes(List<NetworkNode> nodes) {
		this.nodes = nodes;
	}



	@Override
	public String toString() {
		return "OVSDBConnectionConfig [topo_id=" + topo_id + ", nodes=" + nodes + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nodes == null) ? 0 : nodes.hashCode());
		result = prime * result + ((topo_id == null) ? 0 : topo_id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		OVSDBConnectionConfig other = (OVSDBConnectionConfig) obj;
		if (nodes == null) {
			if (other.nodes != null)
				return false;
		} else if (!nodes.equals(other.nodes))
			return false;
		if (topo_id == null) {
			if (other.topo_id != null)
				return false;
		} else if (!topo_id.equals(other.topo_id))
			return false;
		return true;
	}

	@Override
	public void send(String node) throws ODL_IO_Exception {
		// TODO Auto-generated method stub
		String url="http://"+ConfigUrl+"/network-topology:network-topology/topology/+"+"ovsdb:1"+"/";
		JSONObject jsonObject=(JSONObject)JSONObject.toJSON(this);
		String response[]=HttpUtil.Post_request(url, jsonObject);
		String responsecode=response[0];
		String responsebody=response[1];
		if(!"200".equals(responsecode) && !"201".equals(responsecode) && !"204".equals(responsecode)){
			throw new ODL_IO_Exception("failed to connect to the ovsdb detail:"+responsebody);		
		}
		
		
	}

	@Override
	public void remove(String node) throws ODL_IO_Exception {
		// TODO Auto-generated method stub
		String url="http://"+ConfigUrl+"/network-topology:network-topology/topology/+"+"ovsdb:1"+"/";
		String response[]=HttpUtil.Delete_request(url);
		String responsecode=response[0];
		String responsebody=response[1];
		if(!"200".equals(responsecode) && !"201".equals(responsecode) && !"404".equals(responsecode)){
			throw new ODL_IO_Exception("failed to delete connection  detail:"+responsebody);		
		}
	}
	
	

}
