package com.ebupt.vnbo.entity.vtopo;

import java.util.ArrayList;
import java.util.List;

import com.ebupt.vnbo.ServiceImpl.topology.TopologyServiceImpl;
import com.ebupt.vnbo.entity.abstracts.Config;
import com.ebupt.vnbo.entity.abstracts.Operational;
import com.ebupt.vnbo.entity.enums.OperationType;
import com.ebupt.vnbo.entity.enums.UpDate_Mode;
import com.ebupt.vnbo.entity.exception.ODL_IO_Exception;
import com.ebupt.vnbo.entity.vtn.Port_Map;
import com.ebupt.vnbo.entity.vtn.VInterface;
import com.ebupt.vnbo.entity.vtn.VbridgeRead;
import com.ebupt.vnbo.entity.vtn.VinterfaceRead;
import com.ebupt.vnbo.service.topology.TopologyService;

public class VPort implements Config,Operational{
	private String vtopo;
	private String vGroup;
	private String vport;
	private String vInterface;
	private String port_name;
	
	@Override
	public String toString() {
		return "VPort [vtopo=" + vtopo + ", vGroup=" + vGroup + ", vport=" + vport + ", vInterface=" + vInterface
				+ ", port_name=" + port_name + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((port_name == null) ? 0 : port_name.hashCode());
		result = prime * result + ((vGroup == null) ? 0 : vGroup.hashCode());
		result = prime * result + ((vInterface == null) ? 0 : vInterface.hashCode());
		result = prime * result + ((vport == null) ? 0 : vport.hashCode());
		result = prime * result + ((vtopo == null) ? 0 : vtopo.hashCode());
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
		VPort other = (VPort) obj;
		if (port_name == null) {
			if (other.port_name != null)
				return false;
		} else if (!port_name.equals(other.port_name))
			return false;
		if (vGroup == null) {
			if (other.vGroup != null)
				return false;
		} else if (!vGroup.equals(other.vGroup))
			return false;
		if (vInterface == null) {
			if (other.vInterface != null)
				return false;
		} else if (!vInterface.equals(other.vInterface))
			return false;
		if (vport == null) {
			if (other.vport != null)
				return false;
		} else if (!vport.equals(other.vport))
			return false;
		if (vtopo == null) {
			if (other.vtopo != null)
				return false;
		} else if (!vtopo.equals(other.vtopo))
			return false;
		return true;
	}
	public String getVtopo() {
		return vtopo;
	}
	public void setVtopo(String vtopo) {
		this.vtopo = vtopo;
	}
	public String getvGroup() {
		return vGroup;
	}
	public void setvGroup(String vGroup) {
		this.vGroup = vGroup;
	}
	public String getVport() {
		return vport;
	}
	public void setVport(String vport) {
		this.vport = vport;
	}
	public String getvInterface() {
		return vInterface;
	}
	public void setvInterface(String vInterface) {
		this.vInterface = vInterface;
	}
	public String getPort_name() {
		return port_name;
	}
	public void setPort_name(String port_name) {
		this.port_name = port_name;
	}
	public void send(String node) throws ODL_IO_Exception {
		// TODO Auto-generated method stub
		String []info=vport.split(":");
		String nodename=info[0]+":"+info[1];
		String nodeid=info[1];
		String port=info[2];
		
		TopologyService service=new TopologyServiceImpl();
		VInterface vInterface=new VInterface();
		vInterface.setTenant_name(vtopo)
				  .setBridge_name(vGroup)
				  .setInterface_name(vtopo+"_"+vGroup+"_"+nodeid+"_"+port)
				  .setUpDate_Mode(UpDate_Mode.UPDATE)
				  .setEnabled(true)
				  .setOperation(OperationType.ADD);
		vInterface.send(null);
				
		Port_Map port_Map=new Port_Map();
		port_Map.setTenant_name(vtopo)
				.setBridge_name(vGroup)
				.setInterface_name(vInterface.getInterface_name())
				.setNode(nodename)
				.setPort_name(service.getPortName(vport));
		port_Map.send(null);
	}
	@Override
	public void remove(String node) throws ODL_IO_Exception {
		// TODO Auto-generated method stub
		read(null);
		VInterface vInterface=new VInterface();
		vInterface.setTenant_name(vtopo)
				  .setBridge_name(vGroup)
				  .setInterface_name(this.vInterface)
				  .remove(null);
		
	}
	@Override
	public VPort read(String node) throws ODL_IO_Exception {
		// TODO Auto-generated method stub
		VbridgeRead vbr=new VbridgeRead();
		vbr.setTenant_name(vtopo)
			.setBridge_name(vGroup);
		vbr=vbr.read(null);
		for(VinterfaceRead vir:vbr.getVinterface()){
			if(vir.getVinterface_status().getMapped_port().equals(this.vport)){
				setvInterface(vir.getName());
				setPort_name(vir.getPort_map_config().getPort_name());
				return this;
			}
		}
		return null;
	}
	
	public List<VPort> readAll() throws ODL_IO_Exception{
		List<VPort> vPorts=new ArrayList<>();
		VbridgeRead vbr=new VbridgeRead();
		vbr.setTenant_name(vtopo)
			.setBridge_name(vGroup);
		vbr=vbr.read(null);
		for(VinterfaceRead vir:vbr.getVinterface()){
			VPort vPort=new VPort();
			vPort.setVtopo(vtopo);
			vPort.setvGroup(vGroup);
			vPort.setVport(vir.getVinterface_status().getMapped_port());
			vPort.setvInterface(vir.getName());
			vPort.setPort_name(vir.getPort_map_config().getPort_name());
			vPort.setVport(vir.getVinterface_status().getMapped_port());
			vPorts.add(vPort);
		}
		return vPorts;
		
	}
	

}
