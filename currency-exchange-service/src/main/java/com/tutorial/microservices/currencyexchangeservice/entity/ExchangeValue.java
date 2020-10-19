package com.tutorial.microservices.currencyexchangeservice.entity;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.GeneratorType;

@Entity
public class ExchangeValue {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name="currency_exchange_to")
	private String to;
	@Column(name="currency_exchange_from")
	private String from;
	
	private int multiple;
	private int port;
	
	
	
	public ExchangeValue() {
		// TODO Auto-generated constructor stub
	}
	public ExchangeValue(String to, String from, Long id, int multiple) {
		super();
		this.to = to;
		this.from = from;
		this.id = id;
		this.multiple = multiple;
	}
	public String getTo() {
		return to;
	}
	public String getFrom() {
		return from;
	}
	public Long getId() {
		return id;
	}
	public int getMultiple() {
		return multiple;
	}
	public int getPort() {
		return port;
	}
	public void setPort(int port) {
		this.port = port;
	}
	
	
	
	
	

}
