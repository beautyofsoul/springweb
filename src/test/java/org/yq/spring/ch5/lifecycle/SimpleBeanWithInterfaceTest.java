package org.yq.spring.ch5.lifecycle;

import org.junit.Test;
import org.springframework.beans.factory.BeanCreationException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class SimpleBeanWithInterfaceTest {

	@Test
	public void test() {
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
		ctx.load("classpath:META-INF/spring/initInterface.xml");
		ctx.refresh();
		getBean("simpleBean1", ctx);
		getBean("simpleBean2", ctx);
		getBean("simpleBean3", ctx);
		ctx.close();
	}

	private SimpleBeanWithInterface getBean(String beanName, ApplicationContext ctx) {
		try {
			SimpleBeanWithInterface bean = ctx.getBean(beanName, SimpleBeanWithInterface.class);
			System.out.println(bean);

			return bean;
		} catch (BeanCreationException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	

}
