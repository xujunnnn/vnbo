package com.ebupt.vnbo.entity.ovsdb.operational;

import java.util.List;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.annotation.JSONField;
import com.ebupt.vnbo.entity.abstracts.Operational;
import com.ebupt.vnbo.entity.exception.ODL_IO_Exception;
import com.ebupt.vnbo.util.BaseUtil;
import com.ebupt.vnbo.util.HttpUtil;

public class OVSDBTopologyOperational implements Operational{
	public static final String OperationalUrl=BaseUtil.getODL_IP()+"/restconf/operational";
	public static final String VtnOperationUrl=BaseUtil.getODL_IP()+"/restconf/operations";
	@JSONField(name="topology-id")
	private String topology_id;
	@JSONField(name="node")
	private List<OVSDBNodeOperational> nodes;
	public String getTopology_id() {
		return topology_id;
	}
	public void setTopology_id(String topology_id) {
		this.topology_id = topology_id;
	}
	public List<OVSDBNodeOperational> getNodes() {
		return nodes;
	}
	public void setNodes(List<OVSDBNodeOperational> nodes) {
		this.nodes = nodes;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nodes == null) ? 0 : nodes.hashCode());
		result = prime * result + ((topology_id == null) ? 0 : topology_id.hashCode());
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
		OVSDBTopologyOperational other = (OVSDBTopologyOperational) obj;
		if (nodes == null) {
			if (other.nodes != null)
				return false;
		} else if (!nodes.equals(other.nodes))
			return false;
		if (topology_id == null) {
			if (other.topology_id != null)
				return false;
		} else if (!topology_id.equals(other.topology_id))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "OVSDBTopologyOperational [topology_id=" + topology_id + ", nodes=" + nodes + "]";
	}
	@Override
	public OVSDBTopologyOperational  read(String node) throws ODL_IO_Exception {
		// TODO Auto-generated method stub
		String url="http://"+OperationalUrl+"/network-topology:network-topology/topology/ovsdb:1/";
		String[] response=HttpUtil.Get_request(url);
		String responsecode=response[0];
		String responsebody=response[1];
		if(!"200".equals(responsecode) && !"201".equals(responsecode) && !"204".equals(responsecode))
			throw new ODL_IO_Exception("failed to connect to the ovsdb detail:"+responsebody);
		JSONObject jsonObject=JSONObject.parseObject(responsebody);
		jsonObject=jsonObject.getJSONArray("topology").getJSONObject(0);
		if(jsonObject!=null)
			return JSON.toJavaObject(jsonObject, OVSDBTopologyOperational.class);
		return null;
	}
	
	
	

}
