package com.ebupt.vnbo.ServiceImpl.macacl;

import org.springframework.stereotype.Service;

import com.ebupt.vnbo.entity.enums.OperationType;
import com.ebupt.vnbo.entity.enums.RespCode;
import com.ebupt.vnbo.entity.exception.ODL_IO_Exception;
import com.ebupt.vnbo.entity.result.Result;
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

}
