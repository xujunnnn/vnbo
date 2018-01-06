package com.ebupt.vnbo.entity.ovsdb.operational;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.annotation.JSONField;
import com.ebupt.vnbo.entity.abstracts.Operational;
import com.ebupt.vnbo.entity.exception.ODL_IO_Exception;
import com.ebupt.vnbo.util.BaseUtil;
import com.ebupt.vnbo.util.HttpUtil;

public class OVSDBConnectionOperational implements Operational{
	public static final String OperationalUrl=BaseUtil.getODL_IP()+"/restconf/operational";
	public static final String VtnOperationUrl=BaseUtil.getODL_IP()+"/restconf/operations";
	private static final String ConfigUrl=BaseUtil.getODL_IP()+"/restconf/config";
	private static final String VtnConfigUrl=BaseUtil.getODL_IP()+"/restconf/operations";
	@JSONField(name="local-port")
	private String local_port;
	@JSONField(name="remote-ip")
	private String remote_ip;
	@JSONField(name="remote-ip")
	private String remote_port;
	@JSONField(name="local-ip")
	private String local_ip;
	public String getLocal_port() {
		return local_port;
	}
	public void setLocal_port(String local_port) {
		this.local_port = local_port;
	}
	public String getRemote_ip() {
		return remote_ip;
	}
	public void setRemote_ip(String remote_ip) {
		this.remote_ip = remote_ip;
	}
	public String getRemote_port() {
		return remote_port;
	}
	public void setRemote_port(String remote_port) {
		this.remote_port = remote_port;
	}
	public String getLocal_ip() {
		return local_ip;
	}
	public void setLocal_ip(String local_ip) {
		this.local_ip = local_ip;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((local_ip == null) ? 0 : local_ip.hashCode());
		result = prime * result + ((local_port == null) ? 0 : local_port.hashCode());
		result = prime * result + ((remote_ip == null) ? 0 : remote_ip.hashCode());
		result = prime * result + ((remote_port == null) ? 0 : remote_port.hashCode());
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
		OVSDBConnectionOperational other = (OVSDBConnectionOperational) obj;
		if (local_ip == null) {
			if (other.local_ip != null)
				return false;
		} else if (!local_ip.equals(other.local_ip))
			return false;
		if (local_port == null) {
			if (other.local_port != null)
				return false;
		} else if (!local_port.equals(other.local_port))
			return false;
		if (remote_ip == null) {
			if (other.remote_ip != null)
				return false;
		} else if (!remote_ip.equals(other.remote_ip))
			return false;
		if (remote_port == null) {
			if (other.remote_port != null)
				return false;
		} else if (!remote_port.equals(other.remote_port))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "OVSDBConnectionOperational [local_port=" + local_port + ", remote_ip=" + remote_ip + ", remote_port="
				+ remote_port + ", local_ip=" + local_ip + "]";
	}
	@Override
	public OVSDBConnectionOperational read(String node) throws ODL_IO_Exception {
		// TODO Auto-generated method stub
		String url="http://"+OperationalUrl+"/network-topology:network-topology/topology/ovsdb:1/";
		String[] response=HttpUtil.Get_request(url);
		String responsecode=response[0];
		String responsebody=response[1];
		if(!"200".equals(responsecode) && !"201".equals(responsecode) && !"204".equals(responsecode))
			throw new ODL_IO_Exception("failed to connect to the ovsdb detail:"+responsebody);
		
		return JSON.parseObject(responsebody, OVSDBConnectionOperational.class);
		
		
	}
	
	
}
