package com.ebupt.vnbo.entity.enums;

public enum EtherType {
	
	IPV4("0x0800"),
	ARP("0x0806"),
	VLAN_TAGED("0x8100");
	
	String value;
	private EtherType(String value) {
		// TODO Auto-generated constructor stub
		this.value=value;
	}
	
	public String value(){
		return value;
	}
	
	

}
