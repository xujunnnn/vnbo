package com.ebupt.vnbo.entity.vtopo;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.ebupt.vnbo.entity.abstracts.Config;
import com.ebupt.vnbo.entity.abstracts.Operational;
import com.ebupt.vnbo.entity.enums.OperationType;
import com.ebupt.vnbo.entity.exception.ODL_IO_Exception;
import com.ebupt.vnbo.util.BaseUtil;
import com.ebupt.vnbo.util.HttpUtil;

public class MacAclList implements Config,Operational{
	public static final String OperationalUrl=BaseUtil.getODL_IP()+"/restconf/operational";
	public static final String VtnOperationUrl=BaseUtil.getODL_IP()+"/restconf/operations";
	private static final String ConfigUrl=BaseUtil.getODL_IP()+"/restconf/config";
	private OperationType operation;
	private List<String> hosts;
	public OperationType getOperation() {
		return operation;
	}
	public void setOperation(OperationType operation) {
		this.operation = operation;
	}
	public List<String> getHosts() {
		return hosts;
	}
	public void setHosts(List<String> hosts) {
		this.hosts = hosts;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((hosts == null) ? 0 : hosts.hashCode());
		result = prime * result + ((operation == null) ? 0 : operation.hashCode());
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
		MacAclList other = (MacAclList) obj;
		if (hosts == null) {
			if (other.hosts != null)
				return false;
		} else if (!hosts.equals(other.hosts))
			return false;
		if (operation != other.operation)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "MacAclList [operation=" + operation + ", hosts=" + hosts + "]";
	}
	@Override
	public void send(String node) throws ODL_IO_Exception {
		// TODO Auto-generated method stub
		String url="http://"+VtnOperationUrl+"/packetfilter:set-mac-acl";
		JSONObject jsonObject=new JSONObject();
		jsonObject.put("input", JSON.toJSON(this));
		String response[]=HttpUtil.Post_request(url,jsonObject);
		String responsecode=response[0];
		String responsebody=response[1];
		if(!"200".equals(responsecode) && !"201".equals(responsecode)){
			throw new ODL_IO_Exception("fail to add host to the list "+responsebody);
		}
	}
	@Override
	public void remove(String node) throws ODL_IO_Exception {
		// TODO Auto-generated method stub
		
	}
	@Override
	public MacAclList read(String node) throws ODL_IO_Exception {
		// TODO Auto-generated method stub
		MacAclList macAclList=new MacAclList();
		String url="http://"+ConfigUrl+"/packetfilter:macfilter";
		String []response=HttpUtil.Get_request(url);
		String responsecode=response[0];
		String responsebody=response[1];
		if(!"200".equals(responsecode) && !"201".equals(responsecode)){
			throw new ODL_IO_Exception("fail read hosts "+responsebody);
		}
		List<String> hosts=new ArrayList();
		JSONObject macfilter=JSON.parseObject(responsebody);
		JSONArray array=macfilter.getJSONObject("macfilter").getJSONArray("aclhost");
		Iterator<Object> iterator=array.iterator();
		while(iterator.hasNext()){
			JSONObject hostJson= (JSONObject) iterator.next();
			hosts.add(hostJson.getString("host"));
		}
		macAclList.setHosts(hosts);
		return macAclList;
		
		
	}
	 
	

}
