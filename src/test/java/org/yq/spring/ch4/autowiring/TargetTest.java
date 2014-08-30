package org.yq.spring.ch4.autowiring;

import org.junit.Test;
import org.springframework.context.support.GenericXmlApplicationContext;

public class TargetTest {

	@Test
	public void test() {
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
		ctx.load("classpath:META-INF/spring/autowiring.xml");
		ctx.refresh();

		Target t = null;
		System.out.println("Using byName:\n");
		t = (Target) ctx.getBean("targetByName");
		System.out.println("\nUsing byType:\n");
		t = (Target) ctx.getBean("targetByType");
		System.out.println("\nUsing constructor:\n");
		t = (Target) ctx.getBean("targetConstructor");
		t.getFoo();
		ctx.close();
	}

}
