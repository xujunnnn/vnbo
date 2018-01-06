package com.ebupt.vnbo.service;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.ebupt.vnbo.entity.enums.RespCode;
import com.ebupt.vnbo.entity.exception.ODL_IO_Exception;
import com.ebupt.vnbo.entity.result.Result;
import com.ebupt.vnbo.entity.vtopo.VPort;
import com.ebupt.vnbo.service.Vtopo.VtopoService;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(webEnvironment=WebEnvironment.RANDOM_PORT)
public class VtopoServiceTest {
	@Autowired
	private VtopoService service;
	@Test
	public void testAddVport(){
		VPort vPort=new VPort();
		vPort.setVtopo("v3");
		vPort.setvGroup("g1");
		vPort.setVport("openflow:2:1");
		try {
			Assert.assertEquals(RespCode.success, service.addVPort("v3", "g1", "openflow:2:1", vPort));
		} catch (ODL_IO_Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	

}
