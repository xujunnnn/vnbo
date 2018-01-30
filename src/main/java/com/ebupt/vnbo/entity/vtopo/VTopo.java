package com.ebupt.vnbo.entity.vtopo;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.ebupt.vnbo.entity.abstracts.Config;
import com.ebupt.vnbo.entity.abstracts.Operational;
import com.ebupt.vnbo.entity.enums.OperationType;
import com.ebupt.vnbo.entity.enums.UpDate_Mode;
import com.ebupt.vnbo.entity.exception.ODL_IO_Exception;
import com.ebupt.vnbo.entity.exception.OperationalException;
import com.ebupt.vnbo.entity.vtn.*;
import com.ebupt.vnbo.util.HttpUtil;
import com.ebupt.vnbo.util.VTopoUtil;

/**
 * 
 * @author xu
 *
 */
public class VTopo implements Config,Operational {
	
	private HashSet<VGroup> vGroups=new HashSet<VGroup>();
	private HashSet<VLink> vLinks=new HashSet<VLink>();
	private String Vtopo_name;
	public HashSet<VGroup> getvGroups() {
		return vGroups;
	}
	public VTopo setvGroups(HashSet<VGroup> vGroups) {
		this.vGroups = vGroups;
		return this;
	}
	public HashSet<VLink> getvLinks() {
		return vLinks;
	}
	public VTopo setvLinks(HashSet<VLink> vLinks) {
		this.vLinks = vLinks;
		return this;
	}
	public String getVtopo_name() {
		return Vtopo_name;
	}
	public VTopo setVtopo_name(String vtopo_name) {
		Vtopo_name = vtopo_name;
		return this;
	}
	
	public VTopo addGroup(VGroup vGroup){
		this.vGroups.add(vGroup);
		return this;
	}
	
	public VTopo addLink(VLink vLink){
		this.vLinks.add(vLink);
		return this;
	}

	
	
	
	
	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return Objects.hash(vGroups,vLinks,Vtopo_name);
	}
	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		if(obj==null)
			return false;
		if(this==obj)
			return true;
		if(this.getClass()!=obj.getClass())
			return false;
		VTopo other=(VTopo) obj;
			return Objects.deepEquals(this.vGroups, other.getvGroups())  &&
							Objects.deepEquals(this.vLinks, other.getvLinks()) && 
							Objects.equals(this.Vtopo_name, other.getVtopo_name());
	}
	/**
	@Override
	public void send(String node) throws VtopoException ,VtnException, VbridgeException, Mac_MapFailException, TopoReadFailException {
		// TODO Auto-generated method stub
		VTopoUtil.initVlan(Vtopo_name);
		Vtn vtn=new Vtn();
		vtn.setTenant_name(Vtopo_name)
		   .setHard_timeout("10000").setIdle_timeout("1000")
		   .setOperation(OperationType.SET)
		   .setUpdate_mode(UpDate_Mode.CREATE)
		   .send(null);
		for(VGroup vGroup:vGroups){
			vGroup.setVtoponame(Vtopo_name).send(null);
		}
		for(VLink vLink:vLinks){
			vLink.setVtoponame(Vtopo_name).send(null);
		}
	}
	@Override
	public void remove(String node) throws EntrySetException {
		// TODO Auto-generated method stub
		Vtn vtn=new Vtn();
		vtn.setTenant_name(Vtopo_name);
		vtn.remove(null);
		
	}
	@Override
	public VTopo read(String node) throws EntrySetException {
		// TODO Auto-generated method stub
		VtnRead vtnRead=new VtnRead().setTenant_name(Vtopo_name);
		vtnRead=vtnRead.read(null);
		VTopo vTopo=this.Adapter(vtnRead);
		return vTopo;
	}
	/**

	 */
	public HashSet<VTopo> readAll() throws  ODL_IO_Exception{
		VtnRead vtnRead=new VtnRead();
		List<VtnRead> vtnReads=vtnRead.readAll();
		HashSet<VTopo> vTopos=new HashSet<>();
		
		 for(VtnRead vtr:vtnReads){
			//opo vTopo=Adapter(vtr);
			vTopos.add(new VTopo().setVtopo_name(vtr.getTenant_name()).read(null));
		}
		
	
		return vTopos;
	}


	
	 private VTopo Adapter(VtnRead vtnRead) {
		VTopo vTopo=new VTopo().setVtopo_name(vtnRead.getTenant_name());
		if(vtnRead.getVbridgeReads()!=null){
			for(VbridgeRead vbr:vtnRead.getVbridgeReads()){
				VGroup vGroup=new VGroup();
				vGroup.setVtoponame(vtnRead.getTenant_name())
					  .setGroup_id(vbr.getBridge_name());
				if(vbr.getVinterface()!=null){
					HashSet<VPort> vPorts=new HashSet<>();
					for(VinterfaceRead vir:vbr.getVinterface()){
						VPort vPort=new VPort();
						vPort.setVtopo(vtnRead.getTenant_name());
						vPort.setvGroup(vbr.getBridge_name());
						if(vir.getVinterface_status()!=null && vir.getVinterface_status().getMapped_port()!=null)
							vPort.setVport(vir.getVinterface_status().getMapped_port());
						vPort.setvInterface(vir.getName());
						vPorts.add(vPort);
					}
					vGroup.setvPorts(vPorts);
				}
				if(vbr.getMac_Map()!=null){
					
				}
				vTopo.addGroup(vGroup);
			}
		}
			return vTopo;

	}
	 

	@Override
	public VTopo read(String node) throws ODL_IO_Exception {
		// TODO Auto-generated method stub
		VtnRead vtnRead=new VtnRead().setTenant_name(Vtopo_name);
		
		vtnRead=vtnRead.read(null);
		if(vtnRead!=null && vtnRead.getVbridgeReads()!=null){
			for(VbridgeRead vbr:vtnRead.getVbridgeReads()){
				VGroup vGroup=new VGroup();
				vGroup.setVtoponame(Vtopo_name).setGroup_id(vbr.getBridge_name());
				vGroup.read(null);
				vGroups.add(vGroup);
			}
		}
		
		
		return this;
	}
	
	@Override
	public void send(String node) throws ODL_IO_Exception {
		// TODO Auto-generated method stub
		//VTopoUtil.initVlan(Vtopo_name);
		Vtn vtn=new Vtn();
		vtn.setTenant_name(Vtopo_name)
		   .setHard_timeout(VTN_FLOW_HARD).setIdle_timeout(VTN_FLOW_IDLE)
		   .setOperation(OperationType.SET)
		   .setUpdate_mode(UpDate_Mode.UPDATE)
		   .send(null);
		for(VGroup vGroup:vGroups){
			vGroup.setVtoponame(Vtopo_name).send(null);
		}
		for(VLink vLink:vLinks){
			vLink.setVtoponame(Vtopo_name).send(null);
		}
		
	}
	@Override
	public void remove(String node) throws ODL_IO_Exception {
		// TODO Auto-generated method stub
		Vtn vtn=new Vtn();
		vtn.setTenant_name(Vtopo_name);
		vtn.remove(null);
		
	}
	

	
	

}
