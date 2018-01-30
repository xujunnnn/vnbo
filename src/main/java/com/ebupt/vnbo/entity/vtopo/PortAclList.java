package com.ebupt.vnbo.entity.vtopo;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import com.alibaba.fastjson.JSONObject;
import com.ebupt.vnbo.entity.abstracts.Config;
import com.ebupt.vnbo.entity.enums.OperationType;
import com.ebupt.vnbo.entity.exception.ODL_IO_Exception;
import com.ebupt.vnbo.util.BaseUtil;
import com.ebupt.vnbo.util.HttpUtil;

public class PortAclList implements Config{
	public static final String VtnOperationUrl=BaseUtil.getODL_IP()+"/restconf/operations";
	private OperationType operation;
	private List<String> ports=new LinkedList<String>();
	public OperationType getOperation() {
		return operation;
	}
	public void setOperation(OperationType operation) {
		this.operation = operation;
	}
	public List<String> getPorts() {
		return ports;
	}
	public void setPorts(List<String> ports) {
		this.ports = ports;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((operation == null) ? 0 : operation.hashCode());
		result = prime * result + ((ports == null) ? 0 : ports.hashCode());
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
		PortAclList other = (PortAclList) obj;
		if (operation != other.operation)
			return false;
		if (ports == null) {
			if (other.ports != null)
				return false;
		} else if (!ports.equals(other.ports))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "PortAclList [operation=" + operation + ", ports=" + ports + "]";
	}
	@Override
	public void send(String node) throws ODL_IO_Exception {
		// TODO Auto-generated method stub
		String url="http://"+VtnOperationUrl+"/packetfilter:set-port-acl";
		JSONObject jsonObject=new JSONObject();
		jsonObject.put("input", JSONObject.toJSON(this));
		String []response=HttpUtil.Post_request(url,jsonObject);
		String respcode=response[0];
		String respbody=response[1];
		if(!"200".equals(respcode) && !"201".equals(respcode)){
			throw new ODL_IO_Exception("failed add ports "+respbody);
		}
		
	}
	
	public PortAclList addPort(String port){
		this.ports.add(port);
		return this;
	}
	
	
}
