package com.ebupt.vnbo.entity.vtn;

import com.alibaba.fastjson.annotation.JSONField;

public class Vinterface_status {
	private String state;
	@JSONField(name="mapped-port")
	private String mapped_port;
	@JSONField(name="entity-state")
	private String entity_state;
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getMapped_port() {
		return mapped_port;
	}
	public void setMapped_port(String mapped_port) {
		this.mapped_port = mapped_port;
	}
	public String getEntity_state() {
		return entity_state;
	}
	public void setEntity_state(String entity_state) {
		this.entity_state = entity_state;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((entity_state == null) ? 0 : entity_state.hashCode());
		result = prime * result + ((mapped_port == null) ? 0 : mapped_port.hashCode());
		result = prime * result + ((state == null) ? 0 : state.hashCode());
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
		Vinterface_status other = (Vinterface_status) obj;
		if (entity_state == null) {
			if (other.entity_state != null)
				return false;
		} else if (!entity_state.equals(other.entity_state))
			return false;
		if (mapped_port == null) {
			if (other.mapped_port != null)
				return false;
		} else if (!mapped_port.equals(other.mapped_port))
			return false;
		if (state == null) {
			if (other.state != null)
				return false;
		} else if (!state.equals(other.state))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Vinterface_status [state=" + state + ", mapped_port=" + mapped_port + ", entity_state=" + entity_state
				+ "]";
	}
	

}
