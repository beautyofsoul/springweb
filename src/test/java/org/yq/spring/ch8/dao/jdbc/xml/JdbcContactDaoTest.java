package org.yq.spring.ch8.dao.jdbc.xml;

import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.yq.spring.ch8.dao.ContactDao;
import org.yq.spring.ch8.domain.Contact;
import org.yq.spring.util.ApplicationContextUtil;

public class JdbcContactDaoTest {

	@Test
	public void testFindFirstNameById() {
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
		ctx.load("classpath:META-INF/spring/ch8/app-context-xml.xml");
		ctx.refresh();
		ContactDao contactDao = ctx.getBean("contactDao",ContactDao.class);
	    System.out.println("First 1:"+contactDao.findFirstNameById(1L));
		ctx.close();
	}
	@Test
	public void testFindLastNameById() {
		ApplicationContext ctx = ApplicationContextUtil.getApplicationContext("spring/ch8/app-context-xml.xml");
		ContactDao contactDao = ctx.getBean("contactDao",ContactDao.class);
	    System.out.println("Last 1:"+contactDao.findLastNameById(1L));
	    ApplicationContextUtil.close(ctx);
	}
	
	@Test
	public void testFindAll() {
		ApplicationContext ctx = ApplicationContextUtil.getApplicationContext("spring/ch8/app-context-xml.xml");
		ContactDao contactDao = ctx.getBean("contactDao",ContactDao.class);
		List<Contact> contacts = contactDao.findAll();
		for(Contact c:contacts)
		{
			System.out.println(c);
		}
	    ApplicationContextUtil.close(ctx);
	}

}
