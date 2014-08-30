package org.yq.spring.ch4.annotation;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.yq.spring.ch4.MessageProvider;
import org.yq.spring.ch4.MessageRenderer;

@Service("messageRenderer")
public class StandardOutMessageRenderer implements MessageRenderer {
	
	private MessageProvider messageProvider;

	public void render() {
		if(null==messageProvider)
		{
			throw new RuntimeException("no provider");
		}
		System.out.println(messageProvider.getMessage());

	}

	@Resource(name="messageProvider1")
	public void setMessageProvider(MessageProvider provider) {
		this.messageProvider = provider;

	}

	public MessageProvider getMessageProvider() {
		return this.messageProvider;
	}

}
