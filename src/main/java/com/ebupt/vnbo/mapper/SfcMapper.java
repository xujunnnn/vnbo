package com.ebupt.vnbo.mapper;

import java.util.List;

import org.springframework.core.annotation.Order;
import com.ebupt.vnbo.entity.sfc.SfcSave;
@Order(2)
public interface SfcMapper {
    SfcSave querrySfcSaveWithName(String domain,String name);
    List<SfcSave> querrySfcSave(String domain);
    void deleteSfcSave(String domain,String name);
    void updateSfcSave(SfcSave sfcSave);
    void insertSfcSave(SfcSave sfcSave);
	

}
