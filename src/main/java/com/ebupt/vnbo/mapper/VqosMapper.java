package com.ebupt.vnbo.mapper;

import java.util.List;

import com.ebupt.vnbo.entity.qos.VqosSave;


public interface VqosMapper {
	  List<VqosSave> querryVqos();
	  VqosSave querryVqosWithName(String name);
	  void deleteVqos(String name);
	  void updateVqos(VqosSave vqosSave);
	  void insertVqos(VqosSave vqosSave);

}
