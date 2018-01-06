package com.ebupt.vnbo.entity.vtn;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.annotation.JSONField;
import com.ebupt.vnbo.entity.abstracts.Config;
import com.ebupt.vnbo.entity.enums.OperationType;
import com.ebupt.vnbo.entity.enums.UpDate_Mode;
import com.ebupt.vnbo.entity.exception.ODL_IO_Exception;
import com.ebupt.vnbo.util.BaseUtil;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

public class Vterminal implements Config{
	private static final String ConfigUrl=BaseUtil.getODL_IP()+"/restconf/config";
	private static final String VtnConfigUrl=BaseUtil.getODL_IP()+"/restconf/operations";
	@JSONField(name="tenant-name")
	private String tenant_name;
	@JSONField(name="terminal-name")
	private String terminal_name;
	@JSONField(name="description")
	private String description;
	@JSONField(name="update-mode")
	private UpDate_Mode upDate_Mode;
	@JSONField(name="operation")
	private OperationType operation;
	
	public String getTenant_name() {
		return tenant_name;
	}
	public Vterminal setTenant_name(String tenant_name) {
		this.tenant_name = tenant_name;
		return this;
	}
	public String getTerminal_name() {
		return terminal_name;
	}
	public Vterminal setTerminal_name(String terminal_name) {
		this.terminal_name = terminal_name;
		return this;
	}
	public String getDescription() {
		return description;
	}
	public Vterminal setDescription(String description) {
		this.description = description;
		return this;
	}
	public UpDate_Mode getUpDate_Mode() {
		return upDate_Mode;
	}
	public Vterminal setUpDate_Mode(UpDate_Mode upDate_Mode) {
		this.upDate_Mode = upDate_Mode;
		return this;
	}
	public OperationType getOperation() {
		return operation;
	}
	public Vterminal setOperation(OperationType operation) {
		this.operation = operation;
		return this;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((operation == null) ? 0 : operation.hashCode());
		result = prime * result + ((tenant_name == null) ? 0 : tenant_name.hashCode());
		result = prime * result + ((terminal_name == null) ? 0 : terminal_name.hashCode());
		result = prime * result + ((upDate_Mode == null) ? 0 : upDate_Mode.hashCode());
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
		Vterminal other = (Vterminal) obj;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (operation != other.operation)
			return false;
		if (tenant_name == null) {
			if (other.tenant_name != null)
				return false;
		} else if (!tenant_name.equals(other.tenant_name))
			return false;
		if (terminal_name == null) {
			if (other.terminal_name != null)
				return false;
		} else if (!terminal_name.equals(other.terminal_name))
			return false;
		if (upDate_Mode != other.upDate_Mode)
			return false;
		return true;
	}
	
	public JSONObject toJson(){
		JSONObject json=new JSONObject();
		json.put("input", JSON.toJSON(this));
		return json;
	}
	
	@Override
	@JSONField(deserialize=true)
	public String toUrl() {
		// TODO Auto-generated method stub
		return "http://"+VtnConfigUrl+"/vtn-vterminal:update-vterminal";
	}
	@Override
	public JSONObject toDelJson() {
		// TODO Auto-generated method stub
		JSONObject json=new JSONObject();
		json.put("input", JSON.toJSON(this));
		return json;
	}
	
	@Override
	public String toDelUrl() {
		// TODO Auto-generated method stub
		return "http://"+VtnConfigUrl+"/vtn-vterminal:remove-vterminal";
	}
	

}
