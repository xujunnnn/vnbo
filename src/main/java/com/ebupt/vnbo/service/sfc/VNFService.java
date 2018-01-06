package com.ebupt.vnbo.service.sfc;

import java.util.List;
import java.util.Set;

import com.ebupt.vnbo.entity.exception.ODL_IO_Exception;
import com.ebupt.vnbo.entity.result.Result;
import com.ebupt.vnbo.entity.sfc.VNF;
import com.ebupt.vnbo.entity.sfc.VNFRead;

public interface VNFService {
	public Result<VNF> addVNF(String vtoponame,String name,VNF vnf) throws ODL_IO_Exception;
	
	public Result<VNF> delVNF(String vtoponame,String name) throws ODL_IO_Exception;
	
	public Result<Set<VNFRead>> querryVNF(String vtoponame) throws ODL_IO_Exception;
	
	public Result<VNFRead> querryVNF(String vtoponame,String name) throws ODL_IO_Exception;
}
