package com.ebupt.vnbo.entity.qos;

import com.alibaba.fastjson.JSON;

public class VqosSave {
	private Vqos vqos; 
	private String name;
	private String json;
	
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

	public VqosSave() {
		// TODO Auto-generated constructor stub
	}
	
	public VqosSave(Vqos vqos){
		name=vqos.getName();
		json=JSON.toJSONString(vqos);
	}


	
	@Override
	public String toString() {
		return "VqosSave [vqos=" + vqos + ", name=" + name + ", json=" + json + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((json == null) ? 0 : json.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((vqos == null) ? 0 : vqos.hashCode());
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
		VqosSave other = (VqosSave) obj;
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
		if (vqos == null) {
			if (other.vqos != null)
				return false;
		} else if (!vqos.equals(other.vqos))
			return false;
		return true;
	}

	public Vqos getVqos() {
		return vqos;
	}

	public void setVqos(Vqos vqos) {
		this.vqos = vqos;
	}

	public Vqos toVqos(){
		return JSON.parseObject(json,Vqos.class);
	}

}
