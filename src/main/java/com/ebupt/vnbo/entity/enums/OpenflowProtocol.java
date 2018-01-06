package com.ebupt.vnbo.entity.enums;

public enum OpenflowProtocol {
	OpenFlow13("ovsdb:ovsdb-bridge-protocol-openflow-13"),OpenFlow10("ovsdb:ovsdb-bridge-protocol-openflow-10");
	private String value;
	OpenflowProtocol(String value){
		this.value=value;		
	}
	public String value(){
		return value;
	}

}
