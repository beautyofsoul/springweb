package org.yq.spring.ch4.annotation;

import org.junit.Test;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.yq.spring.ch4.MessageProvider;
import org.yq.spring.ch4.MessageRenderer;

public class StandardOutMessageRendererTest {

	@Test
	public void testRender() {
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
		ctx.load("classpath:META-INF/spring/app-context-annotation.xml");
		ctx.refresh();
		
		MessageProvider provider = ctx.getBean("messageProvider",MessageProvider.class);
		System.out.println(provider.getMessage());
		
		MessageRenderer renderer = ctx.getBean("messageRenderer",MessageRenderer.class);
		renderer.render();
		ctx.close();
	}

}
