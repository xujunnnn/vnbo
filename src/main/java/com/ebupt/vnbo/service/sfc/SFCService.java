package com.ebupt.vnbo.service.sfc;

import java.util.List;
import java.util.Set;

import com.ebupt.vnbo.entity.exception.ODL_IO_Exception;
import com.ebupt.vnbo.entity.result.Result;
import com.ebupt.vnbo.entity.sfc.ServiceFunctionChain;


public interface SFCService {
	public Result<ServiceFunctionChain> addSFC(String vtoponame,String name,ServiceFunctionChain sfc) throws ODL_IO_Exception;
	
	public Result<ServiceFunctionChain> delSFC(String vtoponame,String name) throws ODL_IO_Exception;
	
	public Result<List<ServiceFunctionChain>> querrySFCs(String vtoponame) throws ODL_IO_Exception;
	
	public Result<ServiceFunctionChain> querrySFC(String vtoponame,String name) throws ODL_IO_Exception;
	

}
