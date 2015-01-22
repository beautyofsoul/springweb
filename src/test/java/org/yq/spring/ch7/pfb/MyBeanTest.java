package org.yq.spring.ch7.pfb;

import org.junit.Test;
import org.springframework.context.support.GenericXmlApplicationContext;

public class MyBeanTest {

	@Test
	public void testExecute() {
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
		ctx.load("classpath:META-INF/spring/pfb.xml");
		ctx.refresh();
		MyBean bean1 = (MyBean) ctx.getBean("myBean1");
		MyBean bean2 = (MyBean) ctx.getBean("myBean2");
		System.out.println("Bean 1");
		bean1.execute();
		System.out.println("\nbean 2");
		bean2.execute();
		ctx.close();
	}

}
