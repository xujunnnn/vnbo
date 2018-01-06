package com.ebupt.vnbo.entity.flow_filter;

import java.util.ArrayList;
import java.util.List;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.annotation.JSONField;
import com.ebupt.vnbo.entity.abstracts.Config;
import com.ebupt.vnbo.entity.exception.ConfigException;
import com.ebupt.vnbo.entity.exception.ODL_IO_Exception;
import com.ebupt.vnbo.util.BaseUtil;
import com.ebupt.vnbo.util.HttpUtil;

/*
{
    "input": {
        "vtn-flow-filter": [
            {
                "condition": "cond_1",
                "vtn-drop-filter": {},
                "index": "1"
            },
            {
                "condition": "cond_2",
                "vtn-pass-filter": {},
                "index": "2"
            },
            {
                "condition": "cond_3",
                "vtn-redirect-filter": {
                    "redirect-destination": {
                        "tenant-name": "vtn2",
                        "bridge-name": "vbr2",
                        "router-name": "0",
                        "terminal-name": "terminal2",
                        "interface-name": "if2"
                    },
                    "output": "false"
                },
                "index": "3"
            }
        ],
        "output": "true",
        "tenant-name": "vtn1",
        "bridge-name": "vbr1",
        "router-name": "0",
        "terminal-name": "terminal1",
        "interface-name": "if1"
    }
}
 */
public class Flow_Filter implements Config {

    private List<String> indices;
	@JSONField(name="vtn-flow-filter")
	private List< Vtn_Flow_Filter> vtn_flow_filter;
	private boolean output;
	@JSONField(name="tenant-name")
	private String tenant_name;
	@JSONField(name="bridge-name")
	private String bridge_name;
	@JSONField(name="router-name")
	private String router_name;
	@JSONField(name="terminal-name")
	private String terminal_name;
	@JSONField(name="interface-name")
	private String interface_name;
	
	private static final String ConfigUrl=BaseUtil.getODL_IP()+"/restconf/config";
	private static final String VtnConfigUrl=BaseUtil.getODL_IP()+"/restconf/operations";
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((bridge_name == null) ? 0 : bridge_name.hashCode());
		result = prime * result + ((indices == null) ? 0 : indices.hashCode());
		result = prime * result + ((interface_name == null) ? 0 : interface_name.hashCode());
		result = prime * result + (output ? 1231 : 1237);
		result = prime * result + ((router_name == null) ? 0 : router_name.hashCode());
		result = prime * result + ((tenant_name == null) ? 0 : tenant_name.hashCode());
		result = prime * result + ((terminal_name == null) ? 0 : terminal_name.hashCode());
		result = prime * result + ((vtn_flow_filter == null) ? 0 : vtn_flow_filter.hashCode());
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
		Flow_Filter other = (Flow_Filter) obj;
		if (bridge_name == null) {
			if (other.bridge_name != null)
				return false;
		} else if (!bridge_name.equals(other.bridge_name))
			return false;
		if (indices == null) {
			if (other.indices != null)
				return false;
		} else if (!indices.equals(other.indices))
			return false;
		if (interface_name == null) {
			if (other.interface_name != null)
				return false;
		} else if (!interface_name.equals(other.interface_name))
			return false;
		if (output != other.output)
			return false;
		if (router_name == null) {
			if (other.router_name != null)
				return false;
		} else if (!router_name.equals(other.router_name))
			return false;
		if (tenant_name == null) {
			if (other.tenant_name != null)
				return false;
		} else if (!tenant_name.equals(other.tenant_name))
			return false;
		if (terminal_name == null) {
			if (other.terminal_name != null)
				return false;
		} else if (!terminal_name.equals(other.terminal_name))
			return false;
		if (vtn_flow_filter == null) {
			if (other.vtn_flow_filter != null)
				return false;
		} else if (!vtn_flow_filter.equals(other.vtn_flow_filter))
			return false;
		return true;
	}
	public List<String> getIndices() {
		return indices;
	}
	public void setIndices(List<String> indices) {
		this.indices = indices;
	}
	public List<Vtn_Flow_Filter> getVtn_flow_filter() {
		return vtn_flow_filter;
	}
	public void setVtn_flow_filter(List<Vtn_Flow_Filter> vtn_flow_filter) {
		this.vtn_flow_filter = vtn_flow_filter;
	}
	public boolean getOutput() {
		return output;
	}
	public void setOutput(boolean output) {
		this.output = output;
	}
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
	public String getRouter_name() {
		return router_name;
	}
	public void setRouter_name(String router_name) {
		this.router_name = router_name;
	}
	public String getTerminal_name() {
		return terminal_name;
	}
	public void setTerminal_name(String terminal_name) {
		this.terminal_name = terminal_name;
	}
	public String getInterface_name() {
		return interface_name;
	}
	public void setInterface_name(String interface_name) {
		this.interface_name = interface_name;
	}
	public void send(String node) throws ODL_IO_Exception {
		// TODO Auto-generated method stub
		String url="http://"+VtnConfigUrl+"/vtn-flow-filter:set-flow-filter";
		JSONObject jsonObject=new JSONObject();
		jsonObject.put("input", JSONObject.toJSON(this));
		String[] response=HttpUtil.Post_request(url,jsonObject);
	    String responsecode=response[0];
	    String responsebody=response[1];
	    if(!"201".equals(responsecode) && !"200".equals(responsecode))
	    	throw new ConfigException("flow filter"+""+"created failed");
		
	}
	/*
	 http://127.0.0.1:8181/restconf/operations/vtn-flow-filter:remove-flow-filter

	{
	    "input": {
	        "indices": [
	            "10"
	        ],
	        "output": "false",
	        "tenant-name": "vtn1",
	        "bridge-name": "vbr1",
	        "interface-name": "if1"
	    }
	}
	 */
	public void remove(String node) throws ODL_IO_Exception {
		// TODO Auto-generated method stub
		String url="http://"+VtnConfigUrl+"/vtn-flow-filter:remove-flow-filter";
		
		JSONObject jsonObject2=new JSONObject();
		jsonObject2.put("input",JSON.toJSON(this));
		//System.out.println(JSON.toJSON(jsonObject2));
		String responsecode=HttpUtil.Post_request(url,jsonObject2)[0];
		if(!"200".equals(responsecode) && !"201".equals(responsecode) && !"404".equals(responsecode))
				throw new ConfigException("faied to delete Vtn "+this.tenant_name);
		
	}

}
