package com.ebupt.vnbo.mapper;

import org.springframework.core.annotation.Order;
import com.ebupt.vnbo.entity.sfc.SfcSave;
@Order(2)
public interface SfcMapper {
    SfcSave querrySfcSaveWithName(String name);
    void deleteSfcSave(String name);
    void updateSfcSave(SfcSave sfcSave);
    void insertSfcSave(SfcSave sfcSave);
	

}
