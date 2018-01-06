package com.ebupt.vnbo.entity.sfc;

import org.springframework.core.annotation.Order;

import com.alibaba.fastjson.JSON;
public class SfcSave {
	private ServiceFunctionChain sfc;
	private String name;
	private String json;
	
	public SfcSave() {
		// TODO Auto-generated constructor stub
	}
	
	
	public SfcSave(ServiceFunctionChain sfc) {
		// TODO Auto-generated constructor stub
		this.sfc=sfc;
		this.name=sfc.getName();
		this.json=JSON.toJSONString(sfc);
		
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getJson() {
		return json;
	}


	public void setJson(String json) {
		this.json = json;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((json == null) ? 0 : json.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((sfc == null) ? 0 : sfc.hashCode());
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
		if (sfc == null) {
			if (other.sfc != null)
				return false;
		} else if (!sfc.equals(other.sfc))
			return false;
		return true;
	}


	@Override
	public String toString() {
		return "SfcSave [sfc=" + sfc + ", name=" + name + ", json=" + json + "]";
	} 
	
	public ServiceFunctionChain toSFC(){
		ServiceFunctionChain sfc=JSON.parseObject(json, ServiceFunctionChain.class);
		return sfc;
	}
}
