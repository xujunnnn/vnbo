package com.ebupt.vnbo.entity.sfc;

import com.ebupt.vnbo.entity.enums.State;

public class MapDetail {
	private String node;
	private String mapped_port;
	private String vinterface;
	private String vterminalName;
	private State state;
	private String portname;
	public String getNode() {
		return node;
	}
	public void setNode(String node) {
		this.node = node;
	}
	public String getMapped_port() {
		return mapped_port;
	}
	public void setMapped_port(String mapped_port) {
		this.mapped_port = mapped_port;
	}
	public String getVinterface() {
		return vinterface;
	}
	public void setVinterface(String vinterface) {
		this.vinterface = vinterface;
	}
	public String getVterminalName() {
		return vterminalName;
	}
	public void setVterminalName(String vterminalName) {
		this.vterminalName = vterminalName;
	}
	public State getState() {
		return state;
	}
	public void setState(State state) {
		this.state = state;
	}
	public String getPortname() {
		return portname;
	}
	public void setPortname(String portname) {
		this.portname = portname;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((mapped_port == null) ? 0 : mapped_port.hashCode());
		result = prime * result + ((node == null) ? 0 : node.hashCode());
		result = prime * result + ((portname == null) ? 0 : portname.hashCode());
		result = prime * result + ((state == null) ? 0 : state.hashCode());
		result = prime * result + ((vinterface == null) ? 0 : vinterface.hashCode());
		result = prime * result + ((vterminalName == null) ? 0 : vterminalName.hashCode());
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
		MapDetail other = (MapDetail) obj;
		if (mapped_port == null) {
			if (other.mapped_port != null)
				return false;
		} else if (!mapped_port.equals(other.mapped_port))
			return false;
		if (node == null) {
			if (other.node != null)
				return false;
		} else if (!node.equals(other.node))
			return false;
		if (portname == null) {
			if (other.portname != null)
				return false;
		} else if (!portname.equals(other.portname))
			return false;
		if (state != other.state)
			return false;
		if (vinterface == null) {
			if (other.vinterface != null)
				return false;
		} else if (!vinterface.equals(other.vinterface))
			return false;
		if (vterminalName == null) {
			if (other.vterminalName != null)
				return false;
		} else if (!vterminalName.equals(other.vterminalName))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "MapDetail [node=" + node + ", mapped_port=" + mapped_port + ", vinterface=" + vinterface
				+ ", vterminalName=" + vterminalName + ", state=" + state + ", portname=" + portname + "]";
	}
	
	
	

}
