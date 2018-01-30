package com.ebupt.vnbo.entity.enums;

public enum EtherType {
	
	IPV4("2048"),
	ARP("2054"),
	VLAN_TAGED("33024"),
	LLDP("35020");
	
	String value;
	private EtherType(String value) {
		// TODO Auto-generated constructor stub
		this.value=value;
	}
	
	public String value(){
		return value;
	}
	
	public static EtherType Valueof(String value){
		switch (value) {
		case "2048":{
			return IPV4;
		}
		case "2054":	
			return ARP;
		case "33024":
			return VLAN_TAGED;
		case "35020":
			return LLDP;
		default:
			return IPV4;
		}
	}
	

}
