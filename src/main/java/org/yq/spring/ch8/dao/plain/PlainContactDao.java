package org.yq.spring.ch8.dao.plain;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.yq.spring.ch8.dao.ContactDao;
import org.yq.spring.ch8.domain.Contact;

public class PlainContactDao implements ContactDao {
	static {
		try {
			Class.forName("org.postgresql.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	private Connection getConnection() throws SQLException {
		return DriverManager
				.getConnection("jdbc:postgresql://localhost:5432/spring",
						"spring", "Admin111");
	}

	private void closeConnection(Connection connection) {
		if (null == connection) {
			return;
		}
		try {
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<Contact> findAll() {
		List<Contact> result = new ArrayList<Contact>();
		Connection connection = null;
		try {
			connection = getConnection();
			PreparedStatement statement = connection.prepareStatement("select * from contact");
			ResultSet rs = statement.executeQuery();
			while(rs.next())
			{
				Contact contact = new Contact();
				contact.setId(rs.getLong("id"));
				contact.setFirstName(rs.getString("first_name"));
				contact.setLastName(rs.getString("last_name"));
				contact.setBirthDate(rs.getDate("birth_date"));
				result.add(contact);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally
		{
			closeConnection(connection);
		}
		return result;
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
		// TODO Auto-generated method stub
		
	}

}
