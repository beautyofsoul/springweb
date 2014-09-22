package org.yq.spring.ch6;

import org.junit.Test;
import org.springframework.aop.framework.ProxyFactory;

public class SimpleThrowsAdviceTest {

	@Test
	public void test() {
		ErrorBean errorBean = new ErrorBean();
		ProxyFactory pf = new ProxyFactory();
		pf.setTarget(errorBean);
		pf.addAdvice(new SimpleThrowsAdvice());

		ErrorBean proxy = (ErrorBean) pf.getProxy();

		try {
			proxy.errorProneMethod();
		} catch (Exception e) {

		}

		try {
			proxy.otherErrorProneMethod();
		} catch (Exception e) {

		}

	}

}
