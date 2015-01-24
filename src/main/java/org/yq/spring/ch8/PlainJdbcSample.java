package org.yq.spring.ch8;

import java.util.List;

import org.yq.spring.ch8.dao.ContactDao;
import org.yq.spring.ch8.dao.plain.PlainContactDao;
import org.yq.spring.ch8.domain.Contact;

public class PlainJdbcSample {
	private static ContactDao contactDao = new PlainContactDao();
	public static void main(String[] args) {
      System.out.println("Listing initial contact data!");
      listAllContacts();
	}
	private static void listAllContacts() {
		List<Contact> contacts = contactDao.findAll();
		for(Contact c:contacts)
		{
			System.out.println(c);
		}
		
	}
}
