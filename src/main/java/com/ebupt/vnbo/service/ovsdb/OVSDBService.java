package com.ebupt.vnbo.service.ovsdb;

import com.ebupt.vnbo.entity.exception.ODL_IO_Exception;
import com.ebupt.vnbo.entity.ovsdb.api.OVSDBConnection;

public interface OVSDBService {
	public void connect(String ip,String port) throws ODL_IO_Exception;
	
	public void addNode(String host,String node) throws ODL_IO_Exception;
	
	public void addPort(String host,String node,String port) throws ODL_IO_Exception;
	


}
