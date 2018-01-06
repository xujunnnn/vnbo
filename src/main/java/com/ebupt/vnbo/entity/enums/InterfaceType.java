package com.ebupt.vnbo.entity.enums;

public enum InterfaceType {
	VXLAN("ovsdb:interface-type-vxlan"),PATACH("ovsdb:interface-type-patch"),GRE("ovsdb:interface-type-gre");
	private String value;
	private InterfaceType(String value) {
		// TODO Auto-generated constructor stub
		this.value=value;
	}
	public String value(){
		return value;
	}

}
