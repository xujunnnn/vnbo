package com.ebupt.vnbo.entity.flow_filter;

import com.alibaba.fastjson.annotation.JSONField;
/*
"redirect-destination": {
    "tenant-name": "vtn1",
    "bridge-name": "vbr1",
    "router-name": "0",
    "terminal-name": "terminal1",
    "interface-name": "if1"
}
 */
public class Redirect_Destination {
	@JSONField(name="tenant-name")
	private String tenant_name;
	@JSONField(name="bridge-name")
	private String bridge_name;
	@JSONField(name="router-name")
	private String router_name;
	@JSONField(name="terminal-name")
	private String terminal_name;
	@JSONField(name="interface-name")
	private String interface_name;
	
	public String getTenant_name() {return this.tenant_name;}
	public void setTenant_name(String tenant_name) {this.tenant_name=tenant_name;}
	
	public String getBridge_name() {return this.bridge_name;}
	public void setBridge_name(String bridge_name) {this.bridge_name=bridge_name;}
	public String getRouter_name() {return this.router_name;}
	public void setRouter_name(String router_name) {this.router_name=router_name;}
	public String getTerminal_name() {return this.terminal_name;}
	public void setTerminal_name(String terminal_name) {this.terminal_name=terminal_name;}
	
	public String getInterface_name() {return interface_name;}
	public void setInterface_name(String interface_name) {this.interface_name=interface_name;}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((tenant_name == null) ? 0 : tenant_name.hashCode());
		result = prime * result + ((bridge_name == null) ? 0 : bridge_name.hashCode());
		result = prime * result + ((router_name == null) ? 0 : router_name.hashCode());
		result = prime * result + ((terminal_name == null) ? 0 : terminal_name.hashCode());
		result = prime * result + ((interface_name == null) ? 0 : interface_name.hashCode());
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
		Redirect_Destination other = (Redirect_Destination) obj;
		if (tenant_name == null) {
			if (other.tenant_name != null)
				return false;
		} else if (!tenant_name.equals(other.tenant_name))
			return false;
		if (bridge_name == null) {
			if (other.bridge_name != null)
				return false;
		} else if (!bridge_name.equals(other.bridge_name))
			return false;
		if (router_name == null) {
			if (other.router_name != null)
				return false;
		} else if (!router_name.equals(other.router_name))
			return false;
		if (terminal_name == null) {
			if (other.terminal_name != null)
				return false;
		} else if (!terminal_name.equals(other.terminal_name))
			return false;
		if (interface_name == null) {
			if (other.interface_name != null)
				return false;
		} else if (!interface_name.equals(other.interface_name))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Redirect_Destination [terminal_name=" + terminal_name + ", router_name=" + router_name 
						+ ", tenant_name=" + tenant_name+ ", bridge_name=" + bridge_name + ", interface_name=" 
				        + interface_name  + "]";
	}
}
