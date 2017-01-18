package com.apress.prospring3.ch8.dao;

import java.util.List;

import javax.sql.DataSource;


public interface ContactDao {
	public void setDataSource(DataSource dataSource);

	public void delete(Long contactId);

	public void update(Contact contact);

	public void insert(Contact contact);

	public List<Contact> findAll();

	public List<Contact> findByFirstName(String firstName);

	public String findFirstNameById(Long id);

	public String findLastNameById(Long id);
}
