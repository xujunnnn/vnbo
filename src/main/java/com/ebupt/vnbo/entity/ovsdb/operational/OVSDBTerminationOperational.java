package com.ebupt.vnbo.entity.ovsdb.operational;

import com.alibaba.fastjson.annotation.JSONField;

public class OVSDBTerminationOperational {
	@JSONField(name="tp-id")
	private String tp_id;
	@JSONField(name="ovsdb:name")
	private String name;
	@JSONField(name="ovsdb:ofport")
	private String ofport;
	@JSONField(name="ovsdb:ingress-policing-rate")
	private String ingress_policing_rate;
	@JSONField(name="ovsdb:ingress-policing-burs")
	private String ingress_policing_burst;
	public String getTp_id() {
		return tp_id;
	}
	public void setTp_id(String tp_id) {
		this.tp_id = tp_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getOfport() {
		return ofport;
	}
	public void setOfport(String ofport) {
		this.ofport = ofport;
	}
	public String getIngress_policing_rate() {
		return ingress_policing_rate;
	}
	public void setIngress_policing_rate(String ingress_policing_rate) {
		this.ingress_policing_rate = ingress_policing_rate;
	}
	public String getIngress_policing_burst() {
		return ingress_policing_burst;
	}
	public void setIngress_policing_burst(String ingress_policing_burst) {
		this.ingress_policing_burst = ingress_policing_burst;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((ingress_policing_burst == null) ? 0 : ingress_policing_burst.hashCode());
		result = prime * result + ((ingress_policing_rate == null) ? 0 : ingress_policing_rate.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((ofport == null) ? 0 : ofport.hashCode());
		result = prime * result + ((tp_id == null) ? 0 : tp_id.hashCode());
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
		OVSDBTerminationOperational other = (OVSDBTerminationOperational) obj;
		if (ingress_policing_burst == null) {
			if (other.ingress_policing_burst != null)
				return false;
		} else if (!ingress_policing_burst.equals(other.ingress_policing_burst))
			return false;
		if (ingress_policing_rate == null) {
			if (other.ingress_policing_rate != null)
				return false;
		} else if (!ingress_policing_rate.equals(other.ingress_policing_rate))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (ofport == null) {
			if (other.ofport != null)
				return false;
		} else if (!ofport.equals(other.ofport))
			return false;
		if (tp_id == null) {
			if (other.tp_id != null)
				return false;
		} else if (!tp_id.equals(other.tp_id))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "OVSDBTerminationOperational [tp_id=" + tp_id + ", name=" + name + ", ofport=" + ofport
				+ ", ingress_policing_rate=" + ingress_policing_rate + ", ingress_policing_burst="
				+ ingress_policing_burst + "]";
	}
	
	
	

}
