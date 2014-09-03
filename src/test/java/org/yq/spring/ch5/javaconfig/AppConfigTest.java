package org.yq.spring.ch5.javaconfig;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AppConfigTest {

	@Test
	public void test() {
		@SuppressWarnings("resource")
		ApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
		
		MessageRenderer renderer = ctx.getBean("messageRenderer",MessageRenderer.class);
		
		renderer.render();
		
		
		
	}

}
