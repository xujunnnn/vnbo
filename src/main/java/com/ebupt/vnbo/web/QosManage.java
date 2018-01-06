package com.ebupt.vnbo.web;

import com.ebupt.vnbo.entity.exception.ODL_IO_Exception;
import com.ebupt.vnbo.entity.qos.QosEntry;
import com.ebupt.vnbo.entity.result.Result;
import com.ebupt.vnbo.service.qos.QosService;
import com.ebupt.vnbo.service.topology.TopologyService;
import com.sun.org.apache.regexp.internal.RE;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by xujun on 2017/10/19.
 */
@RequestMapping(value = "/Qos")
public class QosManage {
    @Autowired
    private TopologyService topologyService;
    @Autowired
    private QosService qosService;
    @RequestMapping(value = "/{id}",method = RequestMethod.PUT)
    @ApiOperation(value = "添加一条qos策略",notes = "")
    public Result addQos(@PathVariable String id, @RequestBody QosEntry qosEntry) throws ODL_IO_Exception {
        qosEntry.setTopologyService(topologyService);
        return qosService.addQos(qosEntry);
    }
    @RequestMapping(value = "/",method = RequestMethod.GET)
    @ApiOperation(value = "查询所有qos",notes = "返回一个qos列表")
    public Result querryAllQos() throws ODL_IO_Exception {
        return qosService.querryAll();
    }

}
