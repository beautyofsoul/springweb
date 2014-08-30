package org.yq.spring.ch4.xml;

import org.junit.Test;
import org.springframework.context.support.GenericXmlApplicationContext;

public class CollectionInjectionTest {

	@Test
	public void test() {
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
		ctx.load("classpath:META-INF/spring/app-context-xml.xml");
		ctx.refresh();
		CollectionInjection simple = (CollectionInjection) ctx.getBean("injectCollection");
		simple.displayInfo();
		ctx.close();
	}

}
