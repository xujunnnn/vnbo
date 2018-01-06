package com.ebupt.vnbo.ServiceImpl.vtopo;

import java.util.List;
import java.util.Set;

import org.apache.ibatis.annotations.Results;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ebupt.vnbo.entity.enums.OperationType;
import com.ebupt.vnbo.entity.enums.RespCode;
import com.ebupt.vnbo.entity.exception.ODL_IO_Exception;
import com.ebupt.vnbo.entity.result.Result;
import com.ebupt.vnbo.entity.vtn.Vterminal;
import com.ebupt.vnbo.entity.vtopo.MacAclList;
import com.ebupt.vnbo.entity.vtopo.VGroup;
import com.ebupt.vnbo.entity.vtopo.VHost;
import com.ebupt.vnbo.entity.vtopo.VPort;
import com.ebupt.vnbo.entity.vtopo.VTopo;
import com.ebupt.vnbo.service.Vtopo.VtopoService;
import com.ebupt.vnbo.service.topology.TopologyService;
@Service
public class VtopoServiceImpl implements VtopoService{
	@Autowired
	private TopologyService topologyService;

	@Override
	public Result<VTopo> addVtopo(String name,VTopo vTopo) throws ODL_IO_Exception {
		// TODO Auto-generated method stub
		Result<VTopo> result=new Result<>();
		vTopo.send(null);
		result.setDescription("Vtopo created Success");
		result.setResult(vTopo);
		result.setStatus(RespCode.success);
		return result;
	}

	@Override
	public Result<VTopo> deleteVtopo(String name) throws ODL_IO_Exception {
		// TODO Auto-generated method stub
		Result<VTopo> result=new Result<>();
		VTopo vTopo=new VTopo();
		vTopo.setVtopo_name(name);
		vTopo=vTopo.read(null);
		result.setResult(vTopo);
		vTopo.remove(null);
		result.setDescription("success to remove Vtopo");
		result.setStatus(RespCode.success);
		return result;
		
	}

	@Override
	public Result<VTopo> querryVtopo(String name) throws ODL_IO_Exception {
		// TODO Auto-generated method stub
		Result<VTopo> result=new Result<>();
		VTopo vTopo=new VTopo();
		vTopo.setVtopo_name(name);
		vTopo=vTopo.read(null);
		result.setDescription("success to querry Vtopo");
		result.setStatus(RespCode.success);
		result.setResult(vTopo);
		return result;
	}

	@Override
	public Result<Set<VTopo>> querryVtopos() throws ODL_IO_Exception {
		// TODO Auto-generated method stub
		Result<Set<VTopo>> result=new Result<>();
		VTopo vTopo=new VTopo();
		Set<VTopo> vTopos=vTopo.readAll();
		result.setResult(vTopos);
		result.setDescription("success to querry all Vtopos");
		result.setStatus(RespCode.success);
		return result;
		
	}

	@Override
	public Result<VGroup> addVGroup(String Vtopo,String name,VGroup vGroup) throws ODL_IO_Exception {
		// TODO Auto-generated method stub
		Result<VGroup> result=new Result<>();
		vGroup.send(null);
		result.setResult(vGroup);
		result.setDescription("success to add Vgroup");
		result.setStatus(RespCode.success);
		return result;
	}

	@Override
	public Result<VGroup> deleteVGroup(String Vtopo,String name) throws ODL_IO_Exception {
		// TODO Auto-generated method stub
		Result<VGroup> result=new Result<>();
		VGroup vGroup=new VGroup();
		vGroup.setVtoponame(Vtopo)
			  .setGroup_id(name)
			  .remove(null);
		result.setResult(vGroup);
		result.setDescription("success to delete VGroup");
		result.setStatus(RespCode.success);
		return result;
		
		
		
		
	}

	@Override
	public Result<VGroup> querryVGroup(String Vtopo,String name) throws ODL_IO_Exception {
		// TODO Auto-generated method stub
		Result<VGroup> result=new Result<>();
		VGroup vGroup=new VGroup();
		vGroup.setVtoponame(Vtopo).setGroup_id(name);
		result.setResult(vGroup.read(null));
		result.setDescription("success to querry VGroup");
		result.setStatus(RespCode.success);
		return result;
	}

	@Override
	public Result<List<VGroup>> querryVGroups(String Vtopo) throws ODL_IO_Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Result<VPort> addVPort(String Vtopo, String vGroup, String name,VPort vPort) throws ODL_IO_Exception {
		// TODO Auto-generated method stub
		Result<VPort> result=new Result<>();
		vPort.send(null);
		result.setResult(vPort);
		result.setDescription("success to add vPort "+vPort.getVport());
		result.setStatus(RespCode.success);
		return result;
	}
	
	@Override
	public Result<List<VPort>> addVPort(String Vtopo, String vGroup, String name,List<VPort> vPorts) throws ODL_IO_Exception {
		// TODO Auto-generated method stub
		Result<List<VPort>> result=new Result<>();
		for(VPort vPort:vPorts){
			vPort.setVtopo(Vtopo);
			vPort.setvGroup(vGroup);
			vPort.send(null);
		}
		result.setResult(vPorts);
		result.setDescription("success to add vPorts");
		result.setStatus(RespCode.success);
		return result;
	}
	
	@Override
	public Result<VPort> deleteVPort(String Vtopo, String vGroup, String name) throws ODL_IO_Exception {
		// TODO Auto-generated method stub
		Result<VPort> result=new Result<>();
		VPort vPort=new VPort();
		vPort.setVtopo(Vtopo);
		vPort.setvGroup(vGroup);
		vPort.setVport(name);
		vPort.remove(null);
		result.setResult(vPort);
		result.setDescription("success to delete vPort "+name);
		result.setStatus(RespCode.success);
		return result;
	}

	@Override
	public Result<VPort> querryVPort(String Vtopo, String vGroup, String name) throws ODL_IO_Exception {
		// TODO Auto-generated method stub
		Result<VPort> result=new Result<>();
		VPort vPort=new VPort();
		vPort.setVtopo(Vtopo);
		vPort.setvGroup(vGroup);
		vPort.setVport(name);
		result.setResult(vPort.read(null));
		result.setDescription("sucess to querry Vport "+name);
		result.setStatus(RespCode.success);
		return result;
		
	}

	@Override
	public Result<List<VPort>> querryVPorts(String Vtopo, String vGroup) throws ODL_IO_Exception {
		// TODO Auto-generated method stub
		Result<List<VPort>> result=new Result<>();
		VPort vPort=new VPort();
		vPort.setVtopo(Vtopo);
		vPort.setvGroup(vGroup);
		result.setResult(vPort.readAll());
		result.setDescription("success to querry vPorts");
		result.setStatus(RespCode.success);
		return result;
		
	}

	@Override
	public Result<List<String>> addHost(List<String> hosts) throws ODL_IO_Exception {
		// TODO Auto-generated method stub
		Result<List<String>> result=new Result<>();
		MacAclList aclList=new MacAclList();
		aclList.setOperation(OperationType.ADD);
		aclList.setHosts(hosts);
		aclList.send(null);
		result.setResult(hosts);
		result.setStatus(RespCode.success);
		result.setDescription("success to add host");
		return result;
		
	}

	@Override
	public Result<List<String>> delHost(List<String> hosts) throws ODL_IO_Exception {
		// TODO Auto-generated method stub
		Result<List<String>> result=new Result<>();
		MacAclList aclList=new MacAclList();
		aclList.setOperation(OperationType.REMOVE);
		aclList.setHosts(hosts);
		aclList.send(null);
		result.setResult(hosts);
		result.setStatus(RespCode.success);
		result.setDescription("success to remove host");
		return result;
	}

	@Override
	public Result<List<String>> querryHost() throws ODL_IO_Exception {
		// TODO Auto-generated method stub
		Result<List<String>> result=new Result<>();
		MacAclList macAclList=new MacAclList();
		macAclList=macAclList.read(null);
		result.setResult(macAclList.getHosts());
		result.setDescription("success to read hosts");
		result.setStatus(RespCode.success);
		return result;
	}

	@Override
	public Result<VHost> addVHost(String Vtopo, String vGroup, String name, VHost vHost) throws ODL_IO_Exception {
		// TODO Auto-generated method stub
		Result<VHost> result=new Result<>();
		vHost.setVtopo(Vtopo);
		vHost.setVGroup(vGroup);
		vHost.setHostName(name);
		vHost.send(null);
		result.setResult(vHost);
		result.setDescription("success to add VHost");
		result.setStatus(RespCode.success);
		return result;
	}

	@Override
	public Result<VHost> deleteVHost(String Vtopo, String vGroup, String name) throws ODL_IO_Exception {
		// TODO Auto-generated method stub
		Result<VHost> result=new Result<>();
		VHost vHost=new VHost();
		vHost.setVtopo(Vtopo);
		vHost.setVGroup(vGroup);
		vHost.setHostName(name);
		vHost.remove(null);
		result.setResult(vHost);
		result.setDescription("success to remove VHost");
		result.setStatus(RespCode.success);
		return result;
		
	}

	@Override
	public Result<VHost> querryVHost(String Vtopo, String vGroup, String name) throws ODL_IO_Exception {
		// TODO Auto-generated method stub
		return null;
	}

	

}
