package com.ebupt.vnbo.ServiceImpl.ovsdb;

import com.ebupt.vnbo.entity.enums.OpenflowProtocol;
import com.ebupt.vnbo.entity.exception.ODL_IO_Exception;
import com.ebupt.vnbo.entity.ovsdb.api.OVSDBConnection;
import com.ebupt.vnbo.entity.ovsdb.api.OVSDBNode;
import com.ebupt.vnbo.entity.ovsdb.config.OVSDBNodeConfig;
import com.ebupt.vnbo.service.ovsdb.OVSDBService;
import com.ebupt.vnbo.util.BaseUtil;

public class OVSDBServiceImpl implements OVSDBService{

	@Override
	public void connect(String ip, String port) throws ODL_IO_Exception {
		// TODO Auto-generated method stub
		OVSDBConnection connection=new OVSDBConnection();
		connection.setRemoteip(ip);
		connection.setRemoteport(port);
		connection.send(null);
		
	}

	@Override
	public void addNode(String host, String node) throws ODL_IO_Exception {
		// TODO Auto-generated method stub
		OVSDBNode ovsdbNode=new OVSDBNode();
		ovsdbNode.setHost(host);
		ovsdbNode.setName(node);
		ovsdbNode.setProtocol(OpenflowProtocol.OpenFlow13);
		String info[]=BaseUtil.getODL_IP().split(":");
		String ip=info[0]+"6633";
		ovsdbNode.setIp(ip);
		ovsdbNode.send(null);
	}

	@Override
	public void addPort(String host, String node, String port) throws ODL_IO_Exception {
		// TODO Auto-generated method stub
		
		
	}

}
