package com.ebupt.vnbo.entity.vtn;

import java.util.List;

import com.alibaba.fastjson.annotation.JSONField;
import com.ebupt.vnbo.entity.flow_filter.Vtn_Flow_Filter;

public class Vinterface_input_filter {
	@JSONField(name="vtn-flow-filter")
	private List<Vtn_Flow_Filter> vtn_Flow_Filter;

	public List<Vtn_Flow_Filter> getVtn_Flow_Filter() {
		return vtn_Flow_Filter;
	}

	public void setVtn_Flow_Filter(List<Vtn_Flow_Filter> vtn_Flow_Filter) {
		this.vtn_Flow_Filter = vtn_Flow_Filter;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((vtn_Flow_Filter == null) ? 0 : vtn_Flow_Filter.hashCode());
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
		Vinterface_input_filter other = (Vinterface_input_filter) obj;
		if (vtn_Flow_Filter == null) {
			if (other.vtn_Flow_Filter != null)
				return false;
		} else if (!vtn_Flow_Filter.equals(other.vtn_Flow_Filter))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Vinterface_input_filter [vtn_Flow_Filter=" + vtn_Flow_Filter + "]";
	}
	
	

}
