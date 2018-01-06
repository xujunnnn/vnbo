package com.ebupt.vnbo.entity.ovsdb.operational;

import java.util.List;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.annotation.JSONField;
import com.ebupt.vnbo.entity.abstracts.Operational;
import com.ebupt.vnbo.entity.exception.ODL_IO_Exception;
import com.ebupt.vnbo.util.BaseUtil;
import com.ebupt.vnbo.util.HttpUtil;

public class OVSDBNodeOperational implements Operational{
	public static final String OperationalUrl=BaseUtil.getODL_IP()+"/restconf/operational";
	public static final String VtnOperationUrl=BaseUtil.getODL_IP()+"/restconf/operations";
	private static final String ConfigUrl=BaseUtil.getODL_IP()+"/restconf/config";
	private static final String VtnConfigUrl=BaseUtil.getODL_IP()+"/restconf/operations";
	@JSONField(deserialize=true)
	private String host;
	@JSONField(name="node-id")
	private String node_id;
	@JSONField(name="ovsdb:stp_enable")
	private boolean stp_enable;
	@JSONField(name="ovsdb:datapath-id")
	private String datapath_id;
	@JSONField(name="ovsdb:bridge-name")
	private String bridge_name;
	
	@JSONField(name="termination-point")
	private List<OVSDBTerminationOperational> terminationPort;
	
	@JSONField(name="connection-info")
	private OVSDBConnectionOperational connection_info;
	@JSONField(name="ovsdb:db-version")
	private String db_version;
	@JSONField(name="ovsdb:ovs-version")
	private String ovs_version;
	
	public String getHost() {
		return host;
	}
	public void setHost(String host) {
		this.host = host;
	}
	public String getNode_id() {
		return node_id;
	}
	public void setNode_id(String node_id) {
		this.node_id = node_id;
	}
	public boolean isStp_enable() {
		return stp_enable;
	}
	public void setStp_enable(boolean stp_enable) {
		this.stp_enable = stp_enable;
	}
	public String getDatapath_id() {
		return datapath_id;
	}
	public void setDatapath_id(String datapath_id) {
		this.datapath_id = datapath_id;
	}
	public String getBridge_name() {
		return bridge_name;
	}
	public void setBridge_name(String bridge_name) {
		this.bridge_name = bridge_name;
	}
	public List<OVSDBTerminationOperational> getTerminationPort() {
		return terminationPort;
	}
	public void setTerminationPort(List<OVSDBTerminationOperational> terminationPort) {
		this.terminationPort = terminationPort;
	}
	public OVSDBConnectionOperational getConnection_info() {
		return connection_info;
	}
	public void setConnection_info(OVSDBConnectionOperational connection_info) {
		this.connection_info = connection_info;
	}
	public String getDb_version() {
		return db_version;
	}
	public void setDb_version(String db_version) {
		this.db_version = db_version;
	}
	public String getOvs_version() {
		return ovs_version;
	}
	public void setOvs_version(String ovs_version) {
		this.ovs_version = ovs_version;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((bridge_name == null) ? 0 : bridge_name.hashCode());
		result = prime * result + ((connection_info == null) ? 0 : connection_info.hashCode());
		result = prime * result + ((datapath_id == null) ? 0 : datapath_id.hashCode());
		result = prime * result + ((db_version == null) ? 0 : db_version.hashCode());
		result = prime * result + ((host == null) ? 0 : host.hashCode());
		result = prime * result + ((node_id == null) ? 0 : node_id.hashCode());
		result = prime * result + ((ovs_version == null) ? 0 : ovs_version.hashCode());
		result = prime * result + (stp_enable ? 1231 : 1237);
		result = prime * result + ((terminationPort == null) ? 0 : terminationPort.hashCode());
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
		OVSDBNodeOperational other = (OVSDBNodeOperational) obj;
		if (bridge_name == null) {
			if (other.bridge_name != null)
				return false;
		} else if (!bridge_name.equals(other.bridge_name))
			return false;
		if (connection_info == null) {
			if (other.connection_info != null)
				return false;
		} else if (!connection_info.equals(other.connection_info))
			return false;
		if (datapath_id == null) {
			if (other.datapath_id != null)
				return false;
		} else if (!datapath_id.equals(other.datapath_id))
			return false;
		if (db_version == null) {
			if (other.db_version != null)
				return false;
		} else if (!db_version.equals(other.db_version))
			return false;
		if (host == null) {
			if (other.host != null)
				return false;
		} else if (!host.equals(other.host))
			return false;
		if (node_id == null) {
			if (other.node_id != null)
				return false;
		} else if (!node_id.equals(other.node_id))
			return false;
		if (ovs_version == null) {
			if (other.ovs_version != null)
				return false;
		} else if (!ovs_version.equals(other.ovs_version))
			return false;
		if (stp_enable != other.stp_enable)
			return false;
		if (terminationPort == null) {
			if (other.terminationPort != null)
				return false;
		} else if (!terminationPort.equals(other.terminationPort))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "OVSDBNodeOperational [host=" + host + ", node_id=" + node_id + ", stp_enable=" + stp_enable
				+ ", datapath_id=" + datapath_id + ", bridge_name=" + bridge_name + ", terminationPort="
				+ terminationPort + ", connection_info=" + connection_info + ", db_version=" + db_version
				+ ", ovs_version=" + ovs_version + "]";
	}
	@Override
	public OVSDBNodeOperational read(String node) throws ODL_IO_Exception {
		// TODO Auto-generated method stub
		String url="http://+"+OperationalUrl+"+/network-topology:network-topology/topology/ovsdb:1/node/ovsdb:%2F%2F"+host+"%2Fbridge%2F"+bridge_name+"/";
		String [] response=HttpUtil.Get_request(url);
		String responsecode=response[0];
		String responsebody=response[1];
		JSONObject json=JSON.parseObject(responsebody);
		json=(JSONObject) json.getJSONArray("node").get(0);
		return JSON.toJavaObject(json, OVSDBNodeOperational.class);
	}
	
	

}
