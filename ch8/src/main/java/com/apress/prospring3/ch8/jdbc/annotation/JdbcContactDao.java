package com.apress.prospring3.ch8.jdbc.annotation;

import java.util.List;

import javax.annotation.Resource;
import javax.sql.DataSource;

import org.springframework.stereotype.Repository;

import com.apress.prospring3.ch8.dao.Contact;
import com.apress.prospring3.ch8.dao.ContactDao;

@Repository("contactDao")
public class JdbcContactDao implements ContactDao {

	private DataSource dataSource;
	private SelectAllContactsMappingSqlQuery selectAllContacts;

	public DataSource getDataSource() {

		return dataSource;
	}

	@Override
	@Resource(name="dataSource")
	public void setDataSource(DataSource dataSource) {

		this.dataSource = dataSource;
		selectAllContacts = new SelectAllContactsMappingSqlQuery(dataSource);
	}

	@Override
	public void delete(Long contactId) {

		// TODO Auto-generated method stub

	}

	@Override
	public void update(Contact contact) {

		// TODO Auto-generated method stub

	}

	@Override
	public void insert(Contact contact) {

		// TODO Auto-generated method stub

	}

	@Override
	public List<Contact> findAll() {

		return selectAllContacts.execute();
	}

	@Override
	public List<Contact> findByFirstName(String firstName) {

		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String findFirstNameById(Long id) {

		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String findLastNameById(Long id) {

		// TODO Auto-generated method stub
		return null;
	}

}
