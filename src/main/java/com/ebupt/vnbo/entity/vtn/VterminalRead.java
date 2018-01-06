package com.ebupt.vnbo.entity.vtn;

import java.util.List;

import com.alibaba.fastjson.annotation.JSONField;

public class VterminalRead {
	private String name;
	@JSONField(name="bridge-status")
	private Bridge_status bridge_status;
	@JSONField(name="vinterface")
	private List<VinterfaceRead> vinterfaces;
	@JSONField(name="vterminal-config")
	private Vterminal_config vterminal_config;
	
	
	public Vterminal_config getVterminal_config() {
		return vterminal_config;
	}
	public void setVterminal_config(Vterminal_config vterminal_config) {
		this.vterminal_config = vterminal_config;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Bridge_status getBridge_status() {
		return bridge_status;
	}
	public void setBridge_status(Bridge_status bridge_status) {
		this.bridge_status = bridge_status;
	}
	public List<VinterfaceRead> getVinterfaces() {
		return vinterfaces;
	}
	public void setVinterfaces(List<VinterfaceRead> vinterfaces) {
		this.vinterfaces = vinterfaces;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((bridge_status == null) ? 0 : bridge_status.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((vinterfaces == null) ? 0 : vinterfaces.hashCode());
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
		VterminalRead other = (VterminalRead) obj;
		if (bridge_status == null) {
			if (other.bridge_status != null)
				return false;
		} else if (!bridge_status.equals(other.bridge_status))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (vinterfaces == null) {
			if (other.vinterfaces != null)
				return false;
		} else if (!vinterfaces.equals(other.vinterfaces))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "VterminalRead [name=" + name + ", bridge_status=" + bridge_status + ", vinterfaces=" + vinterfaces
				+ "]";
	}
	
	
	

}
