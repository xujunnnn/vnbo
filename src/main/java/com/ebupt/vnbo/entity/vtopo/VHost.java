package com.ebupt.vnbo.entity.vtopo;

import java.util.HashSet;
import java.util.Set;

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
	
	@Override
	public String toString() {
		return "VHost [Vtopo=" + Vtopo + ", VGroup=" + VGroup + ", hostName=" + hostName + ", mac=" + mac + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((VGroup == null) ? 0 : VGroup.hashCode());
		result = prime * result + ((Vtopo == null) ? 0 : Vtopo.hashCode());
		result = prime * result + ((hostName == null) ? 0 : hostName.hashCode());
		result = prime * result + ((mac == null) ? 0 : mac.hashCode());
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
		if (mac == null) {
			if (other.mac != null)
				return false;
		} else if (!mac.equals(other.mac))
			return false;
		return true;
	}
	@Override
	public void send(String node) throws ODL_IO_Exception {
		// TODO Auto-generated method stub
		Mac_Map mac_Map=new Mac_Map();
		mac_Map.setOperation(OperationType.ADD);
		mac_Map.setTenant_name(Vtopo);
		mac_Map.setBridge_name(VGroup);
		Set<String> allowed_Hosts=new HashSet<>();
		if(hostName!=null && hostName.startsWith("host:")){
			String mac=hostName.substring(5);
			allowed_Hosts.add(mac+"@0");
		}
		else if(mac!=null){
			allowed_Hosts.add(mac+"@0");
		}
		mac_Map.setAllowed_hosts(allowed_Hosts);
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
