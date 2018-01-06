package com.ebupt.vnbo.ovsdb;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.ebupt.vnbo.entity.enums.OpenflowProtocol;
import com.ebupt.vnbo.entity.enums.Protocol_Type;
import com.ebupt.vnbo.entity.exception.ODL_IO_Exception;
import com.ebupt.vnbo.entity.ovsdb.api.OVSDBNode;
import com.ebupt.vnbo.entity.ovsdb.config.OVSDBNodeConfig;

@RunWith(SpringRunner.class)
@SpringBootTest
public class OVSDBNodeTest {
	@Test
	public void testNode(){
		OVSDBNode node=new OVSDBNode();
		node.setHost("tp1");
		node.setName("br1");
		node.setProtocol(OpenflowProtocol.OpenFlow13);
		node.setIp("10.108.124.62");
		try {
			node.send(null);
		} catch (ODL_IO_Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
