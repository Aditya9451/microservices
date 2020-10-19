package com.tutorial.microservice.currencyconversionservice.controller;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.tutorial.microservice.currencyconversionservice.controller.bean.CurrencyConverterBean;
import com.tutorial.microservice.currencyconversionservice.proxy.CurrencyExchangeServiceProxy;

@RestController
public class CurrencyConversionController {
	
	@Autowired
	private CurrencyExchangeServiceProxy currencyExchangeServiceProxy;

	@GetMapping("/currency-converter/from/{from}/to/{to}/quantity/{quantity}")
	public CurrencyConverterBean convertcurrency(@PathVariable String from, @PathVariable String to, @PathVariable BigDecimal quantity) {
		
		Map<String, String>urlvariable= new HashMap<>();
		urlvariable.put("from", from);
		urlvariable.put("to",to);
		ResponseEntity<CurrencyConverterBean> responseEntity=new RestTemplate().getForEntity("http://localhost:8000/currency-exchange/{from}/to/{to}",CurrencyConverterBean.class,urlvariable );
		CurrencyConverterBean response= responseEntity.getBody();
		return new CurrencyConverterBean(response.getId(),to,from,response.getMultiple(), quantity,
				quantity.multiply(response.getMultiple()), response.getPort());
	}
	
	@GetMapping("/currency-converter-feign/from/{from}/to/{to}/quantity/{quantity}")
	public CurrencyConverterBean convertcurrencyFeign(@PathVariable String from, @PathVariable String to, @PathVariable BigDecimal quantity) {
		
		CurrencyConverterBean response= currencyExchangeServiceProxy.retrieveexchangevalue(from, to);
		return new CurrencyConverterBean(response.getId(),to,from,response.getMultiple(), quantity,
				quantity.multiply(response.getMultiple()), response.getPort());
	}
}
