package com.tutorial.microservice.limitservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tutorial.microservice.limitservice.bean.LimitConfiguration;
import com.tutorial.microservice.limitservice.configuration.Configuration;

@RestController
public class LimitConfigurationController {
	
//	@Value("${limit-service.maximum}")
//	private int max;
//	
//	@Value("${limit-service.minimum}")
//	private int min;
	@Autowired
	private Configuration configuration;
	@GetMapping("/limits")
	public LimitConfiguration retrieve() {
		
		return new LimitConfiguration(configuration.getMaximum(),configuration.getMinimum());
	}

}
