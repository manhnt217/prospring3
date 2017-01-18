package com.apress.prospring.ch9.hibernate;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Version;

@Entity
@Table(name = "CONTACT_TEL_DETAIL")
public class ContactTelDetail implements Serializable {

	private static final long serialVersionUID = -1127924589138852881L;
	private long id;
	private String telType;
	private String telNumber;
	private int version;

	private Contact contact;

	public ContactTelDetail() {
	}

	public ContactTelDetail(String type, String number) {

		this.telType = type;
		this.telNumber = number;
	}

	@ManyToOne
	@JoinColumn(name = "CONTACT_ID")
	public Contact getContact() {

		return contact;
	}

	public void setContact(Contact contact) {

		this.contact = contact;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	public long getId() {

		return id;
	}

	public void setId(long id) {

		this.id = id;
	}

	@Column(name = "TEL_TYPE")
	public String getTelType() {

		return telType;
	}

	public void setTelType(String telType) {

		this.telType = telType;
	}

	@Column(name = "TEL_NUMBER")
	public String getTelNumber() {

		return telNumber;
	}

	public void setTelNumber(String telNumber) {

		this.telNumber = telNumber;
	}

	@Version
	@Column(name = "VERSION")
	public int getVersion() {

		return version;
	}

	public void setVersion(int version) {

		this.version = version;
	}

	public String toString() {

		return "Contact Tel Detail - Id: " + id + ", Contact id: " + getContact().getId() + ", Type: " + telType
				+ ", Number: " + telNumber;
	}
}
