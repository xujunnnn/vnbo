package com.ebupt.vnbo.mapper;

import com.ebupt.vnbo.entity.qos.QosEntry;

import java.util.List;

import org.springframework.stereotype.Component;

/**
 * Created by xujun on 2017/10/19.
 */
@Component
public interface QosMapper {
    QosEntry querryQosEntryWithId(String qosid);
    List<QosEntry> querryQosEntry();
    void deleteQosPolicy(String id);
    void updateQosPolicy(QosEntry qosEntry);
    void insertQosEntry(QosEntry qosEntry);
}
