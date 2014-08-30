package org.yq.spring.ch4.xml;

import org.yq.spring.ch4.MessageProvider;

public class ConfigurableMessageProvider implements MessageProvider {
	
	private String message;
	
	public ConfigurableMessageProvider(String message) {
       this.message = message;
	}

	public String getMessage() {
		return message;
	}

}
