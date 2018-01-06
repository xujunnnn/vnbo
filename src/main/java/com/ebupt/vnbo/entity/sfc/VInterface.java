package com.ebupt.vnbo.entity.sfc;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;

public class VInterface {
	@JsonProperty("vtopo")
	private String vtopoName;
	@JsonProperty("vGroup")
	private String vbridgeName;
	private String vInterface;
	public String getVtopoName() {
		return vtopoName;
	}
	public void setVtopoName(String vtopoName) {
		this.vtopoName = vtopoName;
	}
	public String getVbridgeName() {
		return vbridgeName;
	}
	public void setVbridgeName(String vbridgeName) {
		this.vbridgeName = vbridgeName;
	}
	public String getvInterface() {
		return vInterface;
	}
	public void setvInterface(String vInterface) {
		this.vInterface = vInterface;
	}
	@Override
	public String toString() {
		return "VInterface [vtopoName=" + vtopoName + ", vbridgeName=" + vbridgeName + ", vInterface=" + vInterface
				+ "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((vInterface == null) ? 0 : vInterface.hashCode());
		result = prime * result + ((vbridgeName == null) ? 0 : vbridgeName.hashCode());
		result = prime * result + ((vtopoName == null) ? 0 : vtopoName.hashCode());
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
		VInterface other = (VInterface) obj;
		if (vInterface == null) {
			if (other.vInterface != null)
				return false;
		} else if (!vInterface.equals(other.vInterface))
			return false;
		if (vbridgeName == null) {
			if (other.vbridgeName != null)
				return false;
		} else if (!vbridgeName.equals(other.vbridgeName))
			return false;
		if (vtopoName == null) {
			if (other.vtopoName != null)
				return false;
		} else if (!vtopoName.equals(other.vtopoName))
			return false;
		return true;
	}
	

	
	
 
}
