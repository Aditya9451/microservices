package com.tutorial.microservices.currencyexchangeservice.controller;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.tutorial.microservices.currencyexchangeservice.entity.ExchangeValue;
import com.tutorial.microservices.currencyexchangeservice.repository.ExchangeValueRepository;

@RestController

public class CurrencyExchangeController {
	
	@Autowired
	private Environment environment;
	@Autowired
	private ExchangeValueRepository exchangeValueRepository;
	@GetMapping("/currency-exchange/{from}/to/{to}")
	public ExchangeValue retrieveexchangevalue(@PathVariable String from, @PathVariable String to) {
		
		ExchangeValue exchangevalue= exchangeValueRepository.findByFromAndTo( from, to);
		exchangevalue.setPort(Integer.parseInt(environment.getProperty("local.server.port")));
		return exchangevalue;
	}
	
	

}
