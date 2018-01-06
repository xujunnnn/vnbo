package com.ebupt.vnbo.entity.flow_filter;

import com.alibaba.fastjson.annotation.JSONField;

/*
 "vtn-push-vlan-action": {
    "vlan-type": "VLAN"
}
 */
public class Vtn_Push_Vlan_Action {
	@JSONField(name="vlan-type")
	private String vlan_type;
	
	public String getVlan_type() {return this.vlan_type;}
	public void setVlan_type(String vlan_type) {this.vlan_type=vlan_type;}
}
