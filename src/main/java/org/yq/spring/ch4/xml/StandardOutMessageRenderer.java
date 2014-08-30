package org.yq.spring.ch4.xml;

import org.yq.spring.ch4.MessageProvider;
import org.yq.spring.ch4.MessageRenderer;

public class StandardOutMessageRenderer implements MessageRenderer {
	
	private MessageProvider messageProvider;

	public void render() {
		if(null==messageProvider)
		{
			throw new RuntimeException("no provider");
		}
		System.out.println(messageProvider.getMessage());

	}

	public void setMessageProvider(MessageProvider provider) {
		this.messageProvider = provider;

	}

	public MessageProvider getMessageProvider() {
		return this.messageProvider;
	}

}
