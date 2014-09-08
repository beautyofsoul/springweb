package org.yq.spring.ch5.env;

import org.junit.Test;
import org.springframework.context.support.GenericXmlApplicationContext;

public class AppPropertyTest {

	@Test
	public void test() {
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
		ctx.load("classpath:META-INF/spring/env.xml");
	    ctx.refresh();
		AppProperty  p = ctx.getBean("appProperty",AppProperty.class);
		System.out.println("application.home:"+p.getApplicationHome());
		System.out.println("user.home:"+p.getUserHome());
		ctx.close();
	}

}
