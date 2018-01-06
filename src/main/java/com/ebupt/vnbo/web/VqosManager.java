package com.ebupt.vnbo.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ebupt.vnbo.entity.exception.ODL_IO_Exception;
import com.ebupt.vnbo.entity.qos.Vqos;
import com.ebupt.vnbo.entity.result.Result;
import com.ebupt.vnbo.entity.sfc.VNF;
import com.ebupt.vnbo.service.qos.VqosService;
import com.ebupt.vnbo.service.sfc.VNFService;

import io.swagger.annotations.ApiOperation;
@RestController
@RequestMapping(value="/Vqos")
public class VqosManager {
	@Autowired
	private VqosService vqosService;
	@ApiOperation(value="添加一个qos",notes="填入qos名称和JSON数据")
	@RequestMapping(value="/{VtopoName}/{name}",method=RequestMethod.PUT)
	public Result addVqos(@PathVariable String VtopoName,@PathVariable String name,@RequestBody Vqos vqos) throws ODL_IO_Exception{
		Result<Vqos> result=vqosService.addVqos(vqos);
		return result;
	}
	
	@RequestMapping(value="/{VtopoName}",method=RequestMethod.GET)
	@ApiOperation(value="查询所有qos",notes="填入虚拟网络名称")
	public Result querryVNFs(@PathVariable String VtopoName) throws ODL_IO_Exception{
		return vqosService.querryVqos();
	}
	
	@RequestMapping(value="/{VtopoName}/{name}",method=RequestMethod.GET)
	@ApiOperation(value="查询指定qos",notes="填入qos名称和虚拟网络名称")
	public Result querryVNF(@PathVariable String VtopoName,@PathVariable String name) throws ODL_IO_Exception{
		return vqosService.querryQos(name);
	}
	@RequestMapping(value="/{VtopoName}/{name}",method=RequestMethod.DELETE)
	@ApiOperation(value="删除指定qos",notes="填入qos名称和虚拟网络名称")
	public Result delVNF(@PathVariable String VtopoName,@PathVariable String name) throws ODL_IO_Exception{
		return vqosService.delVqos(name);
	}
	

}
