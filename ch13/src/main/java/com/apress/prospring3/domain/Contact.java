package com.apress.prospring3.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Version;

@Entity
@Table(name = "Contact")
@NamedQueries({ @NamedQuery(name = "Contact.findAll", query = "select c from Contact c"),
		@NamedQuery(name = "Contact.countAll", query = "select count(c) from Contact c"), })
public class Contact implements Serializable {

	/**
	 * Generated serial version UID
	 */
	private static final long serialVersionUID = 4783168194169478770L;

	private Long id;
	private int version;
	private String firstName;
	private String lastName;
	private Date birthDate;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	public Long getId() {

		return id;
	}

	public void setId(Long id) {

		this.id = id;
	}

	@Version
	@Column(name = "VERSION")
	public int getVersion() {

		return version;
	}

	public void setVersion(int version) {

		this.version = version;
	}

	@Column(name = "FIRST_NAME")
	public String getFirstName() {

		return firstName;
	}

	public void setFirstName(String firstName) {

		this.firstName = firstName;
	}

	@Column(name = "LAST_NAME")
	public String getLastName() {

		return lastName;
	}

	public void setLastName(String lastName) {

		this.lastName = lastName;
	}

	@Column(name = "BIRTH_DATE")
	@Temporal(TemporalType.DATE)
	public Date getBirthDate() {

		return birthDate;
	}

	public void setBirthDate(Date birthDate) {

		this.birthDate = birthDate;
	}

	@Override
	public String toString() {

		return "Contact - Id: " + id + ", First name: " + firstName + ", Last name: " + lastName + ", Birthday: "
				+ birthDate;
	}
}
