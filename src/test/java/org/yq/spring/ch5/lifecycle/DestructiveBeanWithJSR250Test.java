package org.yq.spring.ch5.lifecycle;

import org.junit.Test;
import org.springframework.context.support.GenericXmlApplicationContext;

public class DestructiveBeanWithJSR250Test {

	@Test
	public void test() {
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
		ctx.load("classpath:META-INF/spring/disposeJSR250.xml");
		ctx.refresh();
		//ctx.registerShutdownHook();
		ctx.getBean("destructiveBean",DestructiveBeanWithJSR250.class);
		System.out.println("calling destory()");
		ctx.close();
		System.out.println("called destory()");
	}

}
