package com.ebupt.vnbo.ovsdb;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.ebupt.vnbo.entity.exception.ODL_IO_Exception;
import com.ebupt.vnbo.entity.ovsdb.config.OVSDBTerminationConfig;

@RunWith(SpringRunner.class)
@SpringBootTest
public class OVSDBTerminationTest {
	@Test
	public void test(){
		OVSDBTerminationConfig config=new OVSDBTerminationConfig();
		config.setHost("tp1");
		config.setName("port1");
		config.setNode("br1");
		config.setTp_id("port1");
		try {
			config.send(null);
		} catch (ODL_IO_Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
