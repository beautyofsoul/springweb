package org.yq.spring.ch8.domain;

import java.io.Serializable;

public class ContactTelDetail implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;

	private Long contactId;

	private String telType;

	private String telNumber;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getContactId() {
		return contactId;
	}

	public void setContactId(Long contactId) {
		this.contactId = contactId;
	}

	public String getTelType() {
		return telType;
	}

	public void setTelType(String telType) {
		this.telType = telType;
	}

	public String getTelNumber() {
		return telNumber;
	}

	public void setTelNumber(String telNumber) {
		this.telNumber = telNumber;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ContactTelDetail [id=");
		builder.append(id);
		builder.append(", contactId=");
		builder.append(contactId);
		builder.append(", telType=");
		builder.append(telType);
		builder.append(", telNumber=");
		builder.append(telNumber);
		builder.append("]");
		return builder.toString();
	}

}
