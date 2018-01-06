package com.ebupt.vnbo.entity.ovsdb.operational;

public class OVSDBManageEntry {
	private String target;
	private String number_of_connections;
	private boolean connected;
	public String getTarget() {
		return target;
	}
	public void setTarget(String target) {
		this.target = target;
	}
	public String getNumber_of_connections() {
		return number_of_connections;
	}
	public void setNumber_of_connections(String number_of_connections) {
		this.number_of_connections = number_of_connections;
	}
	public boolean isConnected() {
		return connected;
	}
	public void setConnected(boolean connected) {
		this.connected = connected;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (connected ? 1231 : 1237);
		result = prime * result + ((number_of_connections == null) ? 0 : number_of_connections.hashCode());
		result = prime * result + ((target == null) ? 0 : target.hashCode());
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
		OVSDBManageEntry other = (OVSDBManageEntry) obj;
		if (connected != other.connected)
			return false;
		if (number_of_connections == null) {
			if (other.number_of_connections != null)
				return false;
		} else if (!number_of_connections.equals(other.number_of_connections))
			return false;
		if (target == null) {
			if (other.target != null)
				return false;
		} else if (!target.equals(other.target))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "OVSDBManageEntry [target=" + target + ", number_of_connections=" + number_of_connections
				+ ", connected=" + connected + "]";
	}
	

}
