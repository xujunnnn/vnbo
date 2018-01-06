package com.ebupt.vnbo.entity.vtn;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.annotation.JSONField;

import com.ebupt.vnbo.entity.abstracts.Operational;
import com.ebupt.vnbo.entity.exception.ODL_IO_Exception;
import com.ebupt.vnbo.entity.exception.OperationalException;
import com.ebupt.vnbo.util.BaseUtil;
import com.ebupt.vnbo.util.HttpUtil;

public class VbridgeRead implements Operational {
	public static final String OperationalUrl=BaseUtil.getODL_IP()+"/restconf/operational";
	public static final String VtnOperationUrl=BaseUtil.getODL_IP()+"/restconf/operations";
	@JSONField(name="name")
	private String bridge_name;
	@JSONField(name="bridge-status")
	private Bridge_status bridge_status;
	@JSONField(name="mac-map")
	private Mac_Map mac_Map;
	@JSONField(deserialize=true)
	private String tenant_name;
	@JSONField(name="vinterface")
	private List<VinterfaceRead> vinterface;
	public String getBridge_name() {
		return bridge_name;
	}
	public VbridgeRead setBridge_name(String bridge_name) {
		this.bridge_name = bridge_name;
		return this;
	}
	public String getTenant_name() {
		return tenant_name;
	}
	public VbridgeRead setTenant_name(String tenant_name) {
		this.tenant_name = tenant_name;
		return this;
	}
	public Bridge_status getBridge_status() {
		return bridge_status;
	}
	public VbridgeRead setBridge_status(Bridge_status bridge_status) {
		this.bridge_status = bridge_status;
		return this;
	}
	public Mac_Map getMac_Map() {
		return mac_Map;
	}
	public VbridgeRead setMac_Map(Mac_Map mac_Map) {
		this.mac_Map = mac_Map;
		return this;
	}
	
	public List<VinterfaceRead> getVinterface() {
		return vinterface;
	}
	public void setVinterface(List<VinterfaceRead> vinterface) {
		this.vinterface = vinterface;
	}
	
@Override
	public String toString() {
		return "VbridgeRead [bridge_name=" + bridge_name + ", bridge_status=" + bridge_status + ", mac_Map=" + mac_Map
				+ ", tenant_name=" + tenant_name + ", vinterface=" + vinterface + "]";
	}
/**
	@Override
	public VbridgeRead read(String node) throws VbridgeException {
		// TODO Auto-generated method stub
		String url="http://"+ODL_IP+"/restconf/operational/vtn:vtns/vtn/"+tenant_name+"/vbridge/"+bridge_name;
		String []result=HttpUtil.Get_request(url);
		String jsondata=result[1];
		String responsecode=result[0];
		if(!"200".equals(responsecode) && ! "201".equals(responsecode))
			throw new VbridgeException("vbridge"+bridge_name+"read failed");
		JSONObject vbridgejson=JSONObject.parseObject(jsondata).getJSONArray("vbridge").getJSONObject(0);
		VbridgeRead vbridgeRead=JSONObject.parseObject(vbridgejson.toJSONString(), VbridgeRead.class);
		vbridgeRead.setTenant_name(tenant_name).setBridge_name(bridge_name);
		return vbridgeRead;
	}
	**/
	public VbridgeRead read(String node) throws ODL_IO_Exception {
		// TODO Auto-generated method stub
		String url="http://"+OperationalUrl+"/vtn:vtns/vtn/"+tenant_name+"/vbridge/"+bridge_name;
		String []result=HttpUtil.Get_request(url);
		String jsondata=result[1];
		String responsecode=result[0];
		if(!"200".equals(responsecode) && ! "201".equals(responsecode))
			throw new OperationalException("vbridge"+bridge_name+"read failed");
		JSONObject vbridgejson=JSONObject.parseObject(jsondata).getJSONArray("vbridge").getJSONObject(0);
		VbridgeRead vbridgeRead=JSONObject.parseObject(vbridgejson.toJSONString(), VbridgeRead.class);
		vbridgeRead.setTenant_name(tenant_name).setBridge_name(bridge_name);
		return vbridgeRead;
	}

}
