package com.ebupt.vnbo.entity.vtn;

import com.alibaba.fastjson.annotation.JSONField;

public class MappedHost {
	@JSONField(name="mac-address")
	private String mac;
	@JSONField(name="port-id")
	private String port_id;
	public String getMac() {
		return mac;
	}
	public void setMac(String mac) {
		this.mac = mac;
	}
	public String getPort_id() {
		return port_id;
	}
	public void setPort_id(String port_id) {
		this.port_id = port_id;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((mac == null) ? 0 : mac.hashCode());
		result = prime * result + ((port_id == null) ? 0 : port_id.hashCode());
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
		MappedHost other = (MappedHost) obj;
		if (mac == null) {
			if (other.mac != null)
				return false;
		} else if (!mac.equals(other.mac))
			return false;
		if (port_id == null) {
			if (other.port_id != null)
				return false;
		} else if (!port_id.equals(other.port_id))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "MappedHost [mac=" + mac + ", port_id=" + port_id + "]";
	}
	

}
