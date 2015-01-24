package org.yq.spring.ch8.domain;

import java.io.Serializable;
import java.sql.Date;
import java.util.List;

public class Contact implements Serializable {


	private static final long serialVersionUID = 1L;
	
	private Long id;
	
	private String firstName;
	
	private String lastName;
	
	private Date birthDate;
	
	private List<ContactTelDetail> contactTelDetails;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	public List<ContactTelDetail> getContactTelDetails() {
		return contactTelDetails;
	}

	public void setContactTelDetails(List<ContactTelDetail> contactTelDetails) {
		this.contactTelDetails = contactTelDetails;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Contact [id=");
		builder.append(id);
		builder.append(", firstName=");
		builder.append(firstName);
		builder.append(", lastName=");
		builder.append(lastName);
		builder.append(", birthDate=");
		builder.append(birthDate);
		builder.append(", contactTelDetails=");
		builder.append(contactTelDetails);
		builder.append("]");
		return builder.toString();
	}
	
	

}
