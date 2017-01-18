package com.apress.prospring3.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Version;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.Type;
import org.hibernate.validator.constraints.Range;
import org.joda.time.DateTime;

@Entity
@Table(name = "CONTACT")
public class Contact {

	private Long id;
	private int version;
	private String firstName;
	private String lastName;
	private DateTime birthDate;

	@Id
	@Column(name = "ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
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
	@NotNull
	@Range(min = 3, max = 10)
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
	@Type(type = "org.joda.time.contrib.hibernate.PersistentDateTime")
	public DateTime getBirthDate() {

		return birthDate;
	}

	public void setBirthDate(DateTime birthDate) {

		this.birthDate = birthDate;
	}

	@Override
	public String toString() {

		return "Contact - Id: " + id + ", First name: " + firstName + ", Last name: " + lastName + ", Birthday: "
				+ birthDate;
	}
}
