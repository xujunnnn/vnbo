package com.ebupt.vnbo.entity.flow_filter;

import com.alibaba.fastjson.annotation.JSONField;

/*
 "vtn-flow-action": [
                     {
                        "vtn-set-queue-action": {
                            "queue": "1",
                            "queue-id": "2"
                        },
                        "order": "0"
                    },
                    {
                        "order": "0",
                        "vtn-drop-action": {}
                    },
                    {
                        "order": "1",
                        "vtn-pop-vlan-action": {}
                    },
                    {
                        "order": "2",
                        "vtn-push-vlan-action": {
                            "vlan-type": "VLAN"
                        }
                    },
                    {
                        "order": "3",
                        "vtn-set-dl-dst-action": {
                            "address": "00:00:00:00:00:01"
                        }
                    },
                    {
                        "order": "4",
                        "vtn-set-dl-src-action": {
                            "address": "00:00:00:00:00:02"
                        }
                    },
                    {
                        "order": "5",
                        "vtn-set-icmp-code-action": {
                            "code": "1"
                        }
                    },
                    {
                        "order": "6",
                        "vtn-set-icmp-type-action": {
                            "type": "2048"
                        }
                    },
                    {
                        "order": "7",
                        "vtn-set-inet-dscp-action": {
                            "dscp": "31"
                        }
                    },
                    {
                        "order": "8",
                        "vtn-set-inet-dst-action": {
                            "ipv4-address": "10.0.0.1"
                        }
                    },
                    {
                        "order": "9",
                        "vtn-set-inet-src-action": {
                            "ipv6-address": "fe80::b410:aaff:fe8a:a001/64"
                        }
                    },
                    {
                        "order": "10",
                        "vtn-set-port-dst-action": {
                            "port": "5901"
                        }
                    },
                    {
                        "order": "11",
                        "vtn-set-port-src-action": {
                            "port": "35771"
                        }
                    },
                    {
                        "order": "12",
                        "vtn-set-vlan-id-action": {
                            "vlan-id": "1"
                        }
                    },
                    {
                        "order": "13",
                        "vtn-set-vlan-pcp-action": {
                            "vlan-pcp": "1"
                        }
                    }
                ]
 */
public class Vtn_Flow_Action {
	private String order;
	@JSONField(name="vtn-set-queue-action")
	private Vtn_Set_Queue_Action vtn_set_queue_action;
	
	@JSONField(name="vtn-drop-action")
	private Vacant vtn_drop_action;
	@JSONField(name="vtn-pop-vlan-action")
	private Vacant vtn_pop_vlan_action;
	@JSONField(name="vtn-push-vlan-action")
	private Vtn_Push_Vlan_Action vtn_push_vlan_action;
	
	@JSONField(name="vtn-set-dl-dst-action")
	private Vtn_Set_Dl_Addr_Action vtn_set_dl_dst_action;
	@JSONField(name="vtn-set-dl-src-action")
	private Vtn_Set_Dl_Addr_Action vtn_set_dl_src_action;
	@JSONField(name="vtn-set-icmp-code-action")
	private Vtn_Set_Icmp_Code_Action vtn_set_icmp_code_action;
	
	@JSONField(name="vtn-set-icmp-type-action")
	private Vtn_Set_Icmp_Type_Action vtn_set_icmp_type_action;
	@JSONField(name="vtn-set-inet-dscp-action")
	private Vtn_Set_Inet_Dscp_Action vtn_set_inet_dscp_action;
	@JSONField(name="vtn-set-inet-dst-action")
	private Vtn_Set_Inet_Addr_Action vtn_set_inet_dst_action;
	
	@JSONField(name="vtn-set-inet-src-action")
	private Vtn_Set_Inet_Addr_Action vtn_set_inet_src_action;
	@JSONField(name="vtn-set-port-dst-action")
	private Vtn_Set_Port_Addr_Action vtn_set_port_dst_action;
	@JSONField(name="vtn-set-port-src-action")
	private Vtn_Set_Port_Addr_Action vtn_set_port_src_action;
	
	@JSONField(name="vtn-set-vlan-id-action")
	private Vtn_Set_Vlan_Id_Action vtn_set_vlan_id_action;
	@JSONField(name="vtn-set-vlan-pcp-action")
	private Vtn_Set_Vlan_Pcp_Action vtn_set_vlan_pcp_action;
	public String getOrder() {
		return order;
	}
	public void setOrder(String order) {
		this.order = order;
	}
	public Vtn_Set_Queue_Action getVtn_set_queue_action() {
		return vtn_set_queue_action;
	}
	public void setVtn_set_queue_action(Vtn_Set_Queue_Action vtn_set_queue_action) {
		this.vtn_set_queue_action = vtn_set_queue_action;
	}
	public Vacant getVtn_drop_action() {
		return vtn_drop_action;
	}
	public void setVtn_drop_action(Vacant vtn_drop_action) {
		this.vtn_drop_action = vtn_drop_action;
	}
	public Vacant getVtn_pop_vlan_action() {
		return vtn_pop_vlan_action;
	}
	public void setVtn_pop_vlan_action(Vacant vtn_pop_vlan_action) {
		this.vtn_pop_vlan_action = vtn_pop_vlan_action;
	}
	public Vtn_Push_Vlan_Action getVtn_push_vlan_action() {
		return vtn_push_vlan_action;
	}
	public void setVtn_push_vlan_action(Vtn_Push_Vlan_Action vtn_push_vlan_action) {
		this.vtn_push_vlan_action = vtn_push_vlan_action;
	}
	public Vtn_Set_Dl_Addr_Action getVtn_set_dl_dst_action() {
		return vtn_set_dl_dst_action;
	}
	public void setVtn_set_dl_dst_action(Vtn_Set_Dl_Addr_Action vtn_set_dl_dst_action) {
		this.vtn_set_dl_dst_action = vtn_set_dl_dst_action;
	}
	public Vtn_Set_Dl_Addr_Action getVtn_set_dl_src_action() {
		return vtn_set_dl_src_action;
	}
	public void setVtn_set_dl_src_action(Vtn_Set_Dl_Addr_Action vtn_set_dl_src_action) {
		this.vtn_set_dl_src_action = vtn_set_dl_src_action;
	}
	public Vtn_Set_Icmp_Code_Action getVtn_set_icmp_code_action() {
		return vtn_set_icmp_code_action;
	}
	public void setVtn_set_icmp_code_action(Vtn_Set_Icmp_Code_Action vtn_set_icmp_code_action) {
		this.vtn_set_icmp_code_action = vtn_set_icmp_code_action;
	}
	public Vtn_Set_Icmp_Type_Action getVtn_set_icmp_type_action() {
		return vtn_set_icmp_type_action;
	}
	public void setVtn_set_icmp_type_action(Vtn_Set_Icmp_Type_Action vtn_set_icmp_type_action) {
		this.vtn_set_icmp_type_action = vtn_set_icmp_type_action;
	}
	public Vtn_Set_Inet_Dscp_Action getVtn_set_inet_dscp_action() {
		return vtn_set_inet_dscp_action;
	}
	public void setVtn_set_inet_dscp_action(Vtn_Set_Inet_Dscp_Action vtn_set_inet_dscp_action) {
		this.vtn_set_inet_dscp_action = vtn_set_inet_dscp_action;
	}
	public Vtn_Set_Inet_Addr_Action getVtn_set_inet_dst_action() {
		return vtn_set_inet_dst_action;
	}
	public void setVtn_set_inet_dst_action(Vtn_Set_Inet_Addr_Action vtn_set_inet_dst_action) {
		this.vtn_set_inet_dst_action = vtn_set_inet_dst_action;
	}
	public Vtn_Set_Inet_Addr_Action getVtn_set_inet_src_action() {
		return vtn_set_inet_src_action;
	}
	public void setVtn_set_inet_src_action(Vtn_Set_Inet_Addr_Action vtn_set_inet_src_action) {
		this.vtn_set_inet_src_action = vtn_set_inet_src_action;
	}
	public Vtn_Set_Port_Addr_Action getVtn_set_port_dst_action() {
		return vtn_set_port_dst_action;
	}
	public void setVtn_set_port_dst_action(Vtn_Set_Port_Addr_Action vtn_set_port_dst_action) {
		this.vtn_set_port_dst_action = vtn_set_port_dst_action;
	}
	public Vtn_Set_Port_Addr_Action getVtn_set_port_src_action() {
		return vtn_set_port_src_action;
	}
	public void setVtn_set_port_src_action(Vtn_Set_Port_Addr_Action vtn_set_port_src_action) {
		this.vtn_set_port_src_action = vtn_set_port_src_action;
	}
	public Vtn_Set_Vlan_Id_Action getVtn_set_vlan_id_action() {
		return vtn_set_vlan_id_action;
	}
	public void setVtn_set_vlan_id_action(Vtn_Set_Vlan_Id_Action vtn_set_vlan_id_action) {
		this.vtn_set_vlan_id_action = vtn_set_vlan_id_action;
	}
	public Vtn_Set_Vlan_Pcp_Action getVtn_set_vlan_pcp_action() {
		return vtn_set_vlan_pcp_action;
	}
	public void setVtn_set_vlan_pcp_action(Vtn_Set_Vlan_Pcp_Action vtn_set_vlan_pcp_action) {
		this.vtn_set_vlan_pcp_action = vtn_set_vlan_pcp_action;
	}
	@Override
	public String toString() {
		return "Vtn_Flow_Action [order=" + order + ", vtn_set_queue_action=" + vtn_set_queue_action
				+ ", vtn_drop_action=" + vtn_drop_action + ", vtn_pop_vlan_action=" + vtn_pop_vlan_action
				+ ", vtn_push_vlan_action=" + vtn_push_vlan_action + ", vtn_set_dl_dst_action=" + vtn_set_dl_dst_action
				+ ", vtn_set_dl_src_action=" + vtn_set_dl_src_action + ", vtn_set_icmp_code_action="
				+ vtn_set_icmp_code_action + ", vtn_set_icmp_type_action=" + vtn_set_icmp_type_action
				+ ", vtn_set_inet_dscp_action=" + vtn_set_inet_dscp_action + ", vtn_set_inet_dst_action="
				+ vtn_set_inet_dst_action + ", vtn_set_inet_src_action=" + vtn_set_inet_src_action
				+ ", vtn_set_port_dst_action=" + vtn_set_port_dst_action + ", vtn_set_port_src_action="
				+ vtn_set_port_src_action + ", vtn_set_vlan_id_action=" + vtn_set_vlan_id_action
				+ ", vtn_set_vlan_pcp_action=" + vtn_set_vlan_pcp_action + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((order == null) ? 0 : order.hashCode());
		result = prime * result + ((vtn_drop_action == null) ? 0 : vtn_drop_action.hashCode());
		result = prime * result + ((vtn_pop_vlan_action == null) ? 0 : vtn_pop_vlan_action.hashCode());
		result = prime * result + ((vtn_push_vlan_action == null) ? 0 : vtn_push_vlan_action.hashCode());
		result = prime * result + ((vtn_set_dl_dst_action == null) ? 0 : vtn_set_dl_dst_action.hashCode());
		result = prime * result + ((vtn_set_dl_src_action == null) ? 0 : vtn_set_dl_src_action.hashCode());
		result = prime * result + ((vtn_set_icmp_code_action == null) ? 0 : vtn_set_icmp_code_action.hashCode());
		result = prime * result + ((vtn_set_icmp_type_action == null) ? 0 : vtn_set_icmp_type_action.hashCode());
		result = prime * result + ((vtn_set_inet_dscp_action == null) ? 0 : vtn_set_inet_dscp_action.hashCode());
		result = prime * result + ((vtn_set_inet_dst_action == null) ? 0 : vtn_set_inet_dst_action.hashCode());
		result = prime * result + ((vtn_set_inet_src_action == null) ? 0 : vtn_set_inet_src_action.hashCode());
		result = prime * result + ((vtn_set_port_dst_action == null) ? 0 : vtn_set_port_dst_action.hashCode());
		result = prime * result + ((vtn_set_port_src_action == null) ? 0 : vtn_set_port_src_action.hashCode());
		result = prime * result + ((vtn_set_queue_action == null) ? 0 : vtn_set_queue_action.hashCode());
		result = prime * result + ((vtn_set_vlan_id_action == null) ? 0 : vtn_set_vlan_id_action.hashCode());
		result = prime * result + ((vtn_set_vlan_pcp_action == null) ? 0 : vtn_set_vlan_pcp_action.hashCode());
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
		Vtn_Flow_Action other = (Vtn_Flow_Action) obj;
		if (order == null) {
			if (other.order != null)
				return false;
		} else if (!order.equals(other.order))
			return false;
		if (vtn_drop_action == null) {
			if (other.vtn_drop_action != null)
				return false;
		} else if (!vtn_drop_action.equals(other.vtn_drop_action))
			return false;
		if (vtn_pop_vlan_action == null) {
			if (other.vtn_pop_vlan_action != null)
				return false;
		} else if (!vtn_pop_vlan_action.equals(other.vtn_pop_vlan_action))
			return false;
		if (vtn_push_vlan_action == null) {
			if (other.vtn_push_vlan_action != null)
				return false;
		} else if (!vtn_push_vlan_action.equals(other.vtn_push_vlan_action))
			return false;
		if (vtn_set_dl_dst_action == null) {
			if (other.vtn_set_dl_dst_action != null)
				return false;
		} else if (!vtn_set_dl_dst_action.equals(other.vtn_set_dl_dst_action))
			return false;
		if (vtn_set_dl_src_action == null) {
			if (other.vtn_set_dl_src_action != null)
				return false;
		} else if (!vtn_set_dl_src_action.equals(other.vtn_set_dl_src_action))
			return false;
		if (vtn_set_icmp_code_action == null) {
			if (other.vtn_set_icmp_code_action != null)
				return false;
		} else if (!vtn_set_icmp_code_action.equals(other.vtn_set_icmp_code_action))
			return false;
		if (vtn_set_icmp_type_action == null) {
			if (other.vtn_set_icmp_type_action != null)
				return false;
		} else if (!vtn_set_icmp_type_action.equals(other.vtn_set_icmp_type_action))
			return false;
		if (vtn_set_inet_dscp_action == null) {
			if (other.vtn_set_inet_dscp_action != null)
				return false;
		} else if (!vtn_set_inet_dscp_action.equals(other.vtn_set_inet_dscp_action))
			return false;
		if (vtn_set_inet_dst_action == null) {
			if (other.vtn_set_inet_dst_action != null)
				return false;
		} else if (!vtn_set_inet_dst_action.equals(other.vtn_set_inet_dst_action))
			return false;
		if (vtn_set_inet_src_action == null) {
			if (other.vtn_set_inet_src_action != null)
				return false;
		} else if (!vtn_set_inet_src_action.equals(other.vtn_set_inet_src_action))
			return false;
		if (vtn_set_port_dst_action == null) {
			if (other.vtn_set_port_dst_action != null)
				return false;
		} else if (!vtn_set_port_dst_action.equals(other.vtn_set_port_dst_action))
			return false;
		if (vtn_set_port_src_action == null) {
			if (other.vtn_set_port_src_action != null)
				return false;
		} else if (!vtn_set_port_src_action.equals(other.vtn_set_port_src_action))
			return false;
		if (vtn_set_queue_action == null) {
			if (other.vtn_set_queue_action != null)
				return false;
		} else if (!vtn_set_queue_action.equals(other.vtn_set_queue_action))
			return false;
		if (vtn_set_vlan_id_action == null) {
			if (other.vtn_set_vlan_id_action != null)
				return false;
		} else if (!vtn_set_vlan_id_action.equals(other.vtn_set_vlan_id_action))
			return false;
		if (vtn_set_vlan_pcp_action == null) {
			if (other.vtn_set_vlan_pcp_action != null)
				return false;
		} else if (!vtn_set_vlan_pcp_action.equals(other.vtn_set_vlan_pcp_action))
			return false;
		return true;
	}
	
	
}
