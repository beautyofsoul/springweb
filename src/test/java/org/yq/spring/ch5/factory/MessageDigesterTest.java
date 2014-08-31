package org.yq.spring.ch5.factory;

import org.junit.Test;
import org.springframework.context.support.GenericXmlApplicationContext;

public class MessageDigesterTest {

	@Test
	public void test() {
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
		ctx.load("classpath:META-INF/spring/factory.xml");
		ctx.refresh();
		MessageDigester digestor = ctx.getBean("digester",MessageDigester.class);
		digestor.digest("Hello World");
		MessageDigestFactoryBean factoryBean = ctx.getBean("&shaDigest",MessageDigestFactoryBean.class);
		System.out.println(factoryBean.getObjectType());
		ctx.close();
	}

}
