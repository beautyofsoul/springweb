package org.yq.spring.ch4.xml;

import org.yq.spring.ch4.MessageProvider;

public class HelloWorldMessageProvider implements MessageProvider {

	public String getMessage() {
		return "Hello World!";
	}

}
