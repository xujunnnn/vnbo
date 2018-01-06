package com.ebupt.vnbo.entity.ovsdb.config;

public class OVSDBProtocolEntryConfig {
	private String protocol;

	@Override
	public String toString() {
		return "OVSDBProtocolEntryConfig [protocol=" + protocol + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((protocol == null) ? 0 : protocol.hashCode());
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
		OVSDBProtocolEntryConfig other = (OVSDBProtocolEntryConfig) obj;
		if (protocol == null) {
			if (other.protocol != null)
				return false;
		} else if (!protocol.equals(other.protocol))
			return false;
		return true;
	}

	public String getProtocol() {
		return protocol;
	}

	public void setProtocol(String protocol) {
		this.protocol = protocol;
	}
	

}
