package com.ebupt.vnbo.web;

import com.ebupt.vnbo.entity.exception.ODL_IO_Exception;
import com.ebupt.vnbo.entity.result.Result;
import com.ebupt.vnbo.entity.topology.Topology;
import com.ebupt.vnbo.service.topology.TopologyService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by xujun on 2017/10/17.
 */
@RestController
@RequestMapping(value = "/Topology")
public class TopologyManage {
    @Autowired
    private TopologyService topologyService;


    @RequestMapping(value = "Hosts",method = RequestMethod.GET)
    @ApiOperation(value = "获取主机信息列表",notes = "")
    public Result querryHost() throws ODL_IO_Exception {
        return topologyService.querryHost();
    }
    @RequestMapping(value="Switches",method =RequestMethod.GET)
    @ApiOperation(value = "获取交换机信息列表",notes = "")
    public Result querrySwitch() throws ODL_IO_Exception {
        return topologyService.querrySwitch();
    }
    @RequestMapping(value = "AbleHosts",method = RequestMethod.GET)
    @ApiOperation(value = "获取可用主机信息列表",notes = "")
    public Result querryAbleHost() throws ODL_IO_Exception{
        return topologyService.querryAbleHost();
    }
    @RequestMapping(value = "AblePorts/Node/{node}",method = RequestMethod.GET)
    @ApiOperation(value = "获取指定交换机的可用端口信息列表",notes = "")
    public Result querryAblePorts(@PathVariable String node) throws ODL_IO_Exception{
        return topologyService.querryAblePort(node);
    }
    
    
    @RequestMapping(value = "BusyPorts/Node/{node}",method = RequestMethod.GET)
    @ApiOperation(value = "获取指定交换机的不可用端口信息列表",notes = "")
    public Result querryBusyPorts(@PathVariable String node) throws ODL_IO_Exception{
        return topologyService.querryBusyPort(node);
    }
    
    @RequestMapping(value = "BusyPorts/VGroup/{vgroup}Node/{node}",method = RequestMethod.GET)
    @ApiOperation(value = "获取指定交换机的不可用端口信息列表",notes = "")
    public Result querryBusyPorts(@PathVariable String vgroup,@PathVariable String node) throws ODL_IO_Exception{
        return topologyService.querryBusyPorts(vgroup, node);
    }
    
    @RequestMapping(value = "AblePorts",method = RequestMethod.GET)
    @ApiOperation(value = "获取可用端口信息列表",notes = "")
    public Result querryAblePorts() throws ODL_IO_Exception{
        return topologyService.querryAblePort();
    }
    
    @RequestMapping(value = "/{name}",method = RequestMethod.GET)
    @ApiOperation(value = "获取物理拓扑",notes = "")
    public Result querryTopology(@PathVariable String name) throws ODL_IO_Exception{
        return topologyService.getVtopology(name);
    }

}
