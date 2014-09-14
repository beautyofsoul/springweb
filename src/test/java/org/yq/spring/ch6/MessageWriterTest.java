package org.yq.spring.ch6;

import org.junit.Test;
import org.springframework.aop.framework.ProxyFactory;

public class MessageWriterTest {

	@Test
	public void test() {
		MessageWriter target = new MessageWriter();
		ProxyFactory pf = new ProxyFactory();
		pf.addAdvice(new MessageDecorator());
		pf.setTarget(target);
		MessageWriter proxy = (MessageWriter) pf.getProxy();
		target.writeMessage();
		System.out.println("");
		proxy.writeMessage();
	}

}
