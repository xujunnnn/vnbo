package com.ebupt.vnbo.entity.vtn;

import java.util.HashSet;
import java.util.Set;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.annotation.JSONField;
import com.ebupt.vnbo.entity.abstracts.Config;
import com.ebupt.vnbo.entity.abstracts.Operational;
import com.ebupt.vnbo.entity.enums.OperationType;
import com.ebupt.vnbo.entity.exception.ConfigException;
import com.ebupt.vnbo.entity.exception.ODL_IO_Exception;
import com.ebupt.vnbo.entity.exception.OperationalException;
import com.ebupt.vnbo.util.BaseUtil;
import com.ebupt.vnbo.util.HttpUtil;

public class Mac_Map implements Config{
	@JSONField(name="tenant-name")
	private String tenant_name;
	@JSONField(name="bridge-name")
	private String bridge_name;
	@JSONField(name="hosts")
	private Set<String> allowed_hosts;
	private OperationType operation;
	public static final String OperationalUrl=BaseUtil.getODL_IP()+"/restconf/operational";
	public static final String VtnOperationUrl=BaseUtil.getODL_IP()+"/restconf/operations";
	private static final String ConfigUrl=BaseUtil.getODL_IP()+"/restconf/config";
	private static final String VtnConfigUrl=BaseUtil.getODL_IP()+"/restconf/operations";
	
	
	public String getTenant_name() {
		return tenant_name;
	}
	public Mac_Map setTenant_name(String tenant_name) {
		this.tenant_name = tenant_name;
		return this;
	}
	public String getBridge_name() {
		return bridge_name;
	}
	public Mac_Map setBridge_name(String bridge_name) {
		this.bridge_name = bridge_name;
		return this;
	}
	public Set<String> getAllowed_hosts() {
		return allowed_hosts;
	}
	public Mac_Map setAllowed_hosts(Set<String> allowed_hosts) {
		this.allowed_hosts = allowed_hosts;
		return this;
	}
	public OperationType getOperation() {
		return operation;
	}
	public Mac_Map setOperation(OperationType operation) {
		this.operation = operation;
		return this;
	}
	
	@Override
	public String toString() {
		return "Mac_Map [tenant_name=" + tenant_name + ", bridge_name=" + bridge_name + ", allowed_hosts="
				+ allowed_hosts + ", operation=" + operation + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((allowed_hosts == null) ? 0 : allowed_hosts.hashCode());
		result = prime * result + ((bridge_name == null) ? 0 : bridge_name.hashCode());
		result = prime * result + ((operation == null) ? 0 : operation.hashCode());
		result = prime * result + ((tenant_name == null) ? 0 : tenant_name.hashCode());
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
		Mac_Map other = (Mac_Map) obj;
		if (allowed_hosts == null) {
			if (other.allowed_hosts != null)
				return false;
		} else if (!allowed_hosts.equals(other.allowed_hosts))
			return false;
		if (bridge_name == null) {
			if (other.bridge_name != null)
				return false;
		} else if (!bridge_name.equals(other.bridge_name))
			return false;
		if (operation != other.operation)
			return false;
		if (tenant_name == null) {
			if (other.tenant_name != null)
				return false;
		} else if (!tenant_name.equals(other.tenant_name))
			return false;
		return true;
	}
	/**
	public void send(String node) throws ConfigException {
		// TODO Auto-generated method stub
		String url2="http://"+ConfigUrl+"/vtn-mac-map:set-mac-map";
		JSONObject jsonObject2=new JSONObject();
		jsonObject2.put("input", JSONObject.parseObject(JSON.toJSONString(this)));
		System.out.println(url2+jsonObject2);
		String responsecode=HttpUtil.Post_request(url2,jsonObject2)[0];
		if(!"200".equals(responsecode) && !"201".equals(responsecode))
			throw new ConfigException("vbridge"+this.getBridge_name()+"mac_map created failed");
		
		
		
	}
	/**
	public void remove(String node) throws Mac_MapFailException {
		// TODO Auto-generated method stub
		
	}
	/**
	public Mac_Map read(String node) throws Mac_MapFailException{
		// TODO Auto-generated method stub
		String url="http://"+ODL_IP+"/restconf/operational/vtn:vtns/vtn/"+tenant_name+"/vbridge/"+bridge_name+"/mac-map";
		String []result=HttpUtil.Get_request(url);
		String jsondata=result[1];
		String responsecode=result[0];
		if(!"200".equals(responsecode) && ! "201".equals(responsecode))
				throw new Mac_MapFailException("failed to read the mac_map VTn/Vbridge "+tenant_name+"/"+bridge_name);
		JSONObject resultjson=JSON.parseObject(jsondata).getJSONObject("mac-map");
		Mac_Map mac_Map=JSON.parseObject(resultjson.toJSONString(), Mac_Map.class);
		return mac_Map;
		
	}
	**/

	public void send(String node) throws ODL_IO_Exception {
		// TODO Auto-generated method stub
		String url2="http://"+VtnConfigUrl+"/vtn_access_controller:set-mac-map-acl";
		JSONObject jsonObject2=new JSONObject();
		jsonObject2.put("input", JSONObject.parseObject(JSON.toJSONString(this)));
	//	System.out.println(url2+jsonObject2);
		String response[]=HttpUtil.Post_request(url2,jsonObject2);
		String responsecode=response[0];
		String responsebody=response[1];
		if(!"200".equals(responsecode) && !"201".equals(responsecode))
			throw new ConfigException("vbridge"+this.getBridge_name()+"mac_map created failed "+responsebody);
		
	}
	public void remove(String node) throws ODL_IO_Exception {
		// TODO Auto-generated method stub
		
	}

}
