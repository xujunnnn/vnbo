package com.ebupt.vnbo.entity.vtopo;

import java.util.HashSet;
import java.util.Objects;
import com.alibaba.fastjson.JSONObject;
import com.ebupt.vnbo.ServiceImpl.topology.TopologyServiceImpl;
import com.ebupt.vnbo.entity.abstracts.Config;
import com.ebupt.vnbo.entity.abstracts.Operational;
import com.ebupt.vnbo.entity.enums.Map_Type;
import com.ebupt.vnbo.entity.enums.OperationType;
import com.ebupt.vnbo.entity.enums.UpDate_Mode;
import com.ebupt.vnbo.entity.exception.ODL_IO_Exception;
import com.ebupt.vnbo.entity.vtn.*;
import com.ebupt.vnbo.service.topology.TopologyService;
import com.fasterxml.jackson.annotation.JsonProperty;

public class VGroup implements Config,Operational {
	private HashSet<VHost> vHosts;
	private HashSet<VPort> vPorts;
	private String group_id;
	@JsonProperty(value="vtopo_name")
	private String vtoponame;
	public VGroup(){}

	public HashSet<VHost> getvHosts() {
		return vHosts;
	}

	public void setvHosts(HashSet<VHost> vHosts) {
		this.vHosts = vHosts;
	}

	public HashSet<VPort> getvPorts() {
		return vPorts;
	}
	public VGroup setvPorts(HashSet<VPort> vPorts) {
		this.vPorts = vPorts;
		return this;
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
		VbridgeRead vbridgeRead=new VbridgeRead().setTenant_name(vtoponame).setBridge_name(group_id);
		vbridgeRead=vbridgeRead.read(null);
		
		if(vbridgeRead!=null){
			if(vbridgeRead.getMac_Map()!=null){
				/**
				 * HashSet<VHost> vHosts=new HashSet<>();
				for(Hostmc hostmc:vbridgeRead.getMac_Map().getMac_Map_Config().getAllowedHosts().getVlan_host_desc_list()){
					vHosts.add(hostmc.getHostName());
				}
				setHost_names(host_names);
				 */
			}
			else if (vbridgeRead.getVinterface()!=null) {
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
		if(vPorts!=null && vPorts.size()!=0){
			for(VPort vPort:vPorts){
				vPort.setVtopo(vtoponame);
				vPort.setvGroup(group_id);
				vPort.send(null);
			}
		}
		if(vHosts!=null && vHosts.size()!=0){
			Mac_Map mac_Map=new Mac_Map();
			mac_Map.setOperation(OperationType.ADD);
			mac_Map.setTenant_name(vtoponame);
			mac_Map.setBridge_name(group_id);
			Allowed_Hosts allowed_Hosts=new Allowed_Hosts();
			for(VHost vHost:vHosts){	
				if(vHost.getHostName().startsWith("host:")){
					String mac=vHost.getHostName().substring(5);
					allowed_Hosts.addHost(mac+"@0");
				}			
			}
			mac_Map.send(null);
		}
		/**
		 * 	if(if_names!=null && if_names.size()>0){
			HashSet<VInterface> vInterfaces=new HashSet<>();
			for(int i=0;i<if_names.size();i++){
				VInterface vInterface=new VInterface();
				vInterface.setTenant_name(vtoponame)
				.setBridge_name(group_id)
				.setInterface_name(vtoponame+"_"+group_id+"_if_"+i);
				vInterfaces.add(vInterface);
						
			}
			
			HashSet<Port_Map> port_Maps=new HashSet<>();
			int count=0;
			for(String name:if_names){
				String []info=name.split(":");
				String nodename=info[0]+":"+info[1];
				Port_Map port_Map=new Port_Map();
				port_Map.setTenant_name(vtoponame)
				.setBridge_name(group_id)
				.setInterface_name(vtoponame+"_"+group_id+"_if_"+count)
				.setNode(nodename)
				.setPort_name(topoService.getPortName(name));
				count++;
				port_Maps.add(port_Map);
			}
			vbridge.setTenant_name(vtoponame)
			   .setBridge_name(group_id)
			   .setUpdate_mode(UpDate_Mode.CREATE)
			   .setOperation(OperationType.SET)
			   .setMap_type(Map_Type.port_map)
			   .setvInterfaces(vInterfaces)
			   .setPort_Maps(port_Maps)
			   .send(null);	
		 */
		
		/**
		 * 	}else {
			Allowed_Hosts allowed_Hosts=new Allowed_Hosts();
			for(String name:host_names){
				allowed_Hosts.addHost(topoService.get_host_from_name(name).getMac()+"@"+"0");
				}
			vbridge.setTenant_name(vtoponame)
				   .setBridge_name(group_id)
				   .setUpdate_mode(UpDate_Mode.CREATE)
				   .setOperation(OperationType.SET)
				   .Set_Mac_Map(allowed_Hosts, null)
				   .send(null);		
		}	
		 */
		
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
