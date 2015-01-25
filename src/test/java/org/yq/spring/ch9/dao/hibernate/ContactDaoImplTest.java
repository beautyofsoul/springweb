package org.yq.spring.ch9.dao.hibernate;

import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.yq.spring.ch9.dao.ContactDao;
import org.yq.spring.ch9.domain.Contact;
import org.yq.spring.ch9.domain.ContactTelDetail;
import org.yq.spring.util.ApplicationContextUtil;

public class ContactDaoImplTest {

	@Test
	public void testFindAll() {
		ApplicationContext ctx = ApplicationContextUtil
				.getApplicationContext("spring/ch9/app-context.xml");
		ContactDao contactDao = ctx.getBean("contactDao", ContactDao.class);
		List<Contact> contacts = contactDao.findAll();
		for (Contact c : contacts) {
			System.out.println(c);
			// if(c.getContactTelDetails()!=null)
			// {
			// for(ContactTelDetail t:c.getContactTelDetails())
			// {
			// System.out.println("    "+t);
			// }
			// }
		}
		ApplicationContextUtil.close(ctx);
	}

	@Test
	public void testFindAllWithDetail() {
		ApplicationContext ctx = ApplicationContextUtil
				.getApplicationContext("spring/ch9/app-context.xml");
		ContactDao contactDao = ctx.getBean("contactDao", ContactDao.class);
		List<Contact> contacts = contactDao.findAllWithDetail();
		for (Contact c : contacts) {
			System.out.println(c);
			if (c.getContactTelDetails() != null) {
				for (ContactTelDetail t : c.getContactTelDetails()) {
					System.out.println("    " + t);
				}
			}
		}
		ApplicationContextUtil.close(ctx);
	}

	@Test
	public void testFindById() {
		ApplicationContext ctx = ApplicationContextUtil
				.getApplicationContext("spring/ch9/app-context.xml");
		ContactDao contactDao = ctx.getBean("contactDao", ContactDao.class);
		Contact c = contactDao.findById(1L);
		System.out.println(c);

		ApplicationContextUtil.close(ctx);
	}

	@Test
	public void testSave() {
	}

	@Test
	public void testDelete() {
	}

}
