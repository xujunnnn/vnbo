package com.ebupt.vnbo.entity.vtn;

import java.util.List;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.annotation.JSONField;
import com.ebupt.vnbo.entity.abstracts.Operational;
import com.ebupt.vnbo.entity.exception.ODL_IO_Exception;
import com.ebupt.vnbo.entity.exception.OperationalException;
import com.ebupt.vnbo.util.BaseUtil;
import com.ebupt.vnbo.util.HttpUtil;

public class MacMapRead implements Operational{
	public static final String OperationalUrl=BaseUtil.getODL_IP()+"/restconf/operational";
	public static final String VtnOperationUrl=BaseUtil.getODL_IP()+"/restconf/operations";
	private static final String ConfigUrl=BaseUtil.getODL_IP()+"/restconf/config";
	private static final String VtnConfigUrl=BaseUtil.getODL_IP()+"/restconf/operations";
	private String tenant_name;
	private String bridge_name;
	@JSONField(name="mapped-host")
	private List<MappedHost> mappedHost;
	

	public String getTenant_name() {
		return tenant_name;
	}


	public void setTenant_name(String tenant_name) {
		this.tenant_name = tenant_name;
	}


	public String getBridge_name() {
		return bridge_name;
	}


	public void setBridge_name(String bridge_name) {
		this.bridge_name = bridge_name;
	}


	public List<MappedHost> getMappedHost() {
		return mappedHost;
	}


	public void setMappedHost(List<MappedHost> mappedHost) {
		this.mappedHost = mappedHost;
	}
	

	@Override
	public String toString() {
		return "MacMapRead [tenant_name=" + tenant_name + ", bridge_name=" + bridge_name + ", mappedHost=" + mappedHost
				+ "]";
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((bridge_name == null) ? 0 : bridge_name.hashCode());
		result = prime * result + ((mappedHost == null) ? 0 : mappedHost.hashCode());
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
		MacMapRead other = (MacMapRead) obj;
		if (bridge_name == null) {
			if (other.bridge_name != null)
				return false;
		} else if (!bridge_name.equals(other.bridge_name))
			return false;
		if (mappedHost == null) {
			if (other.mappedHost != null)
				return false;
		} else if (!mappedHost.equals(other.mappedHost))
			return false;
		if (tenant_name == null) {
			if (other.tenant_name != null)
				return false;
		} else if (!tenant_name.equals(other.tenant_name))
			return false;
		return true;
	}


	@Override
	public MacMapRead read(String node) throws ODL_IO_Exception{
		// TODO Auto-generated method stub
		String url="http://"+ConfigUrl+"/vtn_access_controller:mac_acls/vtn/"+this.tenant_name+"/vbridge/"+this.bridge_name;
		String []result= HttpUtil.Get_request(url);
		String jsondata=result[1];
		String responsecode=result[0];
		if(!"200".equals(responsecode) && ! "201".equals(responsecode))
				throw new OperationalException("failed to read the mac_map VTn/Vbridge "+tenant_name+"/"+bridge_name);
		JSONObject json=JSON.parseObject(jsondata);
		JSONObject jsonObject=json.getJSONArray("vbridge").getJSONObject(0);
		MacMapRead macMapRead=JSON.toJavaObject(jsonObject, MacMapRead.class);
		return macMapRead;
		
	}

}
