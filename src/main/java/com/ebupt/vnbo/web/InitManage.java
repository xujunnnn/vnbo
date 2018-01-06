package com.ebupt.vnbo.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ebupt.vnbo.entity.result.Result;
import com.ebupt.vnbo.service.initialize.InitService;

import io.swagger.annotations.ApiOperation;
@RestController
@RequestMapping(value="/InitManage")
public class InitManage {
	
	@Autowired
	private InitService initService;
	
	@RequestMapping(value="/base",method=RequestMethod.GET)
	@ApiOperation(value="初始化基础流表")
	public Result initBase(){
		return initService.initBaseFlow(); 
	}
	
	@RequestMapping(value="/monitor",method=RequestMethod.GET)
	@ApiOperation(value="初始化监控流表")
	public Result initMonitor(){
		return initService.initMonitor(); 
	}

}
