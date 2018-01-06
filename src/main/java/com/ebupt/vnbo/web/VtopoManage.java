package com.ebupt.vnbo.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ebupt.vnbo.entity.exception.ODL_IO_Exception;
import com.ebupt.vnbo.entity.result.Result;
import com.ebupt.vnbo.entity.vtopo.VGroup;
import com.ebupt.vnbo.entity.vtopo.VHost;
import com.ebupt.vnbo.entity.vtopo.VPort;
import com.ebupt.vnbo.entity.vtopo.VTopo;
import com.ebupt.vnbo.service.Vtopo.VtopoService;

import io.swagger.annotations.ApiOperation;
@RestController
@RequestMapping(value="/Vtopo")
public class VtopoManage {
	@Autowired
	private VtopoService vtopoService;
	
	
	@RequestMapping(value="/",method=RequestMethod.GET)
	@ApiOperation(value="查询所有虚拟网络拓扑",notes="")
	public Result querryVtopos() throws ODL_IO_Exception{	
		return vtopoService.querryVtopos();		
	}
	
	
	@RequestMapping(value="/{name}",method=RequestMethod.PUT)
	@ApiOperation(value="添加一条虚拟网络拓扑",notes="输入拓扑名称和拓扑JSON数据")
	public Result addVtopo(@PathVariable String name, @RequestBody VTopo vTopo) throws ODL_IO_Exception{	
		return vtopoService.addVtopo(name,vTopo);		
	}
	
	@RequestMapping(value="/{name}",method=RequestMethod.DELETE)
	@ApiOperation(value="删除指定网络拓扑",notes="输入虚拟拓扑名称")
	public Result delVtopo(@PathVariable String name) throws ODL_IO_Exception{
		return vtopoService.deleteVtopo(name);
	}
	@RequestMapping(value="/{name}",method=RequestMethod.GET)
	@ApiOperation(value="查询指定的网络拓扑数据",notes="输入虚拟拓扑名称")
	public Result querryVtopo(@PathVariable String name) throws ODL_IO_Exception{
		return vtopoService.querryVtopo(name);
	}

	@RequestMapping(value="/{Vtopo}/VGroup/{name}",method=RequestMethod.DELETE)
	@ApiOperation(value="删除指定虚拟桥",notes="")
	public Result delVGroup(@PathVariable String Vtopo,@PathVariable String name) throws ODL_IO_Exception{
		return vtopoService.deleteVGroup(Vtopo, name);
	}
	
	@RequestMapping(value="/{Vtopo}/VGroup/{name}",method=RequestMethod.GET)
	@ApiOperation(value="查询指定虚拟网桥",notes="")
	public Result querryVGroup(@PathVariable String Vtopo,@PathVariable String name) throws ODL_IO_Exception{
		return vtopoService.querryVGroup(Vtopo, name);
	}
	@RequestMapping(value="/{Vtopo}/VGroup/{name}",method=RequestMethod.PUT)
	@ApiOperation(value="添加指定虚拟网桥",notes="输入名字和json")
	public Result addVGroup(@PathVariable String Vtopo,@PathVariable String name,@RequestBody VGroup vGroup) throws ODL_IO_Exception{
		return vtopoService.addVGroup(Vtopo,name,vGroup);
	}
	
	@RequestMapping(value="/{Vtopo}/VGroup/{VGroup}/VPort/{name}",method=RequestMethod.PUT)
	@ApiOperation(value="添加指定虚拟端口",notes="输入名字和json")
	public Result addVPort(@PathVariable String Vtopo,@PathVariable String VGroup,@PathVariable String name,@RequestBody VPort vPort) throws ODL_IO_Exception{
		return vtopoService.addVPort(Vtopo, VGroup, name, vPort);
	}
	@RequestMapping(value="/{Vtopo}/VGroup/{VGroup}/VPort/{name}",method=RequestMethod.DELETE)
	@ApiOperation(value="删除指定虚拟端口",notes="输入名字和json")
	public Result delVPort(@PathVariable String Vtopo,@PathVariable String VGroup,@PathVariable String name) throws ODL_IO_Exception{
		return vtopoService.deleteVPort(Vtopo, VGroup, name);
	}
	@RequestMapping(value="/{Vtopo}/VGroup/{VGroup}/VPort/{name}",method=RequestMethod.GET)
	@ApiOperation(value="查询指定虚拟端口",notes="输入名字和json")
	public Result querryVPort(@PathVariable String Vtopo,@PathVariable String VGroup,@PathVariable String name) throws ODL_IO_Exception{
		return vtopoService.querryVPort(Vtopo, VGroup, name);
	}
	@RequestMapping(value="/{Vtopo}/VGroup/{VGroup}/VPort/",method=RequestMethod.GET)
	@ApiOperation(value="查询虚拟端口",notes="输入名字和json")
	public Result delVPort(@PathVariable String Vtopo,@PathVariable String VGroup) throws ODL_IO_Exception{
		return vtopoService.querryVPorts(Vtopo, VGroup);
	}
	@RequestMapping(value="/{Vtopo}/VGroup/{VGroup}/VHost/{name}",method=RequestMethod.PUT)
	@ApiOperation(value="添加指定虚拟主机",notes="输入名字和json")
	public Result addVHost(@PathVariable String Vtopo,@PathVariable String VGroup,@PathVariable String name,@RequestBody VHost vHost) throws ODL_IO_Exception{
		return vtopoService.addVHost(Vtopo, VGroup, name, vHost);
	}
	@RequestMapping(value="/{Vtopo}/VGroup/{VGroup}/VHost/{name}",method=RequestMethod.DELETE)
	@ApiOperation(value="删除指定虚拟主机",notes="输入名字和json")
	public Result delVHost(@PathVariable String Vtopo,@PathVariable String VGroup,@PathVariable String name) throws ODL_IO_Exception{
		return vtopoService.deleteVHost(Vtopo, VGroup, name);
	}
	

}
