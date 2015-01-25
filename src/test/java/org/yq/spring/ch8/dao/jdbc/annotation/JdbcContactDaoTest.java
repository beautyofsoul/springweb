package org.yq.spring.ch8.dao.jdbc.annotation;

import static org.junit.Assert.*;

import java.sql.Date;
import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.yq.spring.ch8.dao.ContactDao;
import org.yq.spring.ch8.domain.Contact;
import org.yq.spring.util.ApplicationContextUtil;

public class JdbcContactDaoTest {

	@Test
	public void testFindAll() {
		ApplicationContext ctx = ApplicationContextUtil
				.getApplicationContext("spring/ch8/app-context-annotation.xml");
		ContactDao contactDao = ctx.getBean("contactDao", ContactDao.class);
		List<Contact> contacts = contactDao.findAll();
		for (Contact c : contacts) {
			System.out.println(c);
		}
		ApplicationContextUtil.close(ctx);
	}

	@Test
	public void testInsert() {
		ApplicationContext ctx = ApplicationContextUtil
				.getApplicationContext("spring/ch8/app-context-annotation.xml");
		ContactDao contactDao = ctx.getBean("contactDao", ContactDao.class);
		Contact c = new Contact();
		c.setFirstName("Jack");
		c.setLastName("write");
		c.setBirthDate(new Date(new java.util.Date().getTime()));
		contactDao.insert(c);
		ApplicationContextUtil.close(ctx);
	}

	@Test
	public void testFindFirstNameById() {
		fail("Not yet implemented");
	}

	@Test
	public void testFindLastNameById() {
		fail("Not yet implemented");
	}

}
