package com.ebupt.vnbo.entity.vtn;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.annotation.JSONField;
import com.ebupt.vnbo.entity.abstracts.Config;
import com.ebupt.vnbo.entity.enums.OperationType;
import com.ebupt.vnbo.entity.enums.UpDate_Mode;
import com.ebupt.vnbo.entity.exception.ConfigException;
import com.ebupt.vnbo.entity.exception.ODL_IO_Exception;
import com.ebupt.vnbo.util.BaseUtil;
import com.ebupt.vnbo.util.HttpUtil;

public class VInterface implements Config {
	private static final String ConfigUrl=BaseUtil.getODL_IP()+"/restconf/config";
	private static final String VtnConfigUrl=BaseUtil.getODL_IP()+"/restconf/operations";
	@JSONField(name="tenant-name")
	private String tenant_name;
	@JSONField(name="bridge-name")
	private String bridge_name;
	@JSONField(name="interface-name")
	private String interface_name;
	@JSONField(name="terminal-name")
	private String terminal_name;
	private boolean enabled;
	@JSONField(name="update-mode")
	private UpDate_Mode upDate_Mode;
	@JSONField(name="operation")
	private OperationType operation;
	
	
	
	public UpDate_Mode getUpDate_Mode() {
		return upDate_Mode;
	}
	public VInterface setUpDate_Mode(UpDate_Mode upDate_Mode) {
		this.upDate_Mode = upDate_Mode;
		return this;
	}
	public OperationType getOperation() {
		return operation;
	}
	public VInterface setOperation(OperationType operation) {
		this.operation = operation;
		return this;
	}
	public boolean isEnabled() {
		return enabled;
	}
	public VInterface setEnabled(boolean enabled) {
		this.enabled = enabled;
		return this;
	}
	public String getTenant_name() {
		return tenant_name;
	}
	public VInterface setTenant_name(String tenant_name) {
		this.tenant_name = tenant_name;
		return this;
	}
	public String getBridge_name() {
		return bridge_name;
	}
	public VInterface setBridge_name(String bridge_name) {
		this.bridge_name = bridge_name;
		return this;
	}
	public String getInterface_name() {
		return interface_name;
	}
	public VInterface setInterface_name(String interface_name) {
		this.interface_name = interface_name;
		return this;
	}
	public String getTerminal_name() {
		return terminal_name;
	}
	public VInterface setTerminal_name(String terminal_name) {
		this.terminal_name = terminal_name;
		return this;
	}
	
	
	@Override
	public String toString() {
		return "VInterface [tenant_name=" + tenant_name + ", bridge_name=" + bridge_name + ", interface_name="
				+ interface_name + ", terminal_name=" + terminal_name + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((bridge_name == null) ? 0 : bridge_name.hashCode());
		result = prime * result + ((interface_name == null) ? 0 : interface_name.hashCode());
		result = prime * result + ((tenant_name == null) ? 0 : tenant_name.hashCode());
		result = prime * result + ((terminal_name == null) ? 0 : terminal_name.hashCode());
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
		if (bridge_name == null) {
			if (other.bridge_name != null)
				return false;
		} else if (!bridge_name.equals(other.bridge_name))
			return false;
		if (interface_name == null) {
			if (other.interface_name != null)
				return false;
		} else if (!interface_name.equals(other.interface_name))
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
		return true;
	}
	@Override
	public void send(String node) throws ODL_IO_Exception {
		// TODO Auto-generated method stub
		String url="http://"+VtnConfigUrl+"/vtn-vinterface:update-vinterface";
		JSONObject jsonObject=new JSONObject();
		jsonObject.put("input", JSONObject.parseObject(JSON.toJSONString(this)));
		String []response=HttpUtil.Post_request(url,jsonObject);
		String responsecode=response[0];
		String responsebody=response[1];
		if(!"200".equals(responsecode) && !"201".equals(responsecode))
			throw new ODL_IO_Exception("vbridge"+this.getBridge_name()+"created failed");
		
	}
	@Override
	public void remove(String node) throws ODL_IO_Exception {
		// TODO Auto-generated method stub
		String url="http://"+VtnConfigUrl+"/vtn-vinterface:remove-vinterface";
		JSONObject jsonObject=new JSONObject();
		JSONObject jsonObject2=(JSONObject) JSONObject.toJSON(this);
		jsonObject2.remove("enabled");
		
		jsonObject.put("input", jsonObject2);
		
		String[] response=HttpUtil.Post_request(url,jsonObject);
		String responsecode=response[0];
		String responsebody=response[1];
		if(!"200".equals(responsecode) && !"201".equals(responsecode) && !"404".equals(responsecode))
			throw new ODL_IO_Exception("vterminal delete fail"+this.interface_name);
		
		
	}
	@Override
	public JSONObject toJson() {
		// TODO Auto-generated method stub
		JSONObject jsonObject=new JSONObject();
		jsonObject.put("input", JSON.toJSON(this));
		return jsonObject;
	}
	@Override
	public String toUrl() {
		// TODO Auto-generated method stub
		return "http://"+VtnConfigUrl+"/vtn-vinterface:update-vinterface";
	}
	

}
