package org.yq.spring.ch5.pe;

import org.junit.Test;
import org.springframework.context.support.GenericXmlApplicationContext;

public class PropertyEditorBeanTest {

	@Test
	public void test() {
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
		ctx.load("classpath:META-INF/spring/builtin.xml");
		ctx.refresh();
		ctx.getBean("builtInSample");
		ctx.close();
	}

}
