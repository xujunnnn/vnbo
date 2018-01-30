package com.ebupt.vnbo.entity.vtn_accesss;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.ebupt.vnbo.entity.abstracts.Operational;
import com.ebupt.vnbo.entity.exception.ODL_IO_Exception;
import com.ebupt.vnbo.util.BaseUtil;
import com.ebupt.vnbo.util.HttpUtil;

public class Vtn implements Operational{
	private static final String ConfigUrl=BaseUtil.getODL_IP()+"/restconf/config";
	private String vtn;
	private List<Vbridge> vbridge;
	public String getVtn() {
		return vtn;
	}
	public void setVtn(String vtn) {
		this.vtn = vtn;
	}
	public List<Vbridge> getVbridge() {
		return vbridge;
	}
	public void setVbridge(List<Vbridge> vbridge) {
		this.vbridge = vbridge;
	}
	@Override
	public Vtn read(String node) throws ODL_IO_Exception {
		// TODO Auto-generated method stub
		Vtn VTN;
		String url="http://"+ConfigUrl+"/vtn_access_controller:mac_acls/vtn/"+this.vtn;
		String[] response=HttpUtil.Get_request(url);
		String respcode=response[0];
		String respbody=response[1];
		if(!"200".equals(respcode) && !"201".equals(respcode)){
			return null;
		}
		JSONObject json=JSON.parseObject(respbody).getJSONArray("vtn").getJSONObject(0);
		VTN=JSON.toJavaObject(json, Vtn.class);	
		return VTN;
	}
	
	public List<Vtn> readAll() throws ODL_IO_Exception{
		List<Vtn> vtns=new LinkedList<Vtn>();
		String url="http://"+ConfigUrl+"/vtn_access_controller:mac_acls/";
		String[] response=HttpUtil.Get_request(url);
		String respcode=response[0];
		String respbody=response[1];
		if(!"200".equals(respcode) && !"201".equals(respcode)){
			return null;
		}
		JSONArray array=JSONArray.parseObject(respbody).getJSONObject("mac_acls").getJSONArray("vtn");
		if(array!=null)
			vtns=JSON.parseArray(array.toJSONString(), Vtn.class);
		return vtns;
		
		
	}
	
	
	
}
