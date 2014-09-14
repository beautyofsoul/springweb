package org.yq.spring.ch6.security;

import org.junit.Test;
import org.springframework.aop.framework.ProxyFactory;
import org.yq.spring.ch6.SimpleAfterReturningAdvice;

public class SecurityAdviceTest {

	@Test
	public void test() {
		SecurityManager mgr = new SecurityManager();

		SecureBean bean = getSecureBean();

		mgr.login("clarence", "pwd");
		bean.writeSecureMessage();
		mgr.logout();

		try {
			mgr.login("janm", "pwd");
			bean.writeSecureMessage();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			mgr.logout();
		}

		try {

			bean.writeSecureMessage();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	private SecureBean getSecureBean() {
		SecureBean target = new SecureBean();
		SecurityAdvice advice = new SecurityAdvice();
		

		ProxyFactory factory = new ProxyFactory();
		factory.setTarget(target);
		factory.addAdvice(advice);
		factory.addAdvice(new SimpleAfterReturningAdvice());
		SecureBean proxy = (SecureBean) factory.getProxy();

		return proxy;
	}

}
