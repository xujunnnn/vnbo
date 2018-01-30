package com.ebupt.vnbo.entity.vtn;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.annotation.JSONField;
import com.ebupt.vnbo.entity.abstracts.Config;
import com.ebupt.vnbo.entity.enums.OperationType;
import com.ebupt.vnbo.entity.enums.UpDate_Mode;
import com.ebupt.vnbo.entity.exception.ConfigException;
import com.ebupt.vnbo.entity.exception.ODL_IO_Exception;
import com.ebupt.vnbo.entity.vtopo.MacAclList;
import com.ebupt.vnbo.util.BaseUtil;
import com.ebupt.vnbo.util.HttpUtil;


/**
 * 
 * @author xu
 *
 */
public class Vtn implements Config {
	private static final String ConfigUrl=BaseUtil.getODL_IP()+"/restconf/config";
	private static final String VtnConfigUrl=BaseUtil.getODL_IP()+"/restconf/operations";
	@JSONField(name="tenant-name")
	private String tenant_name;
	@JSONField(name="update-mode")
	private UpDate_Mode update_mode;
	private OperationType operation;
	private String description;
	@JSONField(name="idle-timeout")
	private String idle_timeout;
	@JSONField(name="hard-timeout")
	private String hard_timeout;
	public UpDate_Mode getUpdate_mode() {
		return update_mode;
	}
	public Vtn setUpdate_mode(UpDate_Mode update_mode) {
		this.update_mode = update_mode;
		return this;
	}
	public OperationType getOperation() {
		return operation;
	}
	public Vtn setOperation(OperationType operation) {
		this.operation = operation;
		return this;
	}
	
	public String getTenant_name() {
		return tenant_name;
	}
	public Vtn setTenant_name(String tenant_name) {
		this.tenant_name = tenant_name;
		return this;
	}
	public String getDescription() {
		return description;
	}
	public Vtn setDescription(String description) {
		this.description = description;
		return this;
	}
	public String getIdle_timeout() {
		return idle_timeout;
	}
	public Vtn setIdle_timeout(String idle_timeout) {
		this.idle_timeout = idle_timeout;
		return this;
	}
	public String getHard_timeout() {
		return hard_timeout;
	}
	public Vtn setHard_timeout(String hard_timeout) {
		this.hard_timeout = hard_timeout;
		return this;
	}
	public void send(String node) throws ODL_IO_Exception {
		// TODO Auto-generated method stub
		String url="http://"+VtnConfigUrl+"/vtn:update-vtn";
		JSONObject jsonObject=new JSONObject();
		jsonObject.put("input", JSONObject.parseObject(JSON.toJSONString(this)));
	    String response[]=HttpUtil.Post_request(url,jsonObject);
	    String responsecode=response[0];
	    String responsebody=response[1];
	    if(!"201".equals(responsecode) && !"200".equals(responsecode) && !"409".equals(responsecode))
	    	throw new ConfigException("vtn"+this.getTenant_name()+"created failed");
		
	}
	
	public void remove(String node) throws ODL_IO_Exception {
		// TODO Auto-generated method stub
		Mac_Map mac_Map=new Mac_Map();
		mac_Map.setTenant_name(tenant_name).setOperation(OperationType.REMOVE);
		mac_Map.send(null);
		String url="http://"+VtnConfigUrl+"/vtn:remove-vtn";
		JSONObject jsonObject=new JSONObject();
		JSONObject vtnjson=new JSONObject();
		vtnjson.put("tenant-name", this.tenant_name);
		jsonObject.put("input", vtnjson);
		String responsecode=HttpUtil.Post_request(url,jsonObject)[0];
		if(!"200".equals(responsecode) && !"201".equals(responsecode) && !"404".equals(responsecode))
				throw new ConfigException("faied to delete Vtn "+this.tenant_name);
		
	}
	@Override
	public JSONObject toJson() {
		// TODO Auto-generated method stub
		JSONObject jsonObject=new JSONObject();
		JSONObject vtnjson=new JSONObject();
		vtnjson.put("tenant-name", this.tenant_name);
		jsonObject.put("input", vtnjson);
		return jsonObject;
		
	}


	/**
	@Override
	public void send(String node) throws VtnException {
		// TODO Auto-generated method stub
		String url="http://"+ODL_IP+"/restconf/operations/vtn:update-vtn";
		String json=JSON.toJSONString(this);	
		JSONObject jsonObject=new JSONObject();
		jsonObject.put("input", JSONObject.parseObject(JSON.toJSONString(this)));
	    String responsecode=HttpUtil.Post_request(url,jsonObject)[0];
	    if(!"201".equals(responsecode) && !"200".equals(responsecode))
	    	throw new VtnException("vtn"+this.getTenant_name()+"created failed");
		
	}
	@Override
	public void remove(String node) throws VtnException {
		// TODO Auto-generated method stub
		String url="http://"+ODL_IP+"/restconf/operations/vtn:remove-vtn";
		JSONObject jsonObject=new JSONObject();
		JSONObject vtnjson=new JSONObject();
		vtnjson.put("tenant-name", this.tenant_name);
		jsonObject.put("input", vtnjson);
		String responsecode=HttpUtil.Post_request(url,jsonObject)[0];
		if(!"200".equals(responsecode) && !"201".equals(responsecode) && !"404".equals(responsecode))
				throw new VtnException("faied to delete Vtn "+this.tenant_name);
		
	}
	@Override
	public Vtn read(String node) throws VtnException {
		// TODO Auto-generated method stub
		String url="http://"+ODL_IP+"/restconf/operational/vtn:vtns/vtn/"+tenant_name;
		String []result=HttpUtil.Get_request(url);
		String jsondata=result[1];
		String responsecode=result[0];
		if(!"200".equals(responsecode) && ! "201".equals(responsecode))
			throw new VtnException("vtn"+tenant_name+"read failed");
		JSONObject jsonObject=JSONObject.parseObject(jsondata);
		JSONObject vtnJsonObject=jsonObject.getJSONArray("vtn").getJSONObject(0);	
		Vtn vtn=JSONObject.parseObject(vtnJsonObject.toJSONString(), Vtn.class);
		return vtn;
	}
**/	

}
