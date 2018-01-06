package com.ebupt.vnbo.entity.ovsdb.config;

import java.util.ArrayList;
import java.util.List;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.annotation.JSONField;
import com.ebupt.vnbo.entity.abstracts.Config;
import com.ebupt.vnbo.entity.enums.InterfaceType;
import com.ebupt.vnbo.entity.exception.ODL_IO_Exception;
import com.ebupt.vnbo.util.BaseUtil;
import com.ebupt.vnbo.util.HttpUtil;

public class OVSDBTerminationConfig implements Config{
	private static final String ConfigUrl=BaseUtil.getODL_IP()+"/restconf/config";
	private static final String VtnConfigUrl=BaseUtil.getODL_IP()+"/restconf/operations";
	@JSONField(serialize=false)
	private String host;
	@JSONField(serialize=false)
	private String node;
	@JSONField(name="ovsdb:name")
	private String name;
	@JSONField(name="ovsdb:interface-type")
	private String interfaceType;
	@JSONField(name="tp-id")
	private String tp_id;
	@JSONField(name="vlan-tag")
	private String vlan_tag;
	@JSONField(name="vlan-mode")
	private String vlan_mode;
	@JSONField(name="trunks")
	private List<OVSDBTrunkConfig> trunks;
	
	public String getHost() {
		return host;
	}
	public void setHost(String host) {
		this.host = host;
	}
	public String getNode() {
		return node;
	}
	public void setNode(String node) {
		this.node = node;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getInterfaceType() {
		return interfaceType;
	}
	public void setInterfaceType(String interfaceType) {
		this.interfaceType = interfaceType;
	}
	public String getTp_id() {
		return tp_id;
	}
	public void setTp_id(String tp_id) {
		this.tp_id = tp_id;
	}
	public String getVlan_tag() {
		return vlan_tag;
	}
	public void setVlan_tag(String vlan_tag) {
		this.vlan_tag = vlan_tag;
	}
	public String getVlan_mode() {
		return vlan_mode;
	}
	public void setVlan_mode(String vlan_mode) {
		this.vlan_mode = vlan_mode;
	}
	public List<OVSDBTrunkConfig> getTrunks() {
		return trunks;
	}
	public void setTrunks(List<OVSDBTrunkConfig> trunks) {
		this.trunks = trunks;
	}
	
	@Override
	public String toString() {
		return "OVSDBTerminationConfig [host=" + host + ", node=" + node + ", name=" + name + ", interfaceType="
				+ interfaceType + ", tp_id=" + tp_id + ", vlan_tag=" + vlan_tag + ", vlan_mode=" + vlan_mode
				+ ", trunks=" + trunks + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((host == null) ? 0 : host.hashCode());
		result = prime * result + ((interfaceType == null) ? 0 : interfaceType.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((node == null) ? 0 : node.hashCode());
		result = prime * result + ((tp_id == null) ? 0 : tp_id.hashCode());
		result = prime * result + ((trunks == null) ? 0 : trunks.hashCode());
		result = prime * result + ((vlan_mode == null) ? 0 : vlan_mode.hashCode());
		result = prime * result + ((vlan_tag == null) ? 0 : vlan_tag.hashCode());
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
		OVSDBTerminationConfig other = (OVSDBTerminationConfig) obj;
		if (host == null) {
			if (other.host != null)
				return false;
		} else if (!host.equals(other.host))
			return false;
		if (interfaceType == null) {
			if (other.interfaceType != null)
				return false;
		} else if (!interfaceType.equals(other.interfaceType))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (node == null) {
			if (other.node != null)
				return false;
		} else if (!node.equals(other.node))
			return false;
		if (tp_id == null) {
			if (other.tp_id != null)
				return false;
		} else if (!tp_id.equals(other.tp_id))
			return false;
		if (trunks == null) {
			if (other.trunks != null)
				return false;
		} else if (!trunks.equals(other.trunks))
			return false;
		if (vlan_mode == null) {
			if (other.vlan_mode != null)
				return false;
		} else if (!vlan_mode.equals(other.vlan_mode))
			return false;
		if (vlan_tag == null) {
			if (other.vlan_tag != null)
				return false;
		} else if (!vlan_tag.equals(other.vlan_tag))
			return false;
		return true;
	}
	@Override
	public void send(String n) throws ODL_IO_Exception {
		// TODO Auto-generated method stub
		String url="http://"+ConfigUrl+"/network-topology:network-topology/topology/"+"ovsdb:1"+"/node/ovsdb:%2F%2F"+host+"%2Fbridge%2F"+node+"/termination-point/"+name+"/";
		List<OVSDBTerminationConfig> terminationConfigs=new ArrayList<>();
		terminationConfigs.add(this);
		JSONArray array=JSONArray.parseArray(JSON.toJSONString(terminationConfigs));
		JSONObject json=new JSONObject();
		json.put("network-topology:termination-point", array);
		String []response=HttpUtil.Put_request(url, json);
		String responsecode=response[0];
		String responsebody=response[1];
		if(!"200".equals(responsecode) && !"201".equals(responsecode) && !"204".equals(responsecode)){
			throw new ODL_IO_Exception("failed to creat ovsdb port:"+responsebody);		
		}
	}
	@Override
	public void remove(String node) throws ODL_IO_Exception {
		// TODO Auto-generated method stub
		String url="http://"+ConfigUrl+"/network-topology:network-topology/topology/"+"ovsdb:1"+"/node/ovsdb:%2F%2F"+host+"%2Fbridge%2F"+node+"/termination-point/"+name+"/";
		String response[]=HttpUtil.Delete_request(url);
		String responsecode=response[0];
		String responsebody=response[1];
		if(!"200".equals(responsecode) && !"201".equals(responsecode) && !"404".equals(responsecode))
			throw new ODL_IO_Exception("failed to delete ovsdb port:"+responsebody);	
	}
	
	
	
	

}
