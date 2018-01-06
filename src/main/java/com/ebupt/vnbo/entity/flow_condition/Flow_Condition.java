package com.ebupt.vnbo.entity.flow_condition;

import java.util.List;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.annotation.JSONField;
import com.ebupt.vnbo.entity.abstracts.Config;
import com.ebupt.vnbo.entity.enums.OperationType;
import com.ebupt.vnbo.entity.exception.ConfigException;
import com.ebupt.vnbo.entity.exception.ODL_IO_Exception;
import com.ebupt.vnbo.util.BaseUtil;
import com.ebupt.vnbo.util.HttpUtil;


/**
 * Created by jyh on 2017/11/16.
 */
/*
 http://127.0.0.1:8181/restconf/operations/vtn-flow-condition:set-flow-condition
{
    "set-flow-condition": {
        "input": {
            "operation": "SET",
            "present": "false",
            "name": "cond_1",
            "vtn-flow-match": [
                {
                    "index": "1",
                    "vtn-inet-match": {
                        "source-network": "10.0.0.2/32",
                        "destination-network": "10.0.0.4/32"
                    }
                }
            ]
        }
    }
}
 */
public class Flow_Condition  implements Config{
	private static final String ConfigUrl=BaseUtil.getODL_IP()+"/restconf/config";
	private static final String VtnConfigUrl=BaseUtil.getODL_IP()+"/restconf/operations";
	private OperationType operation;
	private String present;
	private String name;
	@JSONField(name="vtn-flow-match")
	private List<Vtn_Flow_Match> vtn_flow_match ;

	public OperationType getOperation() {
		return operation;
	}
	public Flow_Condition setOperation(OperationType operation) {
		this.operation = operation;
		return this;
	}
	
	public String getPresent() {
		return present;
	}
	public Flow_Condition setPresent(String present) {
		this.present = present;
		return this;
	}
	
	public String getName() {
		return name;
	}
	public Flow_Condition setName(String name) {
		this.name = name;
		return this;
	}
	
	public List<Vtn_Flow_Match> getVtn_flow_match() {
		return vtn_flow_match;
	}
	public Flow_Condition setVtn_flow_match(List<Vtn_Flow_Match> vtn_flow_match) {
		this.vtn_flow_match = vtn_flow_match;
		return this;
	}
	
	
	
	
	@Override
	public String toString() {
		return "Flow_Condition [operation=" + operation + ", present=" + present + ", name=" + name
				+ ", vtn_flow_match=" + vtn_flow_match + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((operation == null) ? 0 : operation.hashCode());
		result = prime * result + ((present == null) ? 0 : present.hashCode());
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
		Flow_Condition other = (Flow_Condition) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (operation != other.operation)
			return false;
		if (present == null) {
			if (other.present != null)
				return false;
		} else if (!present.equals(other.present))
			return false;
		if (vtn_flow_match == null) {
			if (other.vtn_flow_match != null)
				return false;
		} else if (!vtn_flow_match.equals(other.vtn_flow_match))
			return false;
		return true;
	}
	public void send(String node) throws ODL_IO_Exception {
		// TODO Auto-generated method stub
		String url="http://"+VtnConfigUrl+"/vtn-flow-condition:set-flow-condition";
		//String url="http://127.0.0.1:8181/restconf/operations/vtn-flow-condition:set-flow-condition";
		JSONObject jsonObject=new JSONObject();
		jsonObject.put("input", JSONObject.parseObject(JSON.toJSONString(this)));
	    String []response=HttpUtil.Post_request(url,jsonObject);
	    String responsecode=response[0];
	    String responsebody=response[1];
	    if(!"201".equals(responsecode) && !"200".equals(responsecode))
	    	throw new ConfigException("flow condition"+this.getName()+"created failed");
	}
	
	public void remove(String node) throws ODL_IO_Exception {
		// TODO Auto-generated method stub
		String url="http://"+VtnConfigUrl+"vtn-flow-condition:remove-flow-condition";
		JSONObject jsonObject=new JSONObject();
		JSONObject fcjson=new JSONObject();
		fcjson.put("name", this.name);
		jsonObject.put("input", fcjson);
		String responsecode=HttpUtil.Post_request(url,jsonObject)[0];
		if(!"200".equals(responsecode) && !"201".equals(responsecode) && !"404".equals(responsecode))
				throw new ConfigException("faied to delete flow condition "+this.name);
		
	}

}
