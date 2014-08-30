package org.yq.spring.ch4.xml;

import org.junit.Test;
import org.springframework.context.support.GenericXmlApplicationContext;

public class InjectSimpleSpelTest {

	@Test
	public void test() {
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
		ctx.load("classpath:META-INF/spring/app-context-xml.xml");
		ctx.refresh();
		InjectSimpleSpel simple = (InjectSimpleSpel) ctx.getBean("injectSimpleSpel");
		System.out.println(simple);
		ctx.close();
	}

}
