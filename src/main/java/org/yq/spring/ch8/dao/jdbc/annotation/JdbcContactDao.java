package org.yq.spring.ch8.dao.jdbc.annotation;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.sql.DataSource;

import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;
import org.yq.spring.ch8.dao.ContactDao;
import org.yq.spring.ch8.domain.Contact;

@Repository("contactDao")
public class JdbcContactDao implements ContactDao {

	private DataSource dataSource;

	private SelectAllContacts selectAllContacts;

	private InsertContact insertContact;

	public DataSource getDataSource() {
		return dataSource;
	}

	@Resource(name = "dataSource")
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
		selectAllContacts = new SelectAllContacts(dataSource);
		insertContact = new InsertContact(dataSource);
	}

	@Override
	public List<Contact> findAll() {
		return selectAllContacts.execute();
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

	@Override
	public void insert(Contact contact) {

		Map<String, Object> params = new HashMap<String, Object>();
		params.put("first_name", contact.getFirstName());
		params.put("last_name", contact.getLastName());
		params.put("birth_date", contact.getBirthDate());
		KeyHolder keyHolder = new GeneratedKeyHolder();
		insertContact.updateByNamedParam(params, keyHolder);
		contact.setId(keyHolder.getKey().longValue());
		System.out.println("New Contact id:" + contact.getId());
	}

}
