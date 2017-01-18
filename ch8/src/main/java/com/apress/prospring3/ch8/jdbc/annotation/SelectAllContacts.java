package com.apress.prospring3.ch8.jdbc.annotation;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.jdbc.object.MappingSqlQuery;

import com.apress.prospring3.ch8.dao.Contact;

public class SelectAllContacts extends MappingSqlQuery<Contact> {

	private static final String queryString = "select id, first_name, last_name, birth_date from contact";
	
	public SelectAllContacts(DataSource dataSource) {

		super(dataSource, queryString);
	}

	@Override
	protected Contact mapRow(ResultSet resultSet, int rowNum) throws SQLException {

		Contact contact = new Contact();
		contact.setId(resultSet.getLong("id"));
		contact.setFirstName(resultSet.getString("first_name"));
		contact.setLastName(resultSet.getString("last_name"));
		contact.setBirthDate(resultSet.getDate("birth_date"));
		return contact;
	}

}
