package org.yq.spring.ch5.javaconfig;

public class ConfigurableMessageProvider implements MessageProvider {

	private String message = "Default message";

	public ConfigurableMessageProvider() {
	}

	public ConfigurableMessageProvider(String message) {
		this.message = message;
	}

	@Override
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
