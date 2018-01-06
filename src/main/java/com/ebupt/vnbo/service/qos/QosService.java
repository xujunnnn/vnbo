package com.ebupt.vnbo.service.qos;

import com.ebupt.vnbo.entity.exception.ConfigException;
import com.ebupt.vnbo.entity.exception.ODL_IO_Exception;
import com.ebupt.vnbo.entity.exception.OperationalException;
import com.ebupt.vnbo.entity.qos.QosEntry;
import com.ebupt.vnbo.entity.result.Result;
import com.ebupt.vnbo.mapper.QosMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by xujun on 2017/10/16.
 */
public interface QosService{

    /**
     * 添加一条qos策略
     * @param qosEntry
     * @return
     */
    public Result<QosEntry> addQos(QosEntry qosEntry) throws ODL_IO_Exception;


    /**
     * 删除一条qos策略
     * @param
     * @return
     */
    public Result<QosEntry> delQos(String id) throws ODL_IO_Exception;

    /**
     * 查询所有qos策略
     * @return
     */
    public Result<List<QosEntry>> querryAll() throws ODL_IO_Exception;

    /**
     * 查询指定的qos策略
     * @param id
     * @return
     */
    public Result<QosEntry> querryQos(String id) throws ODL_IO_Exception;


}
