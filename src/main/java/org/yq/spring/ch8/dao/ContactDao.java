package org.yq.spring.ch8.dao;

import java.util.List;

import org.yq.spring.ch8.domain.Contact;

public interface ContactDao {

	public List<Contact> findAll();
	
	public String findFirstNameById(Long id);
	
	public String findLastNameById(Long id);
	
	public void insert(Contact contact);
}
