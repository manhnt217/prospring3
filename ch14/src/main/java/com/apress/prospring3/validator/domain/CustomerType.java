package com.apress.prospring3.validator.domain;


public enum CustomerType {
	
	INDIVIDUAL("I"),CORPORATE ("C");
	
	private String code;
	
	private CustomerType(String code) {
		this.code = code;
	}

	@Override
	public String toString() {
		return this.code;
	}
}
