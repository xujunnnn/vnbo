
package com.ebupt.vnbo.ServiceImpl.qos;
import java.util.List;

import org.springframework.stereotype.Service;

import com.ebupt.vnbo.entity.enums.RespCode;
import com.ebupt.vnbo.entity.exception.ODL_IO_Exception;
import com.ebupt.vnbo.entity.qos.QosEntry;
import com.ebupt.vnbo.entity.result.Result;
import com.ebupt.vnbo.mapper.QosMapper;
import com.ebupt.vnbo.service.qos.QosService;

/**
 * Created by xujun on 2017/10/19.
 */
@Service
public class QosServiceImpl implements QosService{
    //@Autowired
    private QosMapper qosMapper;
    /**
     * 添加一条qos策略
     *
     * @param qosEntry
     * @return
     */
    @Override
    public Result<QosEntry> addQos(QosEntry qosEntry) throws ODL_IO_Exception {
        Result result=new Result();
       // qosMapper.querryQosEntryWithId();
        qosEntry.send(null);
        qosEntry.setHash(qosEntry.hashCode());
        qosMapper.insertQosEntry(qosEntry);
        result.setStatus(RespCode.success);
        result.setDescription("qos " +qosEntry.getQos_id()  + "add success");
        return result;
    }

    /**
     * 删除一条qos策略
     *
     * @param id@return
     */
    @Override
    public Result<QosEntry> delQos(String id) throws ODL_IO_Exception{
        Result result=new Result();
        QosEntry qosEntry=new QosEntry();
        qosEntry.setQos_id(id);
        qosEntry.remove(null);
        qosMapper.deleteQosPolicy(id);
        result.setStatus(RespCode.success);
        result.setDescription("qos " +id+"delete success");
        return result;
    }

    /**
     * 查询所有qos策略
     *
     * @return
     */
    @Override
    public Result<List<QosEntry>> querryAll() {
        Result<List<QosEntry>> result=new Result<>();
        List<QosEntry> entries=qosMapper.querryQosEntry();
        result.setStatus(RespCode.success);
        result.setResult(entries);
        result.setDescription("querry success");
        return result;
    }

    /**
     * 查询指定的qos策略
     *
     * @param id
     * @return
     */
    @Override
    
    public Result<QosEntry> querryQos(String id) {
        Result<QosEntry> result=new Result<>();
        QosEntry entry=qosMapper.querryQosEntryWithId(id);
        result.setStatus(RespCode.success);
        result.setDescription("querry success");
        result.setResult(entry);
        return result;
    }
}
