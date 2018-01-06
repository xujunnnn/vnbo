package com.ebupt.vnbo.entity.ovsdb.config;

import com.alibaba.fastjson.annotation.JSONField;

public class NetworkNode {
	@JSONField(name="node-id")
	private String node_id;
	@JSONField(name="connection-info")
	private OVSDBConnectionInfo connectionInfo;
	public String getNode_id() {
		return node_id;
	}
	public void setNode_id(String node_id) {
		this.node_id = node_id;
	}
	public OVSDBConnectionInfo getConnectionInfo() {
		return connectionInfo;
	}
	public void setConnectionInfo(OVSDBConnectionInfo connectionInfo) {
		this.connectionInfo = connectionInfo;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((connectionInfo == null) ? 0 : connectionInfo.hashCode());
		result = prime * result + ((node_id == null) ? 0 : node_id.hashCode());
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
		NetworkNode other = (NetworkNode) obj;
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
		return true;
	}
	@Override
	public String toString() {
		return "NetworkNode [node_id=" + node_id + ", connectionInfo=" + connectionInfo + "]";
	}
	

}
