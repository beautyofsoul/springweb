package org.yq.spring.ch8.dao.jdbc.xml;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.BeanCreationException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.yq.spring.ch8.dao.ContactDao;
import org.yq.spring.ch8.domain.Contact;

public class JdbcContactDao implements ContactDao, InitializingBean {

	private DataSource dataSource;

	private JdbcTemplate jdbcTemplate;

	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
		this.jdbcTemplate = new JdbcTemplate(this.dataSource);
		this.namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(
				this.dataSource);
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		if (this.dataSource == null) {
			throw new BeanCreationException("must set datasource on ContactDao");
		}

	}

	@Override
	public List<Contact> findAll() {
		String sql = "select id,first_name,last_name,birth_date from contact";
		return jdbcTemplate.query(sql, new ContactMapper());
	}

	private static final class ContactMapper implements RowMapper<Contact> {
		@Override
		public Contact mapRow(ResultSet rs, int rowNum) throws SQLException {
			Contact contact = new Contact();
			contact.setId(rs.getLong("id"));
			contact.setFirstName(rs.getString("first_name"));
			contact.setLastName(rs.getString("last_name"));
			contact.setBirthDate(rs.getDate("birth_date"));
			return contact;
		}
	}

	@Override
	public String findFirstNameById(Long id) {
		String firstName = jdbcTemplate.queryForObject(
				"select first_name from contact where id = ? ",
				new Object[] { id }, String.class);
		return firstName;
	}

	@Override
	public String findLastNameById(Long id) {
		String sql = "select last_name from contact where id = :contactId";
		Map<String, Object> namedParameters = new HashMap<String, Object>();
		namedParameters.put("contactId", id);
		String lastName = namedParameterJdbcTemplate.queryForObject(sql,
				namedParameters, String.class);
		return lastName;
	}

	@Override
	public void insert(Contact contact) {
		// TODO Auto-generated method stub
		
	}

}
