package com.ebupt.vnbo.entity.sfc;

import com.alibaba.fastjson.annotation.JSONField;
import com.ebupt.vnbo.entity.enums.EtherType;
import com.ebupt.vnbo.entity.enums.Protocol_Type;
import com.ebupt.vnbo.entity.flow_condition.Port_Range;

public class SFCCondition {
	private String srcMac;
	private String destMac;
	private EtherType etherType;	
	
	private String srcIp;
	private String destIp;
	private Protocol_Type protocol;
	
	
	private Port_Range udp_source_range;
	private Port_Range  udp_destination_range;	
	private Port_Range  tcp_source_range;	
	private Port_Range tcp_destination_range;
	public String getSrcMac() {
		return srcMac;
	}
	public void setSrcMac(String srcMac) {
		this.srcMac = srcMac;
	}
	public String getDestMac() {
		return destMac;
	}
	public void setDestMac(String destMac) {
		this.destMac = destMac;
	}
	public EtherType getEtherType() {
		return etherType;
	}
	public void setEtherType(EtherType etherType) {
		this.etherType = etherType;
	}
	public String getSrcIp() {
		return srcIp;
	}
	public void setSrcIp(String srcIp) {
		this.srcIp = srcIp;
	}
	public String getDestIp() {
		return destIp;
	}
	public void setDestIp(String destIp) {
		this.destIp = destIp;
	}
	public Protocol_Type getProtocol() {
		return protocol;
	}
	public void setProtocol(Protocol_Type protocol) {
		this.protocol = protocol;
	}
	public Port_Range getUdp_source_range() {
		return udp_source_range;
	}
	public void setUdp_source_range(Port_Range udp_source_range) {
		this.udp_source_range = udp_source_range;
	}
	public Port_Range getUdp_destination_range() {
		return udp_destination_range;
	}
	public void setUdp_destination_range(Port_Range udp_destination_range) {
		this.udp_destination_range = udp_destination_range;
	}
	public Port_Range getTcp_source_range() {
		return tcp_source_range;
	}
	public void setTcp_source_range(Port_Range tcp_source_range) {
		this.tcp_source_range = tcp_source_range;
	}
	public Port_Range getTcp_destination_range() {
		return tcp_destination_range;
	}
	public void setTcp_destination_range(Port_Range tcp_destination_range) {
		this.tcp_destination_range = tcp_destination_range;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((destIp == null) ? 0 : destIp.hashCode());
		result = prime * result + ((destMac == null) ? 0 : destMac.hashCode());
		result = prime * result + ((etherType == null) ? 0 : etherType.hashCode());
		result = prime * result + ((protocol == null) ? 0 : protocol.hashCode());
		result = prime * result + ((srcIp == null) ? 0 : srcIp.hashCode());
		result = prime * result + ((srcMac == null) ? 0 : srcMac.hashCode());
		result = prime * result + ((tcp_destination_range == null) ? 0 : tcp_destination_range.hashCode());
		result = prime * result + ((tcp_source_range == null) ? 0 : tcp_source_range.hashCode());
		result = prime * result + ((udp_destination_range == null) ? 0 : udp_destination_range.hashCode());
		result = prime * result + ((udp_source_range == null) ? 0 : udp_source_range.hashCode());
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
		SFCCondition other = (SFCCondition) obj;
		if (destIp == null) {
			if (other.destIp != null)
				return false;
		} else if (!destIp.equals(other.destIp))
			return false;
		if (destMac == null) {
			if (other.destMac != null)
				return false;
		} else if (!destMac.equals(other.destMac))
			return false;
		if (etherType != other.etherType)
			return false;
		if (protocol != other.protocol)
			return false;
		if (srcIp == null) {
			if (other.srcIp != null)
				return false;
		} else if (!srcIp.equals(other.srcIp))
			return false;
		if (srcMac == null) {
			if (other.srcMac != null)
				return false;
		} else if (!srcMac.equals(other.srcMac))
			return false;
		if (tcp_destination_range == null) {
			if (other.tcp_destination_range != null)
				return false;
		} else if (!tcp_destination_range.equals(other.tcp_destination_range))
			return false;
		if (tcp_source_range == null) {
			if (other.tcp_source_range != null)
				return false;
		} else if (!tcp_source_range.equals(other.tcp_source_range))
			return false;
		if (udp_destination_range == null) {
			if (other.udp_destination_range != null)
				return false;
		} else if (!udp_destination_range.equals(other.udp_destination_range))
			return false;
		if (udp_source_range == null) {
			if (other.udp_source_range != null)
				return false;
		} else if (!udp_source_range.equals(other.udp_source_range))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "SFCCondition [srcMac=" + srcMac + ", destMac=" + destMac + ", etherType=" + etherType + ", srcIp="
				+ srcIp + ", destIp=" + destIp + ", protocol=" + protocol + ", udp_source_range=" + udp_source_range
				+ ", udp_destination_range=" + udp_destination_range + ", tcp_source_range=" + tcp_source_range
				+ ", tcp_destination_range=" + tcp_destination_range + "]";
	}
	
	
	

}
