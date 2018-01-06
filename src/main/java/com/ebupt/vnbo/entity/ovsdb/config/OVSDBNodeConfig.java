package com.ebupt.vnbo.entity.ovsdb.config;

import java.util.ArrayList;
import java.util.List;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.annotation.JSONField;
import com.ebupt.vnbo.entity.abstracts.Config;
import com.ebupt.vnbo.entity.exception.ODL_IO_Exception;
import com.ebupt.vnbo.util.BaseUtil;
import com.ebupt.vnbo.util.HttpUtil;

public class OVSDBNodeConfig implements Config{
	private static final String ConfigUrl=BaseUtil.getODL_IP()+"/restconf/config";
	private static final String VtnConfigUrl=BaseUtil.getODL_IP()+"/restconf/operations";
	@JSONField(deserialize=true)
	private String host;
	@JSONField(name="node-id")
	private String node_id;
	@JSONField(name="ovsdb:bridge-name")
	private String bridge_name;
	@JSONField(name="ovsdb:protocol-entry")
	private OVSDBProtocolEntryConfig protocol;
	@JSONField(name="ovsdb:managed-by")
	private String ManagedBy;
	@JSONField(name="ovsdb:connection-info")
	private OVSDBNodeConnectionInfo connectionInfo;
	@JSONField(name="ovsdb:controller-entry")
	private List<OVSDBControllerEntryConfig> controllerEntryConfig;
	
	public void setHost(String host) {
		this.host = host;
	}
	public String getNode_id() {
		return node_id;
	}
	public void setNode_id(String node_id) {
		this.node_id = node_id;
	}
	public String getBridge_name() {
		return bridge_name;
	}
	public void setBridge_name(String bridge_name) {
		this.bridge_name = bridge_name;
	}
	public OVSDBProtocolEntryConfig getProtocol() {
		return protocol;
	}
	public void setProtocol(OVSDBProtocolEntryConfig protocol) {
		this.protocol = protocol;
	}
	public String getManagedBy() {
		return ManagedBy;
	}
	public void setManagedBy(String managedBy) {
		ManagedBy = managedBy;
	}
	public OVSDBNodeConnectionInfo getConnectionInfo() {
		return connectionInfo;
	}
	public void setConnectionInfo(OVSDBNodeConnectionInfo connectionInfo) {
		this.connectionInfo = connectionInfo;
	}
	
	public List<OVSDBControllerEntryConfig> getControllerEntryConfig() {
		return controllerEntryConfig;
	}
	public void setControllerEntryConfig(List<OVSDBControllerEntryConfig> controllerEntryConfig) {
		this.controllerEntryConfig = controllerEntryConfig;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((ManagedBy == null) ? 0 : ManagedBy.hashCode());
		result = prime * result + ((bridge_name == null) ? 0 : bridge_name.hashCode());
		result = prime * result + ((connectionInfo == null) ? 0 : connectionInfo.hashCode());
		result = prime * result + ((node_id == null) ? 0 : node_id.hashCode());
		result = prime * result + ((protocol == null) ? 0 : protocol.hashCode());
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
		OVSDBNodeConfig other = (OVSDBNodeConfig) obj;
		if (ManagedBy == null) {
			if (other.ManagedBy != null)
				return false;
		} else if (!ManagedBy.equals(other.ManagedBy))
			return false;
		if (bridge_name == null) {
			if (other.bridge_name != null)
				return false;
		} else if (!bridge_name.equals(other.bridge_name))
			return false;
		if (connectionInfo == null) {
			if (other.connectionInfo != null)
				return false;
		} else if (!connectionInfo.equals(other.connectionInfo))
			return false;
		if (node_id == null) {
			if (other.node_id != null)
				return false;
		} else if (!node_id.equals(other.node_id))
			return false;
		if (protocol == null) {
			if (other.protocol != null)
				return false;
		} else if (!protocol.equals(other.protocol))
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		return "OVSDBNodeConfig [host=" + host + ", node_id=" + node_id + ", bridge_name=" + bridge_name + ", protocol="
				+ protocol + ", ManagedBy=" + ManagedBy + ", connectionInfo=" + connectionInfo
				+ ", controllerEntryConfig=" + controllerEntryConfig + "]";
	}
	@Override
	public void send(String node) throws ODL_IO_Exception {
		// TODO Auto-generated method stub
		String url="http://"+ConfigUrl+"/network-topology:network-topology/topology/"+"ovsdb:1"+"/node/ovsdb:%2F%2F"+host+"%2Fbridge%2F"+bridge_name;
		List<OVSDBNodeConfig> list=new ArrayList<>();
		list.add(this);
		JSONArray array=JSONArray.parseArray(JSON.toJSONString(list));
		JSONObject json=new JSONObject();
		json.put("network-topology:node", array);
		String response[]=HttpUtil.Put_request(url, json);
		String responsecode=response[0];
		String responsebody=response[1];
		if(!"200".equals(responsecode) && !"201".equals(responsecode) && !"204".equals(responsecode)){
			throw new ODL_IO_Exception("failed to create ovsdb node:"+responsebody);		
		}
	}
	@Override
	public void remove(String node) throws ODL_IO_Exception {
		// TODO Auto-generated method stub
		String url="http://"+ConfigUrl+"/network-topology:network-topology/topology/"+"ovsdb:1"+"/node/ovsdb:%2F%2F"+host+"%2Fbridge%2F"+bridge_name;
		String response[]=HttpUtil.Delete_request(url);
		String responsecode=response[0];
		String responsebody=response[1];
		if(!"200".equals(responsecode) && !"201".equals(responsecode) && !"404".equals(responsecode)){
			throw new ODL_IO_Exception("failed to delete  to the ovsdb detail:"+responsebody);		
		}
		
	}
	
	
	

}
