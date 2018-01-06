package com.ebupt.vnbo.entity.vtn;

import com.alibaba.fastjson.annotation.JSONField;

public class VinterfaceRead {
	private String name;
	@JSONField(name="port-map-config")
	private Port_map_config port_map_config;
	@JSONField(name="vinterface-status")
	private Vinterface_status vinterface_status;
	@JSONField(name="vinterface-input-filter")
	private Vinterface_input_filter vinterface_input_filter;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Port_map_config getPort_map_config() {
		return port_map_config;
	}
	public void setPort_map_config(Port_map_config port_map_config) {
		this.port_map_config = port_map_config;
	}
	public Vinterface_status getVinterface_status() {
		return vinterface_status;
	}
	public void setVinterface_status(Vinterface_status vinterface_status) {
		this.vinterface_status = vinterface_status;
	}
	public Vinterface_input_filter getVinterface_input_filter() {
		return vinterface_input_filter;
	}
	public void setVinterface_input_filter(Vinterface_input_filter vinterface_input_filter) {
		this.vinterface_input_filter = vinterface_input_filter;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((port_map_config == null) ? 0 : port_map_config.hashCode());
		result = prime * result + ((vinterface_input_filter == null) ? 0 : vinterface_input_filter.hashCode());
		result = prime * result + ((vinterface_status == null) ? 0 : vinterface_status.hashCode());
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
		VinterfaceRead other = (VinterfaceRead) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (port_map_config == null) {
			if (other.port_map_config != null)
				return false;
		} else if (!port_map_config.equals(other.port_map_config))
			return false;
		if (vinterface_input_filter == null) {
			if (other.vinterface_input_filter != null)
				return false;
		} else if (!vinterface_input_filter.equals(other.vinterface_input_filter))
			return false;
		if (vinterface_status == null) {
			if (other.vinterface_status != null)
				return false;
		} else if (!vinterface_status.equals(other.vinterface_status))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "VinterfaceRead [name=" + name + ", port_map_config=" + port_map_config + ", vinterface_status="
				+ vinterface_status + ", vinterface_input_filter=" + vinterface_input_filter + "]";
	}
	
	
}
