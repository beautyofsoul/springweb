package org.yq.spring.ch4.annotation;

import org.springframework.stereotype.Service;
import org.yq.spring.ch4.MessageProvider;

@Service("messageProvider")
public class HelloWorldMessageProvider implements MessageProvider {

	public String getMessage() {
		return "Annotation:Hello World!";
	}

}
