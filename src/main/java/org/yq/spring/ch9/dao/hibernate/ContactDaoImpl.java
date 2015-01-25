package org.yq.spring.ch9.dao.hibernate;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.yq.spring.ch9.dao.ContactDao;
import org.yq.spring.ch9.domain.Contact;

@Repository("contactDao")
@Transactional
public class ContactDaoImpl implements ContactDao {

	private SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	@Resource(name = "sessionFactory")
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@SuppressWarnings("unchecked")
	@Override
	@Transactional(readOnly = true)
	public List<Contact> findAll() {
		return sessionFactory.getCurrentSession().createQuery("from Contact c")
				.list();
	}

	@SuppressWarnings("unchecked")
	@Override
	@Transactional(readOnly = true)
	public List<Contact> findAllWithDetail() {
		return sessionFactory.getCurrentSession()
				.getNamedQuery("Contact.findAllWithDetail").list();
	}

	@Override
	public Contact findById(Long id) {

		return (Contact) sessionFactory.getCurrentSession()
				.getNamedQuery("Contact.findById").setParameter("id", id)
				.uniqueResult();
	}

	@Override
	public Contact save(Contact contact) {
		
		 sessionFactory.getCurrentSession().saveOrUpdate(contact);
		 System.out.println("Contact save with id:"+contact.getId());
		 return contact;
	}

	@Override
	public void delete(Contact contact) {
		// TODO Auto-generated method stub

	}

}
