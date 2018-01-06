package com.ebupt.vnbo.service.qos;

import java.util.List;

import com.ebupt.vnbo.entity.exception.ODL_IO_Exception;
import com.ebupt.vnbo.entity.qos.Vqos;
import com.ebupt.vnbo.entity.result.Result;

public interface VqosService {

    /**
     * 添加一条qos策略
     * @param qosEntry
     * @return
     */
    public Result<Vqos> addVqos(Vqos vqos) throws ODL_IO_Exception;


    /**
     * 删除一条qos策略
     * @param
     * @return
     */
    public Result<Vqos> delVqos(String name) throws ODL_IO_Exception;

    /**
     * 查询所有qos策略
     * @return
     */
    public Result<List<Vqos>> querryVqos() throws ODL_IO_Exception;

    /**
     * 查询指定的qos策略
     * @param id
     * @return
     */
    public Result<Vqos> querryQos(String name) throws ODL_IO_Exception;


}
