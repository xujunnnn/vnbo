package com.ebupt.vnbo.entity.node_static;

public class Packets {
	private long received;
	private long transmitted;
	public long getReceived() {
		return received;
	}
	public void setReceived(long received) {
		this.received = received;
	}
	public long getTransmitted() {
		return transmitted;
	}
	public void setTransmitted(long transmitted) {
		this.transmitted = transmitted;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (received ^ (received >>> 32));
		result = prime * result + (int) (transmitted ^ (transmitted >>> 32));
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
		Packets other = (Packets) obj;
		if (received != other.received)
			return false;
		if (transmitted != other.transmitted)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Packets [received=" + received + ", transmitted=" + transmitted + "]";
	}
	
	

}
