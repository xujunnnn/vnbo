package com.ebupt.vnbo.entity.flow_condition;

import com.alibaba.fastjson.annotation.JSONField;

/*
 "vtn-ether-match": {
    "source-address": "1",
    "destination-address": "1",
    "ether-type": "1",
    "vlan-id": "1",
    "vlan-pcp": "1"
}
 */
public class Vtn_Ether_Match {
	@JSONField(name="source-address")
	private String source_address;
	@JSONField(name="destination-address")
	private String destination_address;
	@JSONField(name="ether-type")
	private String ether_type;
	@JSONField(name="vlan-id")
	private String vlan_id;
	@JSONField(name="vlan-pcp")
	private String vlan_pcp;
	
	public String getSource_address() {return this.source_address;}
	public void setSource_address(String source_address) {this.source_address=source_address;}
	public String getDestination_address() {return this.destination_address;}
	public void setDestination_address(String destination_address) {this.destination_address=destination_address;}
	public String getEther_type() {return this.ether_type;}
	public void setEther_type(String ether_type) {this.ether_type=ether_type;}
	public String getVlan_id() {return this.vlan_id;}
	public void setVlan_id(String vlan_id) {this.vlan_id=vlan_id;}
	public String getVlan_pcp() {return this.vlan_pcp;}
	public void setVlan_pcp(String vlan_pcp) {this.vlan_pcp=vlan_pcp;}
	
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((destination_address == null) ? 0 : destination_address.hashCode());
		result = prime * result + ((ether_type == null) ? 0 : ether_type.hashCode());
		result = prime * result + ((source_address == null) ? 0 : source_address.hashCode());
		result = prime * result + ((vlan_id == null) ? 0 : vlan_id.hashCode());
		result = prime * result + ((vlan_pcp == null) ? 0 : vlan_pcp.hashCode());
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
		Vtn_Ether_Match other = (Vtn_Ether_Match) obj;
		if (destination_address == null) {
			if (other.destination_address != null)
				return false;
		} else if (!destination_address.equals(other.destination_address))
			return false;
		if (ether_type == null) {
			if (other.ether_type != null)
				return false;
		} else if (!ether_type.equals(other.ether_type))
			return false;
		if (source_address == null) {
			if (other.source_address != null)
				return false;
		} else if (!source_address.equals(other.source_address))
			return false;
		if (vlan_id == null) {
			if (other.vlan_id != null)
				return false;
		} else if (!vlan_id.equals(other.vlan_id))
			return false;
		if (vlan_pcp == null) {
			if (other.vlan_pcp != null)
				return false;
		} else if (!vlan_pcp.equals(other.vlan_pcp))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Vtn_Ether_Match [source_address=" + source_address + ",destination_address="+destination_address
				+",ether_type="+ether_type+",vlan_id="+vlan_id+",vlan_pcp="+vlan_pcp+"]";
	}
	
}
