package com.ebupt.vnbo.entity.flow_filter;
import java.util.List;
import com.alibaba.fastjson.annotation.JSONField;
/*
    "vtn-flow-filter": [
        {
            "condition": "cond_1",
            "vtn-drop-filter": {},
            "vtn-pass-filter": {},
             "vtn-redirect-filter": {
                    "redirect-destination": {
                        "tenant-name": "1",
                        "bridge-name": "1",
                        "router-name": "1",
                        "terminal-name": "1",
                        "interface-name": "1"
                    },
                    "output": "true"
                },
            "index": "1",
            "vtn-flow-action": [
                {
                    "order": "2",
                    "vtn-drop-action": {}
                }
            ]
        }
    ]
 */

public class Vtn_Flow_Filter{
	private String index;
	private String condition;
	@JSONField(name="vtn-drop-filter")
	private Vacant vtn_drop_filter;
	@JSONField(name="vtn-pass-filter")
	private Vacant vtn_pass_filter;
	@JSONField(name="vtn-redirect-filter")
	private Vtn_Redirect_Filter vtn_redirect_filter;
	@JSONField(name="vtn-flow-action")
	private List<Vtn_Flow_Action> vtn_flow_action;

	
	public String getIndex() {
		return index;
	}
	public void setIndex(String index) {
		this.index = index;
	}
	public String getCondition() {
		return condition;
	}
	public void setCondition(String condition) {
		this.condition = condition;
	}
	public Vacant getVtn_drop_filter() {
		return vtn_drop_filter;
	}
	public void setVtn_drop_filter(Vacant vtn_drop_filter) {
		this.vtn_drop_filter = vtn_drop_filter;
	}
	public Vacant getVtn_pass_filter() {
		return vtn_pass_filter;
	}
	public void setVtn_pass_filter(Vacant vtn_pass_filter) {
		this.vtn_pass_filter = vtn_pass_filter;
	}
	public Vtn_Redirect_Filter getVtn_redirect_filter() {
		return vtn_redirect_filter;
	}
	public void setVtn_redirect_filter(Vtn_Redirect_Filter vtn_redirect_filter) {
		this.vtn_redirect_filter = vtn_redirect_filter;
	}
	public List<Vtn_Flow_Action> getVtn_flow_action() {
		return vtn_flow_action;
	}
	public void setVtn_flow_action(List<Vtn_Flow_Action> vtn_flow_action) {
		this.vtn_flow_action = vtn_flow_action;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((condition == null) ? 0 : condition.hashCode());
		result = prime * result + ((index == null) ? 0 : index.hashCode());
		result = prime * result + ((vtn_drop_filter == null) ? 0 : vtn_drop_filter.hashCode());
		result = prime * result + ((vtn_flow_action == null) ? 0 : vtn_flow_action.hashCode());
		result = prime * result + ((vtn_pass_filter == null) ? 0 : vtn_pass_filter.hashCode());
		result = prime * result + ((vtn_redirect_filter == null) ? 0 : vtn_redirect_filter.hashCode());
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
		Vtn_Flow_Filter other = (Vtn_Flow_Filter) obj;
		if (condition == null) {
			if (other.condition != null)
				return false;
		} else if (!condition.equals(other.condition))
			return false;
		if (index == null) {
			if (other.index != null)
				return false;
		} else if (!index.equals(other.index))
			return false;
		if (vtn_drop_filter == null) {
			if (other.vtn_drop_filter != null)
				return false;
		} else if (!vtn_drop_filter.equals(other.vtn_drop_filter))
			return false;
		if (vtn_flow_action == null) {
			if (other.vtn_flow_action != null)
				return false;
		} else if (!vtn_flow_action.equals(other.vtn_flow_action))
			return false;
		if (vtn_pass_filter == null) {
			if (other.vtn_pass_filter != null)
				return false;
		} else if (!vtn_pass_filter.equals(other.vtn_pass_filter))
			return false;
		if (vtn_redirect_filter == null) {
			if (other.vtn_redirect_filter != null)
				return false;
		} else if (!vtn_redirect_filter.equals(other.vtn_redirect_filter))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Vtn_Flow_Filter [index=" + index + ", condition=" + condition + ", vtn_drop_filter=" + vtn_drop_filter
				+ ", vtn_pass_filter=" + vtn_pass_filter + ", vtn_redirect_filter=" + vtn_redirect_filter
				+ ", vtn_flow_action=" + vtn_flow_action + "]";
	}
	
	
	
}
