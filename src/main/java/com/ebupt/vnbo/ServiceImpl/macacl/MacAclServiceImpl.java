package com.ebupt.vnbo.ServiceImpl.macacl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.ebupt.vnbo.entity.enums.OperationType;
import com.ebupt.vnbo.entity.enums.RespCode;
import com.ebupt.vnbo.entity.exception.ODL_IO_Exception;
import com.ebupt.vnbo.entity.result.Result;
import com.ebupt.vnbo.entity.vtn.MappedHost;
import com.ebupt.vnbo.entity.vtn_accesss.Vbridge;
import com.ebupt.vnbo.entity.vtn_accesss.Vtn;
import com.ebupt.vnbo.entity.vtopo.MacAclList;
import com.ebupt.vnbo.service.macacl.MacAclService;
@Service
public class MacAclServiceImpl implements MacAclService{
	public Result<MacAclList> addMacList(MacAclList macAclList) throws ODL_IO_Exception{
		Result<MacAclList> result=new Result<>();
		macAclList.setOperation(OperationType.ADD);
		macAclList.send(null);
		result.setResult(macAclList.read(null));
		result.setDescription("success to add MacList");
		result.setStatus(RespCode.success);
		return result;
	}
	
	public Result<MacAclList> removeMacList(MacAclList macAclList) throws ODL_IO_Exception{
		Result<MacAclList> result=new Result<>();
		macAclList.setOperation(OperationType.REMOVE);
		macAclList.send(null);
		result.setResult(macAclList.read(null));
		result.setDescription("success to remove MacList");
		result.setStatus(RespCode.success);
		return result;
	}
	public Result<MacAclList> querryMacList() throws ODL_IO_Exception{
		MacAclList macAclList=new MacAclList();
		Result<MacAclList> result=new Result<>();
		result.setResult(macAclList.read(null));
		result.setDescription("success to read MacList");
		result.setStatus(RespCode.success);
		return result;
		
	}

	@Override
	public Result<MacAclList> querryAbleMacList() throws ODL_IO_Exception {
		// TODO Auto-generated method stub
		Result<MacAclList> result=new Result<>();
		MacAclList macAclList=new MacAclList();
		macAclList=macAclList.read(null);
		List<String> hosts=macAclList.getHosts();
		List<String> busyhost=new ArrayList<String>();
		Vtn vtn=new Vtn();
		List<Vtn> vtns=vtn.readAll();
		if(vtns!=null){
			for(Vtn v:vtns){
				if(v.getVbridge()!=null){
					for(Vbridge vbridge:v.getVbridge()){
						if(vbridge.getMappedHost()!=null){
							for(MappedHost host:vbridge.getMappedHost()){
								busyhost.add(host.getMac()+"@0");
							}
						}
					}
				}
			}
		}
		hosts.removeAll(busyhost);
		macAclList.setHosts(hosts);
		result.setDescription("success to querry maclist");
		result.setStatus(RespCode.success);
		result.setResult(macAclList);
		return result;
	}

}
