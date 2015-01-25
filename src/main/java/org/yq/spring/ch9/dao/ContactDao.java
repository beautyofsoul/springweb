package org.yq.spring.ch9.dao;

import java.util.List;

import org.yq.spring.ch9.domain.Contact;

public interface ContactDao {
   public List<Contact> findAll();
   
   public List<Contact> findAllWithDetail();
   
   public Contact findById(Long id);
   
   public Contact save(Contact contact);
   
   public void delete(Contact contact);
}
