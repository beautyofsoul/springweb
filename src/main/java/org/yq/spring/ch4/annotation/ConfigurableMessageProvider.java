package org.yq.spring.ch4.annotation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.yq.spring.ch4.MessageProvider;

@Service("messageProvider1")
public class ConfigurableMessageProvider implements MessageProvider {

	private String message;

	//È¥µô×¢½â@Value("This is annotation config!")
	@Autowired
	public ConfigurableMessageProvider(
			String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

}
