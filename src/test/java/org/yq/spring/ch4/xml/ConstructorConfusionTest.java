package org.yq.spring.ch4.xml;

import org.junit.Test;
import org.springframework.context.support.GenericXmlApplicationContext;

public class ConstructorConfusionTest {

	@Test
	public void testToString() {
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
		ctx.load("classpath:META-INF/spring/app-context-xml.xml");
		ctx.refresh();
		
		ConstructorConfusion  cc = (ConstructorConfusion)ctx.getBean("constructorConfusion");
		System.out.println(cc);
		ctx.close();
	}

}
