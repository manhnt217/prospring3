package com.apress.prospring3.domain;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.persistence.Version;

import org.hibernate.annotations.Type;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

@Entity
@Table(name = "CONTACT")
public class Contact implements Serializable {

	/**
	 * IDE-generated serial version UID
	 */
	private static final long serialVersionUID = -2732543103971915952L;

	private Long id;
	private String firstName;
	private String lastName;
	private DateTime birthDate;
	private byte[] photo;
	private String description;
	private int version;

	@Id
	@Column(name = "ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long getId() {

		return id;
	}

	public void setId(Long id) {

		this.id = id;
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
	@Type(type = "org.joda.time.contrib.hibernate.PersistentDateTime")
	@org.springframework.format.annotation.DateTimeFormat(iso=ISO.DATE)
	public DateTime getBirthDate() {

		return birthDate;
	}

	public void setBirthDate(DateTime birthDate) {

		this.birthDate = birthDate;
	}

	@Basic(fetch = FetchType.LAZY)
	@Lob
	@Column(name = "PHOTO")
	public byte[] getPhoto() {

		return photo;
	}

	public void setPhoto(byte[] photo) {

		this.photo = photo;
	}

	@Column(name = "DESCRIPTION")
	public String getDescription() {

		return description;
	}

	public void setDescription(String description) {

		this.description = description;
	}

	@Version
	@Column(name = "VERSION")
	public int getVersion() {

		return version;
	}

	public void setVersion(int version) {

		this.version = version;
	}

	@Transient
	public String getBirthDateString() {

		if (birthDate != null) {
			return DateTimeFormat.forPattern("yyyy-MM-dd").print(birthDate);
		}
		return "";
	}

}
