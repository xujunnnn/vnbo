package com.ebupt.vnbo.ServiceImpl.sfc;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ebupt.vnbo.entity.enums.RespCode;
import com.ebupt.vnbo.entity.exception.ODL_IO_Exception;
import com.ebupt.vnbo.entity.result.Result;
import com.ebupt.vnbo.entity.sfc.ServiceFunctionChain;
import com.ebupt.vnbo.entity.sfc.SfcSave;
import com.ebupt.vnbo.mapper.SfcMapper;
import com.ebupt.vnbo.service.sfc.SFCService;
@Service
public class SFCServiceImpl implements SFCService{
	@Autowired
	private SfcMapper mapper;
	@Override
	public Result<ServiceFunctionChain> addSFC(String vtoponame, String name, ServiceFunctionChain sfc)
			throws ODL_IO_Exception {
		// TODO Auto-generated method stub
		Result<ServiceFunctionChain> result=new Result<>();
		sfc.send(null);
		SfcSave save=new SfcSave(sfc);
		mapper.insertSfcSave(save);
		result.setDescription("success to add sfc "+sfc.getName());
		result.setResult(sfc);
		result.setStatus(RespCode.success);
		return result;
	}

	@Override
	public Result<ServiceFunctionChain> delSFC(String vtoponame, String name) throws ODL_IO_Exception {
		// TODO Auto-generated method stub
		Result<ServiceFunctionChain> result=new Result<>();
		SfcSave sfcSave=mapper.querrySfcSaveWithName(name);
		if(sfcSave==null)
			throw new ODL_IO_Exception("no such Sfc");
		ServiceFunctionChain sfc=sfcSave.toSFC();
		sfc.remove(null);
		mapper.deleteSfcSave(name);
		result.setResult(sfc);
		result.setDescription("success to remove sfc");
		result.setStatus(RespCode.success);
		return result;
	}

	@Override
	public Result<Set<ServiceFunctionChain>> querrySFCs(String vtoponame) throws ODL_IO_Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Result<ServiceFunctionChain> querrySFC(String vtoponame, String name) throws ODL_IO_Exception {
		// TODO Auto-generated method stub
		Result<ServiceFunctionChain> result=new Result<>();
		SfcSave sfcSave=mapper.querrySfcSaveWithName(name);
		if(sfcSave!=null){
			result.setResult(sfcSave.toSFC());
			result.setDescription("success to read sfc");
			result.setStatus(RespCode.success);
			return result;
		}
		else {
			throw new ODL_IO_Exception("no such sfc");
		}
	}

}
