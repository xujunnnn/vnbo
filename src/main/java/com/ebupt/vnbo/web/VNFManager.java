package com.ebupt.vnbo.web;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ebupt.vnbo.entity.exception.ODL_IO_Exception;
import com.ebupt.vnbo.entity.result.Result;
import com.ebupt.vnbo.entity.sfc.VNF;
import com.ebupt.vnbo.entity.sfc.VNFRead;
import com.ebupt.vnbo.service.sfc.VNFService;

import io.swagger.annotations.ApiOperation;
@RestController
@RequestMapping(value="/VNF")
public class VNFManager {
	@Autowired
	private VNFService vnfService;
	@ApiOperation(value="添加一个VNF",notes="填入vnf名称和JSON数据")
	@RequestMapping(value="/{VtopoName}/{name}",method=RequestMethod.PUT)
	public Result addVNF(@PathVariable String VtopoName,@PathVariable String name,@RequestBody VNF vnf) throws ODL_IO_Exception{
		Result<VNF> result=vnfService.addVNF(VtopoName,name,vnf);
		return result;
	}
	
	@RequestMapping(value="/{VtopoName}",method=RequestMethod.GET)
	@ApiOperation(value="查询所有VNF",notes="填入虚拟网络名称")
	public Result querryVNFs(@PathVariable String VtopoName) throws ODL_IO_Exception{
		return vnfService.querryVNF(VtopoName);
	}
	
	@RequestMapping(value="/{VtopoName}/{name}",method=RequestMethod.GET)
	@ApiOperation(value="查询指定VNF",notes="填入vnf名称和虚拟网络名称")
	public Result querryVNF(@PathVariable String VtopoName,@PathVariable String name) throws ODL_IO_Exception{
		return vnfService.querryVNF(VtopoName, name);
	}
	@RequestMapping(value="/{VtopoName}/{name}",method=RequestMethod.DELETE)
	@ApiOperation(value="删除指定VNF",notes="填入vnf名称和虚拟网络名称")
	public Result delVNF(@PathVariable String VtopoName,@PathVariable String name) throws ODL_IO_Exception{
		return vnfService.delVNF(VtopoName,name);
	}
	
	

}
