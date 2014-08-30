package org.yq.spring.ch4.annotation;

import org.junit.Test;
import org.springframework.context.support.GenericXmlApplicationContext;

public class InjectSimpleSpelTest {

	@Test
	public void test() {
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
		ctx.load("classpath:META-INF/spring/app-context-annotation.xml");
		ctx.refresh();
		
		InjectSimpleSpel simple = ctx.getBean("injectSimpleSpel",InjectSimpleSpel.class);
		System.out.println(simple);
		
		ctx.close();
	}

}
