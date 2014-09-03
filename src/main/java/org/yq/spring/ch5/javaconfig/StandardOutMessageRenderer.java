package org.yq.spring.ch5.javaconfig;

public class StandardOutMessageRenderer implements MessageRenderer {

	
	private MessageProvider messageProvider = null;
	@Override
	public void render() {
		if(null == messageProvider)
		{
			throw new RuntimeException("must havw messageProvider");
		}
		System.out.println(messageProvider.getMessage());
		
	}

	@Override
	public void setMessageProvider(MessageProvider provider) {
		this.messageProvider = provider;
		
	}

	@Override
	public MessageProvider getMessageProvider() {
		return messageProvider;
	}

	

}
