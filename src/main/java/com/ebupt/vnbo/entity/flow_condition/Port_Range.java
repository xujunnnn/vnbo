package com.ebupt.vnbo.entity.flow_condition;

import com.alibaba.fastjson.annotation.JSONField;

/*
{
        "port-from": "1",
        "port-to": "1"
}
 */
public class Port_Range {
	@JSONField(name="port-from")
	private String port_from ;
	@JSONField(name="port-to")
	private String port_to;
	
	public String getPort_from() {return port_from;}
	public void setPort_from(String port_from) {this.port_from=port_from;}
	
	public String getPort_to() {return port_to;}
	public void setPort_to(String port_to) {this.port_to=port_to;}
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((port_from == null) ? 0 : port_from.hashCode());
		result = prime * result + ((port_to == null) ? 0 : port_to.hashCode());
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
		Port_Range other = (Port_Range) obj;
		if (port_from == null) {
			if (other.port_from != null)
				return false;
		} else if (!port_from.equals(other.port_from))
			return false;
		if (port_to == null) {
			if (other.port_to != null)
				return false;
		} else if (!port_to.equals(other.port_to))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "[port from"+port_from+"to"+port_to+"]";
	}
	
}
