package com.ebupt.vnbo.entity.sfc;

import com.alibaba.fastjson.JSON;
public class SfcSave {
	private ServiceFunctionChain sfc;
	private String domain;
	private String name;
	private String json;
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((domain == null) ? 0 : domain.hashCode());
		result = prime * result + ((json == null) ? 0 : json.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
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
		SfcSave other = (SfcSave) obj;
		if (domain == null) {
			if (other.domain != null)
				return false;
		} else if (!domain.equals(other.domain))
			return false;
		if (json == null) {
			if (other.json != null)
				return false;
		} else if (!json.equals(other.json))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
	public SfcSave() {
		// TODO Auto-generated constructor stub
	}
	public SfcSave(ServiceFunctionChain sfc) {
		// TODO Auto-generated constructor stub
		this.sfc=sfc;
		this.name=sfc.getName();
		this.json=JSON.toJSONString(sfc);
		this.domain=sfc.getVtopoName();
		
	}

	public ServiceFunctionChain toSFC(){
		ServiceFunctionChain sfc=JSON.parseObject(json, ServiceFunctionChain.class);
		return sfc;
	}
}
