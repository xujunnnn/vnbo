package com.ebupt.vnbo.entity.vtopo;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.ebupt.vnbo.ServiceImpl.topology.TopologyServiceImpl;
import com.ebupt.vnbo.entity.abstracts.Config;
import com.ebupt.vnbo.entity.abstracts.Operational;
import com.ebupt.vnbo.entity.enums.OperationType;
import com.ebupt.vnbo.entity.enums.UpDate_Mode;
import com.ebupt.vnbo.entity.exception.ODL_IO_Exception;
import com.ebupt.vnbo.entity.vtn.Allowed_Hosts;
import com.ebupt.vnbo.entity.vtn.MacMapRead;
import com.ebupt.vnbo.entity.vtn.Mac_Map;
import com.ebupt.vnbo.entity.vtn.MappedHost;
import com.ebupt.vnbo.entity.vtn.Vbridge;
import com.ebupt.vnbo.entity.vtn.VbridgeRead;
import com.ebupt.vnbo.entity.vtn.VinterfaceRead;
import com.ebupt.vnbo.service.topology.TopologyService;
import com.fasterxml.jackson.annotation.JsonProperty;

public class VGroup implements Config,Operational {
	private Set<VHost> vHosts;
	private Set<VPort> vPorts;
	private String group_id;
	@JsonProperty(value="vtopo_name")
	private String vtoponame;
	public VGroup(){}
	public Set<VHost> getvHosts() {
		return vHosts;
	}
	public void setvHosts(Set<VHost> vHosts) {
		this.vHosts = vHosts;
	}
	public Set<VPort> getvPorts() {
		return vPorts;
	}
	public void setvPorts(Set<VPort> vPorts) {
		this.vPorts = vPorts;
	}
	public String getGroup_id() {
		return group_id;
	}
	public VGroup setGroup_id(String group_id) {
		this.group_id = group_id;
		return this;
	}

	public String getVtoponame() {
		return vtoponame;
	}
	public VGroup setVtoponame(String vtoponame) {
		this.vtoponame = vtoponame;
		return this;
	}

	@Override
	public VGroup read(String node) throws ODL_IO_Exception {
		// TODO Auto-generated method stub
		MacMapRead macMapRead=new MacMapRead();
		macMapRead.setTenant_name(vtoponame);
		macMapRead.setBridge_name(group_id);
		if((macMapRead=macMapRead.read(null))!=null){
			List<MappedHost> mappedHosts=macMapRead.getMappedHost();
			Set<VHost> vHosts=new HashSet<>();
			for(MappedHost host:mappedHosts){
				VHost vHost=new VHost();
				vHost.setHostName("host:"+host.getMac());
				vHost.setMac(host.getMac());
				vHost.setVtopo(vtoponame);
				vHost.setVGroup(group_id);
				vHosts.add(vHost);
			}
			setvHosts(vHosts);
		}
		else {
			VbridgeRead vbridgeRead=new VbridgeRead().setTenant_name(vtoponame).setBridge_name(group_id);
			vbridgeRead=vbridgeRead.read(null);
			if(vbridgeRead==null)
				return null;
			if (vbridgeRead.getVinterface()!=null) {
				//HashSet<String> if_names=new HashSet<>();
				HashSet<VPort> vPorts=new HashSet<>();
				for(VinterfaceRead vinterfaceRead:vbridgeRead.getVinterface()){
					VPort vPort=new VPort();
					vPort.setVtopo(vtoponame);
					vPort.setvGroup(group_id);
					if(vinterfaceRead.getVinterface_status()!=null && vinterfaceRead.getVinterface_status().getMapped_port()!=null)
						vPort.setVport(vinterfaceRead.getVinterface_status().getMapped_port());
					if(vinterfaceRead.getPort_map_config()!=null && vinterfaceRead.getPort_map_config().getPort_name()!=null)
						vPort.setPort_name(vinterfaceRead.getPort_map_config().getPort_name());
					vPort.setvInterface(vinterfaceRead.getName());
					vPorts.add(vPort);
				//	if_names.add(vinterfaceRead.getPort_map_config().getPort_name());
					
				}
				//vGroup.setIf_names(if_names);
				setvPorts(vPorts);
			}
			
		}
		return this;
	}

	@Override
	public void send(String node) throws ODL_IO_Exception {
		// TODO Auto-generated method stub
		TopologyService topoService=new TopologyServiceImpl();
		Vbridge vbridge=new Vbridge();
		vbridge.setTenant_name(vtoponame)
		   .setBridge_name(group_id)
		   .setUpdate_mode(UpDate_Mode.CREATE)
		   .setOperation(OperationType.SET)
		   .send(null);	
		if(vHosts!=null && vHosts.size()!=0){
			Mac_Map mac_Map=new Mac_Map();
			mac_Map.setOperation(OperationType.ADD);
			mac_Map.setTenant_name(vtoponame);
			mac_Map.setBridge_name(group_id);
			Set<String> allowed_Hosts=new HashSet<>();
			for(VHost vHost:vHosts){	
				if(vHost.getHostName().startsWith("host:")){
					String mac=vHost.getHostName().substring(5);
					allowed_Hosts.add(mac+"@0");
				}			
			}
			mac_Map.setAllowed_hosts(allowed_Hosts);
			mac_Map.send(null);
		
		if(vPorts!=null && vPorts.size()!=0){
			for(VPort vPort:vPorts){
				vPort.setVtopo(vtoponame);
				vPort.setvGroup(group_id);
				vPort.send(null);
			}
		}
	}
	
		
		
		
	}

	@Override
	public void remove(String node) throws ODL_IO_Exception {
		// TODO Auto-generated method stub
		Vbridge vbridge=new Vbridge();
		vbridge.setBridge_name(group_id)
					  .setTenant_name(vtoponame)
					  .remove(null);
		
	}
}
