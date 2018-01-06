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
public class Node_connector implements Operational {
	public static final String OperationalUrl=BaseUtil.getODL_IP()+"/restconf/operational";
	public static final String VtnOperationUrl=BaseUtil.getODL_IP()+"/restconf/operations";
	private String id;
	@JSONField(name="flow-node-inventory-configuration")
	private String flow_node_inventory_configuration;
	@JSONField(name="flow-node-inventory-hardware-address")
    private String flow_node_inventory_hardware_address;
	@JSONField(name="flow-node-inventory:name")
	private String flow_node_inventory_name;
	@JSONField(name="flow-node-inventory-current-speed")
    private String flow_node_inventory_current_speed;
	@JSONField(name="flow-node-inventory-maximum-speed")
    private String flow_node_inventory_maximum_speed;
	@JSONField(name="opendaylight-port-statistics:flow-capable-node-connector-statistics")
	private Node_Connector_Static node_Connector_Static;
	@JSONField(name="flow-node-inventory:queue")
	private ArrayList<Queue> queues;
	
	public Node_connector(String id) {
		// TODO Auto-generated constructor stub
		this.id=id;
	}
	public Node_connector() {
		// TODO Auto-generated constructor stub
	}
	
	
	public final String getId() {
		return id;
	}
	public final void setId(String id) {
		this.id = id;
	}
	public final String getFlow_node_inventory_configuration() {
		return flow_node_inventory_configuration;
	}
	public final void setFlow_node_inventory_configuration(String flow_node_inventory_configuration) {
		this.flow_node_inventory_configuration = flow_node_inventory_configuration;
	}
	public final String getFlow_node_inventory_hardware_address() {
		return flow_node_inventory_hardware_address;
	}
	public final void setFlow_node_inventory_hardware_address(String flow_node_inventory_hardware_address) {
		this.flow_node_inventory_hardware_address = flow_node_inventory_hardware_address;
	}
	public final String getFlow_node_inventory_name() {
		return flow_node_inventory_name;
	}
	public final void setFlow_node_inventory_name(String flow_node_inventory_name) {
		this.flow_node_inventory_name = flow_node_inventory_name;
	}
	public final String getFlow_node_inventory_current_speed() {
		return flow_node_inventory_current_speed;
	}
	public final void setFlow_node_inventory_current_speed(String flow_node_inventory_current_speed) {
		this.flow_node_inventory_current_speed = flow_node_inventory_current_speed;
	}
	public final String getFlow_node_inventory_maximum_speed() {
		return flow_node_inventory_maximum_speed;
	}
	public final void setFlow_node_inventory_maximum_speed(String flow_node_inventory_maximum_speed) {
		this.flow_node_inventory_maximum_speed = flow_node_inventory_maximum_speed;
	}
	public final Node_Connector_Static getNode_Connector_Static() {
		return node_Connector_Static;
	}
	public final void setNode_Connector_Static(Node_Connector_Static node_Connector_Static) {
		this.node_Connector_Static = node_Connector_Static;
	}
	public final ArrayList<Queue> getQueues() {
		return queues;
	}
	public final void setQueues(ArrayList<Queue> queues) {
		this.queues = queues;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((flow_node_inventory_configuration == null) ? 0 : flow_node_inventory_configuration.hashCode());
		result = prime * result
				+ ((flow_node_inventory_current_speed == null) ? 0 : flow_node_inventory_current_speed.hashCode());
		result = prime * result + ((flow_node_inventory_hardware_address == null) ? 0
				: flow_node_inventory_hardware_address.hashCode());
		result = prime * result
				+ ((flow_node_inventory_maximum_speed == null) ? 0 : flow_node_inventory_maximum_speed.hashCode());
		result = prime * result + ((flow_node_inventory_name == null) ? 0 : flow_node_inventory_name.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((node_Connector_Static == null) ? 0 : node_Connector_Static.hashCode());
		result = prime * result + ((queues == null) ? 0 : queues.hashCode());
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
		Node_connector other = (Node_connector) obj;
		if (flow_node_inventory_configuration == null) {
			if (other.flow_node_inventory_configuration != null)
				return false;
		} else if (!flow_node_inventory_configuration.equals(other.flow_node_inventory_configuration))
			return false;
		if (flow_node_inventory_current_speed == null) {
			if (other.flow_node_inventory_current_speed != null)
				return false;
		} else if (!flow_node_inventory_current_speed.equals(other.flow_node_inventory_current_speed))
			return false;
		if (flow_node_inventory_hardware_address == null) {
			if (other.flow_node_inventory_hardware_address != null)
				return false;
		} else if (!flow_node_inventory_hardware_address.equals(other.flow_node_inventory_hardware_address))
			return false;
		if (flow_node_inventory_maximum_speed == null) {
			if (other.flow_node_inventory_maximum_speed != null)
				return false;
		} else if (!flow_node_inventory_maximum_speed.equals(other.flow_node_inventory_maximum_speed))
			return false;
		if (flow_node_inventory_name == null) {
			if (other.flow_node_inventory_name != null)
				return false;
		} else if (!flow_node_inventory_name.equals(other.flow_node_inventory_name))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (node_Connector_Static == null) {
			if (other.node_Connector_Static != null)
				return false;
		} else if (!node_Connector_Static.equals(other.node_Connector_Static))
			return false;
		if (queues == null) {
			if (other.queues != null)
				return false;
		} else if (!queues.equals(other.queues))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Node_connector [id=" + id + ", flow_node_inventory_configuration=" + flow_node_inventory_configuration
				+ ", flow_node_inventory_hardware_address=" + flow_node_inventory_hardware_address
				+ ", flow_node_inventory_name=" + flow_node_inventory_name + ", flow_node_inventory_current_speed="
				+ flow_node_inventory_current_speed + ", flow_node_inventory_maximum_speed="
				+ flow_node_inventory_maximum_speed + ", node_Connector_Static=" + node_Connector_Static + ", queues="
				+ queues + "]";
	}
	@Override
	public Node_connector read(String node) throws ODL_IO_Exception {
		// TODO Auto-generated method stub
		String []info=this.id.split(":");
		node=info[0]+":"+info[1];
		String url="http://"+OperationalUrl+"/opendaylight-inventory:nodes/node/"+node+"/node-connector/"+this.id;
		String response[]=HttpUtil.Get_request(url);
		String responsebody=response[1];
		String responsecode=response[0];
		if(!"201".equals(responsecode) && !"200".equals(responsecode) )
			throw new OperationalException("NodeInfo read failed "+this.getId());
		JSONObject json=JSONObject.parseObject(responsebody);
		JSONObject nodeconjson=json.getJSONArray("node-connector").getJSONObject(0);
		Node_connector connector=JSON.toJavaObject(nodeconjson, Node_connector.class);
		return connector;
	}	
	
  
	

}
