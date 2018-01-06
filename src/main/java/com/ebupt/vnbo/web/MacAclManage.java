package com.ebupt.vnbo.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ebupt.vnbo.entity.exception.ODL_IO_Exception;
import com.ebupt.vnbo.entity.result.Result;
import com.ebupt.vnbo.entity.vtopo.MacAclList;
import com.ebupt.vnbo.service.macacl.MacAclService;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value="/MacAclManage")
public class MacAclManage {
	@Autowired
	private MacAclService macAclService;
	@ApiOperation(value="添加mac白名单")
	@RequestMapping(value="/MacAclManage/Mac",method=RequestMethod.PUT)
	public Result addMac(@RequestBody MacAclList aclList) throws ODL_IO_Exception{
		return macAclService.addMacList(aclList);
	}
	@ApiOperation(value="删除mac白名单")
	@RequestMapping(value="/MacAclManage/Mac",method=RequestMethod.DELETE)
	public Result delMac(@RequestBody MacAclList aclList) throws ODL_IO_Exception{
		return macAclService.removeMacList(aclList);
	}
	@ApiOperation(value="查询mac白名单")
	@RequestMapping(value="/MacAclManage/Mac",method=RequestMethod.GET)
	public Result querryMac() throws ODL_IO_Exception{
		return macAclService.querryMacList();
	}

}
