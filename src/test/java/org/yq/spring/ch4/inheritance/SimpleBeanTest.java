package org.yq.spring.ch4.inheritance;

import org.junit.Test;
import org.springframework.context.support.GenericXmlApplicationContext;

public class SimpleBeanTest {

	@Test
	public void test() {
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
		ctx.load("classpath:META-INF/spring/inheritance.xml");
		ctx.refresh();

		SimpleBean parent = ctx.getBean("inheritParent", SimpleBean.class);
		System.out.println(parent);
		SimpleBean child = ctx.getBean("inheritChild", SimpleBean.class);
		
		System.out.println(child);
		ctx.close();
	}

}
