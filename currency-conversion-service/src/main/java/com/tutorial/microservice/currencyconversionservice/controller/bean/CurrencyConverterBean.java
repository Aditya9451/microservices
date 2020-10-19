package com.tutorial.microservice.currencyconversionservice.controller.bean;

import java.math.BigDecimal;

public class CurrencyConverterBean {

	
	private Long id;
	private String to;
	private String from;
	private BigDecimal multiple;
	private BigDecimal quantity;
	private BigDecimal totalCalcAmount;
	private int port;
	
	public CurrencyConverterBean() {
	}


	public CurrencyConverterBean(Long id, String from, String to, BigDecimal multiple, BigDecimal quantity,
			BigDecimal totalCalcAmount, int port) {
		super();
		this.id = id;
		this.from = from;
		this.to = to;
		this.multiple = multiple;
		this.quantity = quantity;
		this.totalCalcAmount = totalCalcAmount;
		this.port= port;
	}


	public Long getId() {
		return id;
	}


	public String getFrom() {
		return from;
	}


	public String getTo() {
		return to;
	}


	public BigDecimal getMultiple() {
		return multiple;
	}


	public BigDecimal getQuantity() {
		return quantity;
	}


	public BigDecimal getTotalCalcAmount() {
		return totalCalcAmount;
	}


	public int getPort() {
		return port;
	}
	
	
	
	
}
