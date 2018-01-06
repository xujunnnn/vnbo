package com.ebupt.vnbo.entity.ovsdb.config;

public class OVSDBControllerEntryConfig {
	private String target;
	public OVSDBControllerEntryConfig(String ip) {
		// TODO Auto-generated constructor stub
		this.target="tcp:"+ip+":6633";
	}
	
	public String getTarget() {
		return target;
	}

	public void setTarget(String target) {
		this.target = target;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((target == null) ? 0 : target.hashCode());
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
		OVSDBControllerEntryConfig other = (OVSDBControllerEntryConfig) obj;
		if (target == null) {
			if (other.target != null)
				return false;
		} else if (!target.equals(other.target))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "OVSDBControllerEntryConfig [target=" + target + "]";
	}
	
	

}
