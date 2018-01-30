package com.ebupt.vnbo.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ebupt.vnbo.entity.exception.ODL_IO_Exception;
import com.ebupt.vnbo.entity.result.Result;
import com.ebupt.vnbo.entity.sfc.ServiceFunctionChain;
import com.ebupt.vnbo.service.sfc.SFCService;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value="/SFC")
public class SFCManage {
	@Autowired
	private SFCService sfcService;
	@ApiOperation(value="查询所有SFC",notes="填入租户名称")
	@RequestMapping(value="/Vtopo/{VtopoName}",method=RequestMethod.GET)
	public Result querrySFC(@PathVariable String VtopoName) throws ODL_IO_Exception{
		return sfcService.querrySFCs(VtopoName);
	}
	
	@ApiOperation(value="添加一个SFC",notes="填入SFC名称和JSON数据")
	@RequestMapping(value="/Vtopo/{VtopoName}/Sfc/{name}",method=RequestMethod.PUT)
	public Result addSFC(@PathVariable String VtopoName,@PathVariable String name,@RequestBody ServiceFunctionChain sfc) throws ODL_IO_Exception{
		return sfcService.addSFC(VtopoName, name, sfc);
	}
	@ApiOperation(value="查询一个SFC",notes="填入SFC名称和JSON数据")
	@RequestMapping(value="/Vtopo/{VtopoName}/Sfc/{name}",method=RequestMethod.GET)
	public Result querrySFC(@PathVariable String VtopoName,@PathVariable String name) throws ODL_IO_Exception{
		return sfcService.querrySFC(VtopoName, name);
	}
	
	@ApiOperation(value="删除一个SFC",notes="填入SFC名称和JSON数据")
	@RequestMapping(value="/Vtopo/{VtopoName}/Sfc/{name}",method=RequestMethod.DELETE)
	public Result deleteSFC(@PathVariable String VtopoName,@PathVariable String name) throws ODL_IO_Exception{
		return sfcService.delSFC(VtopoName, name);
	}
	

}
