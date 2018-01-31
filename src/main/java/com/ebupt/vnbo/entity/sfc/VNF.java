package com.ebupt.vnbo.entity.sfc;

import com.ebupt.vnbo.entity.abstracts.Config;
import com.ebupt.vnbo.entity.enums.OperationType;
import com.ebupt.vnbo.entity.enums.UpDate_Mode;
import com.ebupt.vnbo.entity.enums.VNFType;
import com.ebupt.vnbo.entity.exception.ODL_IO_Exception;
import com.ebupt.vnbo.entity.topology.Node;
import com.ebupt.vnbo.entity.topology.Termination_point;
import com.ebupt.vnbo.entity.vtn.Port;
import com.ebupt.vnbo.entity.vtn.Port_Map;
import com.ebupt.vnbo.entity.vtn.Static_edge_ports;
import com.ebupt.vnbo.entity.vtn.VInterface;
import com.ebupt.vnbo.entity.vtn.Vterminal;
import com.ebupt.vnbo.service.topology.TopologyService;
import com.fasterxml.jackson.annotation.JsonIgnore;
public class VNF implements Config{
	private String name;
	private String Vtoponame;
	private VNFType type;
	private Port portA;
	private Port portB;
	@JsonIgnore 
	private TopologyService topologyService;
	
	public void setTopologyService(TopologyService topologyService) {
		this.topologyService = topologyService;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getVtoponame() {
		return Vtoponame;
	}
	public void setVtoponame(String vtoponame) {
		Vtoponame = vtoponame;
	}
	public VNFType getType() {
		return type;
	}
	public void setType(VNFType type) {
		this.type = type;
	}
	public Port getPortA() {
		return portA;
	}
	public void setPortA(Port portA) {
		this.portA = portA;
	}
	public Port getPortB() {
		return portB;
	}
	public void setPortB(Port portB) {
		this.portB = portB;
	}
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((Vtoponame == null) ? 0 : Vtoponame.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((portA == null) ? 0 : portA.hashCode());
		result = prime * result + ((portB == null) ? 0 : portB.hashCode());
		result = prime * result + ((type == null) ? 0 : type.hashCode());
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
		VNF other = (VNF) obj;
		if (Vtoponame == null) {
			if (other.Vtoponame != null)
				return false;
		} else if (!Vtoponame.equals(other.Vtoponame))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (portA == null) {
			if (other.portA != null)
				return false;
		} else if (!portA.equals(other.portA))
			return false;
		if (portB == null) {
			if (other.portB != null)
				return false;
		} else if (!portB.equals(other.portB))
			return false;
		if (type != other.type)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "VNF [name=" + name + ", Vtoponame=" + Vtoponame + ", type=" + type + ", portA=" + portA + ", portB="
				+ portB + "]";
	}
	@Override
	public void send(String node) throws ODL_IO_Exception {
		// TODO Auto-generated method stub
		//发送静态拓扑
		Static_edge_ports static_edge_ports=new Static_edge_ports();
		static_edge_ports.addPorts(portA).addPorts(portB);
		static_edge_ports.send(null);
		
		Vterminal vterminal=new Vterminal();
		vterminal.setTenant_name(Vtoponame)
			     .setOperation(OperationType.SET)
			     .setUpDate_Mode(UpDate_Mode.CREATE)
			     .setTerminal_name(name+"_0")
			     .setDescription(this.type.name());
		vterminal.send(null);
		
		VInterface vInterface=new VInterface();
		vInterface.setTenant_name(Vtoponame)
				  .setTerminal_name(name+"_0")
				  .setInterface_name(name+"IF")
				  .setEnabled(true)
				  .setOperation(OperationType.SET)
				  .setUpDate_Mode(UpDate_Mode.CREATE);
		vInterface.send(null);
		
		Port_Map port_Map=new Port_Map();
		Termination_point tp=topologyService.getPortFromEth(portA.getPort());
		if(tp==null) {
			remove(null);
			throw new ODL_IO_Exception("cannot read port information of: "+portA.getPort());
		}
		Node n=topologyService.getNodeFromePort(tp);
		port_Map.setTenant_name(Vtoponame)
				.setTerminal_name(name+"_0")
				.setInterface_name(vInterface.getInterface_name())
				.setNode(n.getNode_id())
				.setPort_name(portA.getPort());
		port_Map.send(null);
		
		Vterminal vterminal1=new Vterminal();
		vterminal1.setTenant_name(Vtoponame)
			     .setOperation(OperationType.SET)
			     .setUpDate_Mode(UpDate_Mode.CREATE)
			     .setTerminal_name(name+"_1")
			     .setDescription(this.type.name());
		vterminal1.send(null);
		
		VInterface vInterface1=new VInterface();
		vInterface1.setTenant_name(Vtoponame)
				  .setTerminal_name(name+"_1")
				  .setInterface_name(name+"IF")
				  .setEnabled(true)
				  .setOperation(OperationType.SET)
				  .setUpDate_Mode(UpDate_Mode.CREATE);
		vInterface1.send(null);
		
		Port_Map port_Map1=new Port_Map();
		Termination_point tp1=topologyService.getPortFromEth(portB.getPort());
		if(tp1==null) {
			remove(null);
			throw new ODL_IO_Exception("cannot read port information of: "+portB.getPort());
		}
		Node n1=topologyService.getNodeFromePort(tp1);
		port_Map1.setTenant_name(Vtoponame)
				.setTerminal_name(name+"_1")
				.setInterface_name(vInterface1.getInterface_name())
				.setNode(n1.getNode_id())
				.setPort_name(portB.getPort());
		port_Map1.send(null);
	}
	@Override
	public void remove(String node) throws ODL_IO_Exception {
		// TODO Auto-generated method stub
		Vterminal vterminal=new Vterminal();
		
		vterminal.setTenant_name(Vtoponame)
				 .setTerminal_name(name+"_0");
		vterminal.remove(null);
		
		vterminal.setTenant_name(Vtoponame)
		 .setTerminal_name(name+"_1");
		vterminal.remove(null);
		
	}

	
	
	
	
	
	

}
