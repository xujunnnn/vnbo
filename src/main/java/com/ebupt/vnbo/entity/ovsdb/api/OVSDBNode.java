package com.ebupt.vnbo.entity.ovsdb.api;

import java.util.ArrayList;
import java.util.List;

import com.ebupt.vnbo.entity.abstracts.Config;
import com.ebupt.vnbo.entity.abstracts.Operational;
import com.ebupt.vnbo.entity.enums.OpenflowProtocol;
import com.ebupt.vnbo.entity.exception.ODL_IO_Exception;
import com.ebupt.vnbo.entity.ovsdb.config.OVSDBControllerEntryConfig;
import com.ebupt.vnbo.entity.ovsdb.config.OVSDBNodeConfig;
import com.ebupt.vnbo.entity.ovsdb.config.OVSDBProtocolEntryConfig;

public class OVSDBNode implements Config,Operational{
	private String host;
	private String name;
	private String ip;
	private OpenflowProtocol protocol;
	
	
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	public String getHost() {
		return host;
	}
	public void setHost(String host) {
		this.host = host;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public OpenflowProtocol getProtocol() {
		return protocol;
	}
	public void setProtocol(OpenflowProtocol protocol) {
		this.protocol = protocol;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((host == null) ? 0 : host.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((protocol == null) ? 0 : protocol.hashCode());
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
		OVSDBNode other = (OVSDBNode) obj;
		if (host == null) {
			if (other.host != null)
				return false;
		} else if (!host.equals(other.host))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (protocol != other.protocol)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "OVSDBNode [host=" + host + ", name=" + name + ", protocol=" + protocol + "]";
	}
	@Override
	public Operational read(String node) throws ODL_IO_Exception {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public void send(String node) throws ODL_IO_Exception {
		// TODO Auto-generated method stub
		OVSDBNodeConfig config=new OVSDBNodeConfig();
		String nodeid="ovsdb://"+host+"/bridge/"+name;
		config.setNode_id(nodeid);
		config.setHost(host);
		List<OVSDBControllerEntryConfig> configs=new ArrayList<>();
		OVSDBControllerEntryConfig controllerEntryConfig=new OVSDBControllerEntryConfig(ip);
		configs.add(controllerEntryConfig);
		config.setBridge_name(name);
		config.setControllerEntryConfig(configs);
		OVSDBProtocolEntryConfig protocolEntryConfig=new OVSDBProtocolEntryConfig();
		protocolEntryConfig.setProtocol(protocol.value());
		config.setProtocol(protocolEntryConfig);
		config.setManagedBy("/network-topology:network-topology/network-topology:topology[network-topology:topology-id='ovsdb:1']/network-topology:node[network-topology:node-id='ovsdb://"+host+"']");
		config.send(null);
	}
	@Override
	public void remove(String node) throws ODL_IO_Exception {
		// TODO Auto-generated method stub
		Config.super.remove(node);
	}
	
	
	

}
