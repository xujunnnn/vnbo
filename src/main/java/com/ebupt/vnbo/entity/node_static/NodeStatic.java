package com.ebupt.vnbo.entity.node_static;

import java.util.ArrayList;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.annotation.JSONField;
import com.ebupt.vnbo.entity.abstracts.Operational;
import com.ebupt.vnbo.entity.exception.ODL_IO_Exception;
import com.ebupt.vnbo.entity.exception.OperationalException;
import com.ebupt.vnbo.util.BaseUtil;
import com.ebupt.vnbo.util.HttpUtil;
/**
 * 
* ����: NodeStatic.java <br/>
* ���� : com.ebupt.vnbo.classes.node_static <br/>
* ��ϸ����: TODO(�������ڵ���Ϣ) <br/>
* ������Ա�� xujun   <br/>
* �������ڣ�2017��6��11�� <br/>
* �����汾�� V1.0  <br/>
 */
public class NodeStatic implements Operational {
	public static final String OperationalUrl=BaseUtil.getODL_IP()+"/restconf/operational";
	public static final String VtnOperationUrl=BaseUtil.getODL_IP()+"/restconf/operations";
	private String id;
	@JSONField(name="node-connector")
	private ArrayList<Node_connector> node_connector;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public ArrayList<Node_connector> getNode_connector() {
		return node_connector;
	}
	public void setNode_connector(ArrayList<Node_connector> node_connector) {
		this.node_connector = node_connector;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((node_connector == null) ? 0 : node_connector.hashCode());
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
		NodeStatic other = (NodeStatic) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (node_connector == null) {
			if (other.node_connector != null)
				return false;
		} else if (!node_connector.equals(other.node_connector))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "NodeStatic [id=" + id + ", node_connector=" + node_connector + "]";
	}
	@Override
	public Operational read(String node) throws ODL_IO_Exception {
		// TODO Auto-generated method stub
		String url="http://"+OperationalUrl+"/opendaylight-inventory:nodes/node/"+node;
		String response[]=HttpUtil.Get_request(url);
		String responsebody=response[1];
		String responsecode=response[0];
		if(!"201".equals(responsecode) && !"200".equals(responsecode) )
			throw new OperationalException("NodeInfo read failed "+this.getId());
		JSONObject json=JSONObject.parseObject(responsebody);
		JSONObject nodejson=json.getJSONArray("node").getJSONObject(0);
		NodeStatic nodeStatic=JSON.toJavaObject(nodejson, NodeStatic.class);
		return nodeStatic;
	}
	

}
