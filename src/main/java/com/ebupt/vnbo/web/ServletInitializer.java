package com.ebupt.vnbo.web;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

import com.ebupt.vnbo.VnboApplication;

public class ServletInitializer extends SpringBootServletInitializer{
	  @Override
	    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
	        return application.sources(VnboApplication.class);
	    }
}
