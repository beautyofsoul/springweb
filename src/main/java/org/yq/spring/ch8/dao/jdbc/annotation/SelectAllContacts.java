package org.yq.spring.ch8.dao.jdbc.annotation;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.jdbc.object.MappingSqlQuery;
import org.yq.spring.ch8.domain.Contact;

public class SelectAllContacts extends MappingSqlQuery<Contact> {

	public SelectAllContacts(DataSource dataSource) {
		super(dataSource,
				"select id,first_name,last_name,birth_date from contact");
	}

	@Override
	protected Contact mapRow(ResultSet rs, int rowNum) throws SQLException {
		Contact contact = new Contact();
		contact.setId(rs.getLong("id"));
		contact.setFirstName(rs.getString("first_name"));
		contact.setLastName(rs.getString("last_name"));
		contact.setBirthDate(rs.getDate("birth_date"));
		return contact;
	}

}
