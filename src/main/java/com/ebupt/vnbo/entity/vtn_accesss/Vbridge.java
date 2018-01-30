package com.ebupt.vnbo.entity.vtn_accesss;

import java.util.List;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.ebupt.vnbo.entity.abstracts.Operational;
import com.ebupt.vnbo.entity.exception.ODL_IO_Exception;
import com.ebupt.vnbo.entity.vtn.MappedHost;
import com.ebupt.vnbo.util.BaseUtil;
import com.ebupt.vnbo.util.HttpUtil;

public class Vbridge implements Operational{
	private static final String ConfigUrl=BaseUtil.getODL_IP()+"/restconf/config";
	private String vtn;
	private String vbridge;
	private List<MappedHost> mappedHost;
	
	public String getVtn() {
		return vtn;
	}
	public void setVtn(String vtn) {
		this.vtn = vtn;
	}
	public String getVbridge() {
		return vbridge;
	}
	public void setVbridge(String vbridge) {
		this.vbridge = vbridge;
	}
	public List<MappedHost> getMappedHost() {
		return mappedHost;
	}
	public void setMappedHost(List<MappedHost> mappedHost) {
		this.mappedHost = mappedHost;
	}
	
	@Override
	public String toString() {
		return "Vbridge [vtn=" + vtn + ", vbridge=" + vbridge + ", mappedHost=" + mappedHost + "]";
	}
	@Override
	public Operational read(String node) throws ODL_IO_Exception {
		// TODO Auto-generated method stub
		String url="http://"+ConfigUrl+"/vtn_access_controller:mac_acls/vtn/"+vtn+"/vbridge/"+vbridge;
		String[] response=HttpUtil.Get_request(url);
		String respcode=response[0];
		String respbody=response[1];
		if(!"200".equals(respcode) && !"201".equals(respcode)){
			return null;
		}
		JSONObject json=JSON.parseObject(respbody).getJSONArray("vbridge").getJSONObject(0);
		Vbridge vbridge;
		vbridge=JSON.toJavaObject(json, Vbridge.class);
		vbridge.setVtn(vtn);
		return vbridge;		
	}
	

}
