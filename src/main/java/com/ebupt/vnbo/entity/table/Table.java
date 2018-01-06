package com.ebupt.vnbo.entity.table;

import com.alibaba.fastjson.JSONObject;
import com.ebupt.vnbo.entity.abstracts.Config;
import com.ebupt.vnbo.entity.exception.ConfigException;
import com.ebupt.vnbo.entity.exception.ODL_IO_Exception;
import com.ebupt.vnbo.util.BaseUtil;
import com.ebupt.vnbo.util.HttpUtil;
/**
 * 
* ����: Table.java <br/>
* ���� : com.ebupt.vnbo.classes.table <br/>
* ��ϸ����: TODO(Flow table ʵ����) <br/>
* ������Ա�� xujun   <br/>
* �������ڣ�2017��6��12�� <br/>
* �����汾�� V1.0  <br/>
 */
public class Table implements Config {

	private String tableid;
	private String node;
	
	private static final String ConfigUrl=BaseUtil.getODL_IP()+"/restconf/config";
	private static final String VtnConfigUrl=BaseUtil.getODL_IP()+"/restconf/operations";
	public String getNode() {
		return node;
	}

	public Table setNode(String node) {
		this.node = node;
		return this;
	}

	public String getTableid() {
		return tableid;
	}

	public Table setTableid(String tableid) {
		this.tableid = tableid;
		return this;
	}
	
	
	

	@Override
	public String toString() {
		return "Table [tableid=" + tableid + ", node=" + node + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((node == null) ? 0 : node.hashCode());
		result = prime * result + ((tableid == null) ? 0 : tableid.hashCode());
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
		Table other = (Table) obj;
		if (node == null) {
			if (other.node != null)
				return false;
		} else if (!node.equals(other.node))
			return false;
		if (tableid == null) {
			if (other.tableid != null)
				return false;
		} else if (!tableid.equals(other.tableid))
			return false;
		return true;
	}

	@Override
	public void send(String node) throws ODL_IO_Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void remove(String node) throws ODL_IO_Exception {
		// TODO Auto-generated method stub
		String url="http://"+ConfigUrl+"/opendaylight-inventory:nodes/node/"+node+"/flow-node-inventory:table/"+tableid;
		String s[]=HttpUtil.Delete_request(url);
	   String responsecode=s[0];
	   if(!"200".equals(responsecode) && !"201".equals(responsecode) && !"404".equals(responsecode))
		   throw new ConfigException("Table "+tableid+" delete fail");
	}



}
