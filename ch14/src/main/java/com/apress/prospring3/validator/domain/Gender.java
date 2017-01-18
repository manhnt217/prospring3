package com.apress.prospring3.validator.domain;

public enum Gender {
	
	MALE("M"), FEMALE("F");

	private String code;

	private Gender(String code) {

		this.code = code;
	}

	public String toString() {

		return this.code;
	}
}
