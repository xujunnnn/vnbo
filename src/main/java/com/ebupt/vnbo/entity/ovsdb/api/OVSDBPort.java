package com.ebupt.vnbo.entity.ovsdb.api;

import com.ebupt.vnbo.entity.abstracts.Config;
import com.ebupt.vnbo.entity.exception.ODL_IO_Exception;
import com.ebupt.vnbo.entity.ovsdb.config.OVSDBTerminationConfig;

public class OVSDBPort implements Config{
	private String host;
	private String node;
	private String name;
	public String getHost() {
		return host;
	}
	public void setHost(String host) {
		this.host = host;
	}
	public String getNode() {
		return node;
	}
	public void setNode(String node) {
		this.node = node;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((host == null) ? 0 : host.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((node == null) ? 0 : node.hashCode());
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
		OVSDBPort other = (OVSDBPort) obj;
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
		if (node == null) {
			if (other.node != null)
				return false;
		} else if (!node.equals(other.node))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "OVSDBPort [host=" + host + ", node=" + node + ", name=" + name + "]";
	}
	@Override
	public void send(String n) throws ODL_IO_Exception {
		// TODO Auto-generated method stub
		OVSDBTerminationConfig terminationConfig=new OVSDBTerminationConfig();
		terminationConfig.setHost(host);
		terminationConfig.setNode(node);
		terminationConfig.setName(name);
		terminationConfig.setTp_id(name);
		terminationConfig.send(null);
	}
	@Override
	public void remove(String node) throws ODL_IO_Exception {
		// TODO Auto-generated method stub
		OVSDBTerminationConfig terminationConfig=new OVSDBTerminationConfig();
		terminationConfig.setHost(host);
		terminationConfig.setNode(node);
		terminationConfig.setName(name);
		terminationConfig.remove(null);
		
	}
	

}
