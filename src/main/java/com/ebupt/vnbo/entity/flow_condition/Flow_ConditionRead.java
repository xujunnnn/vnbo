package com.ebupt.vnbo.entity.flow_condition;

import java.util.List;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.ebupt.vnbo.entity.abstracts.Operational;
import com.ebupt.vnbo.entity.exception.ODL_IO_Exception;
import com.ebupt.vnbo.util.BaseUtil;
import com.ebupt.vnbo.util.HttpUtil;

public class Flow_ConditionRead implements Operational{
	public static final String OperationalUrl=BaseUtil.getODL_IP()+"/restconf/operational";
	public static final String VtnOperationUrl=BaseUtil.getODL_IP()+"/restconf/operations";
	private String name;
	private List<Vtn_Flow_Match> vtn_flow_match;
	
	@Override
	public String toString() {
		return "Flow_ConditionRead [name=" + name + ", vtn_flow_match=" + vtn_flow_match + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((vtn_flow_match == null) ? 0 : vtn_flow_match.hashCode());
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
		Flow_ConditionRead other = (Flow_ConditionRead) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (vtn_flow_match == null) {
			if (other.vtn_flow_match != null)
				return false;
		} else if (!vtn_flow_match.equals(other.vtn_flow_match))
			return false;
		return true;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Vtn_Flow_Match> getVtn_flow_match() {
		return vtn_flow_match;
	}

	public void setVtn_flow_match(List<Vtn_Flow_Match> vtn_flow_match) {
		this.vtn_flow_match = vtn_flow_match;
	}

	@Override
	public Flow_ConditionRead read(String node) throws ODL_IO_Exception {
		// TODO Auto-generated method stub
		String url="http://"+OperationalUrl+"/vtn-flow-condition:vtn-flow-conditions/"+name;
		String[] response=HttpUtil.Get_request(url);
		String responsecode=response[0];
		String responseBody=response[1];
		if(!"200".equals(responsecode) && !"201".equals(responsecode)){
			throw new ODL_IO_Exception("read fail");
		}
		Flow_ConditionRead flow_ConditionRead=JSON.parseObject(responseBody, Flow_ConditionRead.class);
		return flow_ConditionRead;
		
	}
	

}
