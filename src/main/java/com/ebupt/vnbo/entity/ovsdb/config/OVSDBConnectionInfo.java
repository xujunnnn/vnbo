package com.ebupt.vnbo.entity.ovsdb.config;

import com.alibaba.fastjson.annotation.JSONField;

public class OVSDBConnectionInfo {
	@JSONField(name="network-topology:node")
	private String remote_port;
	@JSONField(name="ovsdb:remote-ip")
	private String remote_ip;
	public String getRemote_port() {
		return remote_port;
	}
	public void setRemote_port(String remote_port) {
		this.remote_port = remote_port;
	}
	public String getRemote_ip() {
		return remote_ip;
	}
	public void setRemote_ip(String remote_ip) {
		this.remote_ip = remote_ip;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((remote_ip == null) ? 0 : remote_ip.hashCode());
		result = prime * result + ((remote_port == null) ? 0 : remote_port.hashCode());
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
		OVSDBConnectionInfo other = (OVSDBConnectionInfo) obj;
		if (remote_ip == null) {
			if (other.remote_ip != null)
				return false;
		} else if (!remote_ip.equals(other.remote_ip))
			return false;
		if (remote_port == null) {
			if (other.remote_port != null)
				return false;
		} else if (!remote_port.equals(other.remote_port))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "OVSDBConnectionInfo [remote_port=" + remote_port + ", remote_ip=" + remote_ip + "]";
	}
	

}
