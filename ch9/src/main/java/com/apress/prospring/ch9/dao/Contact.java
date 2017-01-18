package com.apress.prospring.ch9.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Version;

//@formatter:off
@Entity
@Table(name = "CONTACT")
@NamedQueries({
	@NamedQuery(name = "Contact.findById", query = "select distinct c from Contact c " +
			"left join fetch c.contactTelDetails t left join fetch c.hobbies h where c.id = :id"), 
	@NamedQuery(name = "Contact.findAllWithDetail", query = "select distinct c from Contact c " +
			"left join fetch c.contactTelDetails t left join fetch c.hobbies h") 
})
//@formatter:on
public class Contact implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 9104061159397589122L;
	private long id;
	private int version;
	private String firstName;
	private String lastName;
	private Date birthDate;

	private Set<ContactTelDetail> contactTelDetails = new HashSet<ContactTelDetail>();

	private Set<Hobby> hobbies = new HashSet<Hobby>();

	//@formatter:off
	@ManyToMany
	@JoinTable(name = "CONTACT_HOBBY_DETAIL", 
			joinColumns = @JoinColumn(name = "CONTACT_ID"), 
			inverseJoinColumns = @JoinColumn(name = "HOBBY_ID"))
	public Set<Hobby> getHobbies() {

		return hobbies;
	}
	//@formatter:on

	public void setHobbies(Set<Hobby> hobbies) {

		this.hobbies = hobbies;
	}

	@OneToMany(mappedBy = "contact", cascade = CascadeType.ALL)
	public Set<ContactTelDetail> getContactTelDetails() {

		return contactTelDetails;
	}

	public void setContactTelDetails(Set<ContactTelDetail> contactTelDetails) {

		this.contactTelDetails = contactTelDetails;
	}

	public void addContactTelDetail(ContactTelDetail contactTelDetail) {

		contactTelDetail.setContact(this);
		getContactTelDetails().add(contactTelDetail);
	}

	public void removeContactTelDetail(ContactTelDetail contactTelDetail) {

		getContactTelDetails().remove(contactTelDetail);
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

	@Version
	@Column(name = "VERSION")
	public int getVersion() {

		return version;
	}

	public void setVersion(int version) {

		this.version = version;
	}

	//@formatter:off
	@Column(name = "FIRST_NAME")
	public String getFirstName() {

		return firstName;
	}
	//@formatter:on

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

	@Temporal(TemporalType.DATE)
	@Column(name = "BIRTH_DATE")
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
