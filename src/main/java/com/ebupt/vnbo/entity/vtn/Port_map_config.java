package com.ebupt.vnbo.entity.vtn;

import com.alibaba.fastjson.annotation.JSONField;

public class Port_map_config {
	@JSONField(name="vlan-id")
	private String vlan_id;
	@JSONField(name="port-name")
	private String port_name;
	private String node;
	public String getVlan_id() {
		return vlan_id;
	}
	public void setVlan_id(String vlan_id) {
		this.vlan_id = vlan_id;
	}
	public String getPort_name() {
		return port_name;
	}
	public void setPort_name(String port_name) {
		this.port_name = port_name;
	}
	public String getNode() {
		return node;
	}
	public void setNode(String node) {
		this.node = node;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((node == null) ? 0 : node.hashCode());
		result = prime * result + ((port_name == null) ? 0 : port_name.hashCode());
		result = prime * result + ((vlan_id == null) ? 0 : vlan_id.hashCode());
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
		Port_map_config other = (Port_map_config) obj;
		if (node == null) {
			if (other.node != null)
				return false;
		} else if (!node.equals(other.node))
			return false;
		if (port_name == null) {
			if (other.port_name != null)
				return false;
		} else if (!port_name.equals(other.port_name))
			return false;
		if (vlan_id == null) {
			if (other.vlan_id != null)
				return false;
		} else if (!vlan_id.equals(other.vlan_id))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Port_map_config [vlan_id=" + vlan_id + ", port_name=" + port_name + ", node=" + node + "]";
	}
	

}
