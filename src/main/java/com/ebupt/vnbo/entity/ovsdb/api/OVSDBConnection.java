package com.ebupt.vnbo.entity.ovsdb.api;

import java.util.ArrayList;
import java.util.List;

import com.ebupt.vnbo.entity.abstracts.Config;
import com.ebupt.vnbo.entity.abstracts.Operational;
import com.ebupt.vnbo.entity.exception.ODL_IO_Exception;
import com.ebupt.vnbo.entity.ovsdb.config.NetworkNode;
import com.ebupt.vnbo.entity.ovsdb.config.OVSDBConnectionConfig;
import com.ebupt.vnbo.entity.ovsdb.config.OVSDBConnectionInfo;


public class OVSDBConnection implements Config,Operational{
	private String remoteip;
	private String remoteport;
	private String localip;
	private String localport;
	

	@Override
	public String toString() {
		return "OVSDBConnection [remoteip=" + remoteip + ", remoteport=" + remoteport + ", localip=" + localip
				+ ", localport=" + localport + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((localip == null) ? 0 : localip.hashCode());
		result = prime * result + ((localport == null) ? 0 : localport.hashCode());
		result = prime * result + ((remoteip == null) ? 0 : remoteip.hashCode());
		result = prime * result + ((remoteport == null) ? 0 : remoteport.hashCode());
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
		OVSDBConnection other = (OVSDBConnection) obj;
		if (localip == null) {
			if (other.localip != null)
				return false;
		} else if (!localip.equals(other.localip))
			return false;
		if (localport == null) {
			if (other.localport != null)
				return false;
		} else if (!localport.equals(other.localport))
			return false;
		if (remoteip == null) {
			if (other.remoteip != null)
				return false;
		} else if (!remoteip.equals(other.remoteip))
			return false;
		if (remoteport == null) {
			if (other.remoteport != null)
				return false;
		} else if (!remoteport.equals(other.remoteport))
			return false;
		return true;
	}
	public String getRemoteip() {
		return remoteip;
	}
	public void setRemoteip(String remoteip) {
		this.remoteip = remoteip;
	}
	public String getRemoteport() {
		return remoteport;
	}
	public void setRemoteport(String remoteport) {
		this.remoteport = remoteport;
	}
	public String getLocalip() {
		return localip;
	}
	public void setLocalip(String localip) {
		this.localip = localip;
	}
	public String getLocalport() {
		return localport;
	}
	public void setLocalport(String localport) {
		this.localport = localport;
	}
	@Override
	public void send(String node) throws ODL_IO_Exception {
		// TODO Auto-generated method stub
		OVSDBConnectionConfig config=new OVSDBConnectionConfig();
		OVSDBConnectionInfo connectionInfo=new OVSDBConnectionInfo();
		NetworkNode networkNode=new NetworkNode();
		networkNode.setNode_id("ovsdb://"+remoteip+":"+remoteport);
		connectionInfo.setRemote_ip(remoteip);
		connectionInfo.setRemote_port(remoteport);
		networkNode.setConnectionInfo(connectionInfo);
		List<NetworkNode> networkNodes=new ArrayList<>();
		networkNodes.add(networkNode);
		config.setNodes(networkNodes);
		config.send(null);
				
	}
	@Override
	public void remove(String node) throws ODL_IO_Exception {
		// TODO Auto-generated method stub
		OVSDBConnectionConfig config=new OVSDBConnectionConfig();
		config.remove(null);
	}
	@Override
	public Operational read(String node) throws ODL_IO_Exception {
		// TODO Auto-generated method stub
		return null;
	}
	
	

}
