package com.ebupt.vnbo.ovsdb;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.ebupt.vnbo.entity.exception.ODL_IO_Exception;
import com.ebupt.vnbo.entity.ovsdb.operational.OVSDBConnectionOperational;
import com.ebupt.vnbo.entity.ovsdb.operational.OVSDBTopologyOperational;

import junit.framework.Assert;

@RunWith(SpringRunner.class)
@SpringBootTest
public class OVSDBConnectionTest {
	@Test
	public void testConnection(){
		OVSDBTopologyOperational topologyOperational=new OVSDBTopologyOperational();
		try {
			topologyOperational=topologyOperational.read(null);
		} catch (ODL_IO_Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Assert.assertEquals("10.108.124.62", topologyOperational.getNodes().get(3).getConnection_info().getRemote_ip());
	}

}
