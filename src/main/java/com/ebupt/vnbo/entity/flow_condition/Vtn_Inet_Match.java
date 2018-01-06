package com.ebupt.vnbo.entity.flow_condition;

import com.alibaba.fastjson.annotation.JSONField;
import com.ebupt.vnbo.entity.enums.Protocol_Type;

/*
"vtn-inet-match": {
    "source-network": "11",
    "destination-network": "1",
    "protocol": "1",
    "dscp": "1"
},
 */
public class Vtn_Inet_Match {
	@JSONField(name="source-network")
	private String source_network;
	@JSONField(name="destination-network")
	private String destination_network;
	private String protocol;
	private String dscp;
	public String getSource_network() {
		return source_network;
	}
	public void setSource_network(String source_network) {
		this.source_network = source_network;
	}
	public String getDestination_network() {
		return destination_network;
	}
	public void setDestination_network(String destination_network) {
		this.destination_network = destination_network;
	}
	public String getProtocol() {
		return protocol;
	}
	public void setProtocol(String protocol) {
		this.protocol = protocol;
	}
	public String getDscp() {
		return dscp;
	}
	public void setDscp(String dscp) {
		this.dscp = dscp;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((destination_network == null) ? 0 : destination_network.hashCode());
		result = prime * result + ((dscp == null) ? 0 : dscp.hashCode());
		result = prime * result + ((protocol == null) ? 0 : protocol.hashCode());
		result = prime * result + ((source_network == null) ? 0 : source_network.hashCode());
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
		Vtn_Inet_Match other = (Vtn_Inet_Match) obj;
		if (destination_network == null) {
			if (other.destination_network != null)
				return false;
		} else if (!destination_network.equals(other.destination_network))
			return false;
		if (dscp == null) {
			if (other.dscp != null)
				return false;
		} else if (!dscp.equals(other.dscp))
			return false;
		if (protocol == null) {
			if (other.protocol != null)
				return false;
		} else if (!protocol.equals(other.protocol))
			return false;
		if (source_network == null) {
			if (other.source_network != null)
				return false;
		} else if (!source_network.equals(other.source_network))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Vtn_Inet_Match [source_network=" + source_network + ", destination_network=" + destination_network
				+ ", protocol=" + protocol + ", dscp=" + dscp + "]";
	}
	
	
}
