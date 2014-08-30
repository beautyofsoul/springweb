package org.yq.spring.ch4.xml;

import org.junit.Test;
import org.springframework.context.support.GenericXmlApplicationContext;

public class InjectSimpleTest {

	@Test
	public void test() {
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
		ctx.load("classpath:META-INF/spring/app-context-xml.xml");
		ctx.refresh();
		InjectSimple simple = (InjectSimple) ctx.getBean("injectSimple");
		System.out.println(simple);
		ctx.close();
	}

}
