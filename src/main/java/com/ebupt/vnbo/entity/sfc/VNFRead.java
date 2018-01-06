package com.ebupt.vnbo.entity.sfc;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.alibaba.fastjson.annotation.JSONField;
import com.ebupt.vnbo.entity.abstracts.Operational;
import com.ebupt.vnbo.entity.enums.State;
import com.ebupt.vnbo.entity.enums.VNFType;
import com.ebupt.vnbo.entity.exception.ODL_IO_Exception;
import com.ebupt.vnbo.entity.exception.OperationalException;
import com.ebupt.vnbo.entity.vtn.Port;
import com.ebupt.vnbo.entity.vtn.VInterface;
import com.ebupt.vnbo.entity.vtn.VinterfaceRead;
import com.ebupt.vnbo.entity.vtn.VterminalRead;
import com.ebupt.vnbo.entity.vtn.VtnRead;

public class VNFRead implements Operational{
	private String name;
	private String vtopoName;
	private Port portA;
	private Port portB;
	private MapDetail portAMap;
	private MapDetail portBMap;
	
	private VNFType type;
	
	
	
	public VNFType getType() {
		return type;
	}
	public void setType(VNFType type) {
		this.type = type;
	}
	public String getVtopoName() {
		return vtopoName;
	}
	public VNFRead setVtopoName(String vtopoName) {
		this.vtopoName = vtopoName;
		return this;
	}
	public String getName() {
		return name;
	}
	public VNFRead setName(String name) {
		this.name = name;
		return this;
	}
	public Port getPortA() {
		return portA;
	}
	public VNFRead setPortA(Port portA) {
		this.portA = portA;
		return this;
	}
	public Port getPortB() {
		return portB;
	}
	public VNFRead setPortB(Port portB) {
		this.portB = portB;
		return this;
	}
	public MapDetail getPortAMap() {
		return portAMap;
	}
	public VNFRead setPortAMap(MapDetail portAMap) {
		this.portAMap = portAMap;
		return this;
	}
	public MapDetail getPortBMap() {
		return portBMap;
	}
	public VNFRead setPortBMap(MapDetail portBMap) {
		this.portBMap = portBMap;
		return this;
	}
	
	@Override
	public String toString() {
		return "VNFRead [name=" + name + ", vtopoName=" + vtopoName + ", portA=" + portA + ", portB=" + portB
				+ ", portAMap=" + portAMap + ", portBMap=" + portBMap + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((portA == null) ? 0 : portA.hashCode());
		result = prime * result + ((portAMap == null) ? 0 : portAMap.hashCode());
		result = prime * result + ((portB == null) ? 0 : portB.hashCode());
		result = prime * result + ((portBMap == null) ? 0 : portBMap.hashCode());
		result = prime * result + ((vtopoName == null) ? 0 : vtopoName.hashCode());
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
		VNFRead other = (VNFRead) obj;
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
		if (portAMap == null) {
			if (other.portAMap != null)
				return false;
		} else if (!portAMap.equals(other.portAMap))
			return false;
		if (portB == null) {
			if (other.portB != null)
				return false;
		} else if (!portB.equals(other.portB))
			return false;
		if (portBMap == null) {
			if (other.portBMap != null)
				return false;
		} else if (!portBMap.equals(other.portBMap))
			return false;
		if (vtopoName == null) {
			if (other.vtopoName != null)
				return false;
		} else if (!vtopoName.equals(other.vtopoName))
			return false;
		return true;
	}
	@Override
	public VNFRead read(String node) throws ODL_IO_Exception {
		// TODO Auto-generated method stub
		VtnRead vtnRead=new VtnRead();
		vtnRead.setTenant_name(vtopoName);
		vtnRead=vtnRead.read(null);
		if(vtnRead==null || vtnRead.getVterminalReads()==null){
			return null;
		}
		for(VterminalRead vt:vtnRead.getVterminalReads()){
			String vnfName=toVnfName(vt.getName());
			if(vnfName.equals(this.name)){
				if(vt.getName().charAt(vt.getName().length()-1)=='0'){
					Port portA=new Port();
					VinterfaceRead viA=vt.getVinterfaces().get(0);
					portA.setPort(viA.getPort_map_config().getPort_name());
					setPortA(portA);
					MapDetail mp=new MapDetail();
					mp.setMapped_port(viA.getVinterface_status().getMapped_port());
					mp.setVinterface(viA.getName());
					mp.setNode(viA.getPort_map_config().getNode());
					mp.setState(State.valueOf(viA.getVinterface_status().getState()));
					mp.setPortname(viA.getPort_map_config().getPort_name());
					mp.setVterminalName(vt.getName());
					setPortAMap(mp);
					setType(VNFType.valueOf(vt.getVterminal_config().getDescription()));
					
				}
				else {
					Port portB=new Port();
					VinterfaceRead viB=vt.getVinterfaces().get(0);
					portB.setPort(viB.getPort_map_config().getPort_name());
					setPortB(portB);
					MapDetail mp=new MapDetail();
					mp.setMapped_port(viB.getVinterface_status().getMapped_port());
					mp.setNode(viB.getPort_map_config().getNode());
					mp.setVinterface(viB.getName());
					mp.setState(State.valueOf(viB.getVinterface_status().getState()));
					mp.setPortname(viB.getPort_map_config().getPort_name());
					mp.setVterminalName(vt.getName());
					setPortBMap(mp);
				}
				if(this.portA!=null && this.portB!=null){
					return this;
				}
				
			}
			
			
		}
		return null;
		
	}
	
	
	public Set<VNFRead> readAll() throws ODL_IO_Exception{
		VtnRead vtnRead=new VtnRead();
		vtnRead.setTenant_name(vtopoName);
		vtnRead=vtnRead.read(null);
		
		Map<String, VNFRead> map=new HashMap<>();
		Set<VNFRead> vnfReads=new HashSet<>();
		if(vtnRead==null || vtnRead.getVterminalReads()==null)
			return vnfReads;
		
		for(VterminalRead vt:vtnRead.getVterminalReads()){
			VNFRead vnfRead=new VNFRead();
			vnfRead.setVtopoName(vtopoName);
			String vnfName=toVnfName(vt.getName());
			if(vnfName!=null){
				vnfRead.setName(vnfName);
				if(!map.containsKey(vnfName)){
				if(vt.getName().charAt(vt.getName().length()-1)=='0'){
					Port portA=new Port();
					VinterfaceRead viA=vt.getVinterfaces().get(0);
					portA.setPort(viA.getPort_map_config().getPort_name());
					vnfRead.setPortA(portA);
					MapDetail mp=new MapDetail();
					mp.setPortname(viA.getPort_map_config().getPort_name());
					mp.setMapped_port(viA.getVinterface_status().getMapped_port());
					mp.setVinterface(viA.getName());
					mp.setNode(viA.getPort_map_config().getNode());
					mp.setState(State.valueOf(viA.getVinterface_status().getState()));
					mp.setVterminalName(vt.getName());
					vnfRead.setPortAMap(mp);
					map.put(vnfName,vnfRead);
				}
				else {
					Port portB=new Port();
					VinterfaceRead viB=vt.getVinterfaces().get(0);
					portB.setPort(viB.getPort_map_config().getPort_name());
					vnfRead.setPortB(portB);
					MapDetail mp=new MapDetail();
					mp.setMapped_port(viB.getVinterface_status().getMapped_port());
					mp.setNode(viB.getPort_map_config().getNode());
					mp.setVinterface(viB.getName());
					mp.setState(State.valueOf(viB.getVinterface_status().getState()));
					mp.setPortname(viB.getPort_map_config().getPort_name());
					mp.setVterminalName(vt.getName());
					vnfRead.setPortBMap(mp);
					map.put(vnfName,vnfRead);
				}
				}
				else {
					vnfRead=map.get(vnfName);
					if(vt.getName().charAt(vt.getName().length()-1)=='0'){
						Port portA=new Port();
						VinterfaceRead viA=vt.getVinterfaces().get(0);
						portA.setPort(viA.getPort_map_config().getPort_name());
						vnfRead.setPortA(portA);
						MapDetail mp=new MapDetail();
						mp.setPortname(viA.getPort_map_config().getPort_name());
						mp.setMapped_port(viA.getVinterface_status().getMapped_port());
						mp.setVinterface(viA.getName());
						mp.setNode(viA.getPort_map_config().getNode());
						mp.setState(State.valueOf(viA.getVinterface_status().getState()));
						mp.setVterminalName(vt.getName());
						vnfRead.setPortAMap(mp);
						map.put(vnfName,vnfRead);
					}
					else {
						Port portB=new Port();
						VinterfaceRead viB=vt.getVinterfaces().get(0);
						portB.setPort(viB.getPort_map_config().getPort_name());
						vnfRead.setPortB(portB);
						MapDetail mp=new MapDetail();
						mp.setMapped_port(viB.getVinterface_status().getMapped_port());
						mp.setNode(viB.getPort_map_config().getNode());
						mp.setVinterface(viB.getName());
						mp.setState(State.valueOf(viB.getVinterface_status().getState()));
						mp.setVterminalName(vt.getName());
						mp.setPortname(viB.getPort_map_config().getPort_name());
						vnfRead.setPortBMap(mp);
						map.put(vnfName,vnfRead);
					}
					
				}
					   
			}
			
	
		}
		for(String name:map.keySet()){
			vnfReads.add(map.get(name));
		}
		return vnfReads;
		
	}
	
	private String toVnfName(String name){
		for(int i=name.length()-1;i>=0;i--){
			if(name.charAt(i)=='_'){
				return name.substring(0,i);
			}
		}
		return null;
		
	}
	
	

}
