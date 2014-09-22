package org.yq.spring.ch6.proxies;

import org.junit.Test;
import org.springframework.aop.Advisor;
import org.springframework.aop.framework.Advised;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.aop.support.DefaultPointcutAdvisor;

public class NoOpBeforeAdviceTest {

	@Test
	public void test() {
		ISimpleBean target = new SimpleBean();
		Advisor advisor = new DefaultPointcutAdvisor(new TestPointcut(),
				new NoOpBeforeAdvice());

		runCgLibTest(advisor, target);
		runCgLibFrozenTest(advisor, target);
		runJdkTest(advisor, target);
		
	}

	private void runJdkTest(Advisor advisor, ISimpleBean target) {
		ProxyFactory pf = new ProxyFactory();
		
		pf.setTarget(target);
		pf.addAdvisor(advisor);
		pf.setInterfaces(new Class[]{ISimpleBean.class});

		ISimpleBean proxy = (ISimpleBean) pf.getProxy();
		System.out.println("Running Jdk Tests");
		test(proxy);
		
	}

	private void runCgLibFrozenTest(Advisor advisor, ISimpleBean target) {
		ProxyFactory pf = new ProxyFactory();
		pf.setProxyTargetClass(true);
		pf.setTarget(target);
		pf.addAdvisor(advisor);
		pf.setFrozen(true);

		ISimpleBean proxy = (ISimpleBean) pf.getProxy();
		System.out.println("Running CGLIB(Frozen) Tests");
		test(proxy);
		
	}

	private void runCgLibTest(Advisor advisor, ISimpleBean target) {
		ProxyFactory pf = new ProxyFactory();
		pf.setProxyTargetClass(true);
		pf.setTarget(target);
		pf.addAdvisor(advisor);

		ISimpleBean proxy = (ISimpleBean) pf.getProxy();
		System.out.println("Running CGLIB(Standard) Tests");
		test(proxy);

	}

	private void test(ISimpleBean proxy) {
		long before = 0;

		long after = 0;

		// Test1:test advised method
		System.out.println("Testing advised method");
		before = System.currentTimeMillis();
		for (int x = 0; x < 50000; x++) {
			proxy.advised();
		}
		after = System.currentTimeMillis();

		System.out.println("Took " + (after - before) + " ms");

		// Test 2: testing unadvised method
		System.out.println("Testing Unadvised Method");
		before = System.currentTimeMillis();
		for (int x = 0; x < 500000; x++) {
			proxy.unadvised();
		}
		after = System.currentTimeMillis();
		;
		System.out.println("Took " + (after - before) + " ms");

		// Test 3: testing equals() method
		System.out.println("Testing equals() Method");
		before = System.currentTimeMillis();
		for (int x = 0; x < 500000; x++) {
			proxy.equals(proxy);
		}
		after = System.currentTimeMillis();
		;
		System.out.println("Took " + (after - before) + " ms");

		// Test 4: testing hashCode() method
		System.out.println("Testing hashCode() Method");
		before = System.currentTimeMillis();
		for (int x = 0; x < 500000; x++) {
			proxy.hashCode();
		}
		after = System.currentTimeMillis();
		;
		System.out.println("Took " + (after - before) + " ms");

		// Test 5: testing method on Advised
		Advised advised = (Advised) proxy;
		System.out.println("Testing Advised.getProxyTargetClass() Method");
		before = System.currentTimeMillis();
		for (int x = 0; x < 500000; x++) {
			advised.getTargetClass();
		}
		after = System.currentTimeMillis();
		;
		System.out.println("Took " + (after - before) + " ms");
		System.out.println(">>>\n");

	}

}
