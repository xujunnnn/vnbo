package com.ebupt.vnbo.entity.vtopo;

import com.ebupt.vnbo.entity.abstracts.Config;
import com.ebupt.vnbo.entity.enums.OperationType;
import com.ebupt.vnbo.entity.exception.ODL_IO_Exception;
import com.ebupt.vnbo.entity.vtn.Allowed_Hosts;
import com.ebupt.vnbo.entity.vtn.Mac_Map;

public class VHost implements Config{
	private String Vtopo;
	private String VGroup;
	private String hostName;
	private String mac;
	private String ip;
	private String port;
	
	@Override
	public String toString() {
		return "VHost [Vtopo=" + Vtopo + ", VGroup=" + VGroup + ", hostName=" + hostName + ", mac=" + mac + ", ip=" + ip
				+ ", port=" + port + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((VGroup == null) ? 0 : VGroup.hashCode());
		result = prime * result + ((Vtopo == null) ? 0 : Vtopo.hashCode());
		result = prime * result + ((hostName == null) ? 0 : hostName.hashCode());
		result = prime * result + ((ip == null) ? 0 : ip.hashCode());
		result = prime * result + ((mac == null) ? 0 : mac.hashCode());
		result = prime * result + ((port == null) ? 0 : port.hashCode());
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
		VHost other = (VHost) obj;
		if (VGroup == null) {
			if (other.VGroup != null)
				return false;
		} else if (!VGroup.equals(other.VGroup))
			return false;
		if (Vtopo == null) {
			if (other.Vtopo != null)
				return false;
		} else if (!Vtopo.equals(other.Vtopo))
			return false;
		if (hostName == null) {
			if (other.hostName != null)
				return false;
		} else if (!hostName.equals(other.hostName))
			return false;
		if (ip == null) {
			if (other.ip != null)
				return false;
		} else if (!ip.equals(other.ip))
			return false;
		if (mac == null) {
			if (other.mac != null)
				return false;
		} else if (!mac.equals(other.mac))
			return false;
		if (port == null) {
			if (other.port != null)
				return false;
		} else if (!port.equals(other.port))
			return false;
		return true;
	}
	public String getVtopo() {
		return Vtopo;
	}
	public void setVtopo(String vtopo) {
		Vtopo = vtopo;
	}
	public String getVGroup() {
		return VGroup;
	}
	public void setVGroup(String vGroup) {
		VGroup = vGroup;
	}
	public String getHostName() {
		return hostName;
	}
	public void setHostName(String hostName) {
		this.hostName = hostName;
	}
	public String getMac() {
		return mac;
	}
	public void setMac(String mac) {
		this.mac = mac;
	}
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	public String getPort() {
		return port;
	}
	public void setPort(String port) {
		this.port = port;
	}
	@Override
	public void send(String node) throws ODL_IO_Exception {
		// TODO Auto-generated method stub
		Mac_Map mac_Map=new Mac_Map();
		mac_Map.setOperation(OperationType.ADD);
		mac_Map.setTenant_name(Vtopo);
		mac_Map.setBridge_name(VGroup);
		Allowed_Hosts allowed_Hosts=new Allowed_Hosts();
		if(hostName!=null && hostName.startsWith("host:")){
			String mac=hostName.substring(5);
			allowed_Hosts.addHost(mac+"@0");
		}
		else if(mac!=null){
			allowed_Hosts.addHost(mac+"@0");
		}
		mac_Map.send(null);
	}
	@Override
	public void remove(String node) throws ODL_IO_Exception {
		// TODO Auto-generated method stub
		Mac_Map mac_Map=new Mac_Map();
		mac_Map.setOperation(OperationType.REMOVE);
		mac_Map.setTenant_name(Vtopo);
		mac_Map.setBridge_name(VGroup);
		Allowed_Hosts allowed_Hosts=new Allowed_Hosts();
		if(hostName!=null && hostName.startsWith("host:")){
			String mac=hostName.substring(5);
			allowed_Hosts.addHost(mac+"@0");
		}
		else if(mac!=null){
			allowed_Hosts.addHost(mac+"@0");
		}
		mac_Map.send(null);
		
	}
	
	
	

}
