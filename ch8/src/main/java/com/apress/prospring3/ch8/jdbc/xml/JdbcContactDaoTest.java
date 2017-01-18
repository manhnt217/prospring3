package com.apress.prospring3.ch8.jdbc.xml;

import org.springframework.context.support.GenericXmlApplicationContext;

import com.apress.prospring3.ch8.dao.ContactDao;

public class JdbcContactDaoTest {
	public static void main(String[] args) {

		GenericXmlApplicationContext context = new GenericXmlApplicationContext();
		context.load("classpath:jdbc-xml-beans.xml");
		context.refresh();

		ContactDao contactDao = context.getBean("contactDao", ContactDao.class);
		System.out.println(contactDao.findLastNameById(2L));
		context.close();
	}
}
