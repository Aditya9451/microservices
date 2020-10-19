package com.tutorial.microservice.currencyconversionservice.proxy;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.tutorial.microservice.currencyconversionservice.controller.bean.CurrencyConverterBean;



@FeignClient(name="netflix-zuul-api-gateway-server")
@RibbonClient(name="currency-exchange-service")
public interface CurrencyExchangeServiceProxy {
	
	
	@GetMapping("/currency-exchange-service/currency-exchange/{from}/to/{to}")
	public CurrencyConverterBean retrieveexchangevalue(@PathVariable("from") String from, @PathVariable("to") String to);

}
