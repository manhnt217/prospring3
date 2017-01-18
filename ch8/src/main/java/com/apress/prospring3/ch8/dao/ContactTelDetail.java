package com.apress.prospring3.ch8.dao;

import java.io.Serializable;

public class ContactTelDetail implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 5967412141523318292L;
	private Long id;
	private Long contactId;
	private String telType;
	private String telNumber;

	// Getter and setter method omitted 
	public String toString() {

		return "Contact Tel Detail - Id: " + id + ", Contact id: " + contactId + ", Type: " + telType + ", Number: "
				+ telNumber;
	}
}
