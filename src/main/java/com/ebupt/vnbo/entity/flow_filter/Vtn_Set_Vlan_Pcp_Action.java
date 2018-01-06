package com.ebupt.vnbo.entity.flow_filter;

import com.alibaba.fastjson.annotation.JSONField;

/*
 "vtn-set-vlan-pcp-action": {
    "vlan-pcp": "1"
}
 */
public class Vtn_Set_Vlan_Pcp_Action {
	@JSONField(name="vtn-set-vlan-pcp-action")
	private String set_vlan_pcp_action;
	
	public String getSet_vlan_pcp_action() {return this.set_vlan_pcp_action;}
	public void setSet_vlan_pcp_action(String set_vlan_pcp_action) {this.set_vlan_pcp_action=set_vlan_pcp_action;}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((set_vlan_pcp_action == null) ? 0 : set_vlan_pcp_action.hashCode());
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
		Vtn_Set_Vlan_Pcp_Action other = (Vtn_Set_Vlan_Pcp_Action) obj;
		if (set_vlan_pcp_action == null) {
			if (other.set_vlan_pcp_action != null)
				return false;
		} else if (!set_vlan_pcp_action.equals(other.set_vlan_pcp_action))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Vtn_Set_Vlan_Pcp_Action [set_vlan_pcp_action=" + set_vlan_pcp_action + "]";
	}
	
}
