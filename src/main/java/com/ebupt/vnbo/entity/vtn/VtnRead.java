package com.ebupt.vnbo.entity.vtn;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.annotation.JSONField;

import com.ebupt.vnbo.entity.abstracts.Operational;
import com.ebupt.vnbo.entity.exception.ODL_IO_Exception;
import com.ebupt.vnbo.entity.exception.OperationalException;
import com.ebupt.vnbo.util.BaseUtil;
import com.ebupt.vnbo.util.HttpUtil;


public class VtnRead implements Operational {
	public static final String OperationalUrl=BaseUtil.getODL_IP()+"/restconf/operational";
	public static final String VtnOperationUrl=BaseUtil.getODL_IP()+"/restconf/operations";
	@JSONField(name="name")
	private String tenant_name;
	@JSONField(name="vtenant-config")
	private Vtenant_config vtenant_config;
	@JSONField(name="vbridge")	
	private HashSet<VbridgeRead> vbridgeReads;;
	@JSONField(name="vterminal")	
	private List<VterminalRead> vterminalReads;
	
	public List<VterminalRead> getVterminalReads() {
		return vterminalReads;
	}
	public void setVterminalReads(List<VterminalRead> vterminalReads) {
		this.vterminalReads = vterminalReads;
	}
	public Vtenant_config getVtenant_config() {
		return vtenant_config;
	}
	public String getTenant_name() {
		return tenant_name;
	}
	public VtnRead setTenant_name(String tenant_name) {
		this.tenant_name = tenant_name;
		return this;
	}
	public VtnRead setVtenant_config(Vtenant_config vtenant_config) {
		this.vtenant_config = vtenant_config;
		return this;
	}
	public HashSet<VbridgeRead> getVbridgeReads() {
		return vbridgeReads;
	}
	public VtnRead setVbridgeReads(HashSet<VbridgeRead> vbridgeReads) {
		this.vbridgeReads = vbridgeReads;
		return this;
	}
	
	@Override
	public String toString() {
		return "VtnRead [tenant_name=" + tenant_name + ", vtenant_config=" + vtenant_config + ", vbridgeReads="
				+ vbridgeReads + "]";
	}
	/**
	@Override
	public void send(String node) throws  {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void remove(String node) throws EntrySetException {
		// TODO Auto-generated method stub
		
	}
	@Override
	public VtnRead read(String node) throws VtnException   {
		// TODO Auto-generated method stub
		String url="http://"+ODL_IP+"/restconf/operational/vtn:vtns/vtn/"+tenant_name;
		String []result=HttpUtil.Get_request(url);
		String jsondata=result[1];
		String responsecode=result[0];
		if(!"200".equals(responsecode) && ! "201".equals(responsecode))
			throw new VtnException("vtn"+tenant_name+"read failed");
		JSONObject jsonObject=JSONObject.parseObject(jsondata);
		JSONObject vtnJsonObject=jsonObject.getJSONArray("vtn").getJSONObject(0);	
		VtnRead vtnRead=JSONObject.parseObject(vtnJsonObject.toJSONString(), VtnRead.class);
		return vtnRead;
	}
**/
	@Override
	public VtnRead read(String node) throws ODL_IO_Exception {
		// TODO Auto-generated method stub
		String url="http://"+OperationalUrl+"/vtn:vtns/vtn/"+tenant_name;
		String []result=HttpUtil.Get_request(url);
		String jsondata=result[1];
		String responsecode=result[0];
		if(!"200".equals(responsecode) && ! "201".equals(responsecode))
			return null;
		JSONObject jsonObject=JSONObject.parseObject(jsondata);
		JSONObject vtnJsonObject=jsonObject.getJSONArray("vtn").getJSONObject(0);	
		VtnRead vtnRead=JSONObject.parseObject(vtnJsonObject.toJSONString(), VtnRead.class);
		return vtnRead;
	}
	
	public List<VtnRead> readAll() throws ODL_IO_Exception{
		List<VtnRead> vtnReads=new ArrayList<>();
		String url="http://"+OperationalUrl+"/vtn:vtns";
		String response[]=HttpUtil.Get_request(url);
		String responsecode=response[0];
		if(!"200".equals(responsecode)  &&  !"201".equals(responsecode))
				throw new ODL_IO_Exception("failed to read the VTopo");
		String responsebody=response[1];
		JSONObject resultjson=(JSONObject) JSONObject.parse(responsebody);
		resultjson=resultjson.getJSONObject("vtns");
		JSONArray resultArray=resultjson.getJSONArray("vtn");
		if(resultArray!=null){
			vtnReads=JSON.parseArray(resultArray.toJSONString(),VtnRead.class);
			return vtnReads;
		}
		else {
			return vtnReads;
		}
	}
}
