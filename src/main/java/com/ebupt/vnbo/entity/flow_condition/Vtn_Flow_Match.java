package com.ebupt.vnbo.entity.flow_condition;
import com.alibaba.fastjson.annotation.JSONField;

/*
{
    "input": {
        "vtn-flow-match": [
            {
                "index": "1",
                "vtn-ether-match": {
                    "source-address": "1"
                },
                "vtn-inet-match": {
                    "source-network": "1"
                },
                "icmp-type": "1",
                "icmp-code": "1"
                "udp-source-range": {
                    "port-from": "1",
                    "port-to": "1"
                },
                "udp-destination-range": {
                    "port-from": "1",
                    "port-to": "1"
                }
            }
                  "tcp-source-range": {
                    "port-from": "1",
                    "port-to": "1"
                },
                "tcp-destination-range": {
                    "port-from": "1",
                    "port-to": "1"
                }
        ]
    }
}
 */
public class Vtn_Flow_Match {

	private String index;
	@JSONField(name="vtn-ether-match")
	private Vtn_Ether_Match vtn_ether_match;
	@JSONField(name="vtn-inet-match")
	private Vtn_Inet_Match vtn_inet_match;
	@JSONField(name="udp-source-range")
	private Port_Range udp_source_range;
	@JSONField(name="udp-destination-range")
	private Port_Range  udp_destination_range;
	@JSONField(name="tcp-source-range")
	private Port_Range  tcp_source_range;
	@JSONField(name="tcp-destination-range")
	private Port_Range tcp_destination_range;
	@JSONField(name="icmp-type")
	private String icmp_type;
	@JSONField(name="icmp-code")
	private String icmp_code;
	
	public String getIndex() {return index;}
	public void setIndex(String index) {this.index=index;}

	public Vtn_Ether_Match getVtn_ether_match(){
		return vtn_ether_match;
	}
	public void setVtn_ether_match(Vtn_Ether_Match vtn_ether_match){
		this.vtn_ether_match=vtn_ether_match;
	}
	
	public Vtn_Inet_Match getVtn_inet_match(){
		return vtn_inet_match;
	}
	public void setVtn_inet_match(Vtn_Inet_Match vtn_inet_match){
		this.vtn_inet_match=vtn_inet_match;
	}	
	
	public Port_Range getUdp_source_range() {
		return 	udp_source_range;
	}
	public void setUdp_source_range(Port_Range udp_source_range) {
		this.udp_source_range=udp_source_range;
	}
	
	public Port_Range getUdp_destination_range() {
		return 	udp_destination_range;
	}
	public void setUdp_destination_range(Port_Range udp_destination_range) {
		this.udp_destination_range=udp_destination_range;
	}
	
	public Port_Range getTcp_source_range() {
		return 	tcp_source_range;
	}
	public void setTcp_source_range(Port_Range tcp_source_range) {
		this.tcp_source_range=tcp_source_range;
	}
	
	public Port_Range getTcp_destination_range() {
		return 	tcp_destination_range;
	}
	public void setTcp_destination_range(Port_Range tcp_destination_range) {
		this.tcp_destination_range=tcp_destination_range;
	}
	
	public String getIcmp_type() {return icmp_type;}
	public void setIcmp_type(String icmp_type) {this.icmp_type=icmp_type;}
	
	public String getIcmp_code() {return icmp_code;}
	public void setIcmp_code(String icmp_code) {this.icmp_code=icmp_code;}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((icmp_code == null) ? 0 : icmp_code.hashCode());
		result = prime * result + ((icmp_type == null) ? 0 : icmp_type.hashCode());
		result = prime * result + ((index == null) ? 0 : index.hashCode());
		result = prime * result + ((tcp_destination_range == null) ? 0 : tcp_destination_range.hashCode());
		result = prime * result + ((tcp_source_range == null) ? 0 : tcp_source_range.hashCode());
		result = prime * result + ((udp_destination_range == null) ? 0 : udp_destination_range.hashCode());
		result = prime * result + ((udp_source_range == null) ? 0 : udp_source_range.hashCode());
		result = prime * result + ((vtn_ether_match == null) ? 0 : vtn_ether_match.hashCode());
		result = prime * result + ((vtn_inet_match == null) ? 0 : vtn_inet_match.hashCode());
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
		Vtn_Flow_Match other = (Vtn_Flow_Match) obj;
		if (icmp_code == null) {
			if (other.icmp_code != null)
				return false;
		} else if (!icmp_code.equals(other.icmp_code))
			return false;
		if (icmp_type == null) {
			if (other.icmp_type != null)
				return false;
		} else if (!icmp_type.equals(other.icmp_type))
			return false;
		if (index == null) {
			if (other.index != null)
				return false;
		} else if (!index.equals(other.index))
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
		if (vtn_ether_match == null) {
			if (other.vtn_ether_match != null)
				return false;
		} else if (!vtn_ether_match.equals(other.vtn_ether_match))
			return false;
		if (vtn_inet_match == null) {
			if (other.vtn_inet_match != null)
				return false;
		} else if (!vtn_inet_match.equals(other.vtn_inet_match))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Vtn_Flow_Match [index=" + index + ", vtn_ether_match=" + vtn_ether_match + ", vtn_inet_match="
				+ vtn_inet_match + ", udp_source_range=" + udp_source_range + ", udp_destination_range="
				+ udp_destination_range + ", tcp_source_range=" + tcp_source_range + ", tcp_destination_range="
				+ tcp_destination_range + ", icmp_type=" + icmp_type + ", icmp_code=" + icmp_code + "]";
	}	
	
	
	
	
}


