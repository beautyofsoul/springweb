package org.yq.spring.ch7.composable;

import org.junit.Test;
import org.springframework.aop.Advisor;
import org.springframework.aop.ClassFilter;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.aop.support.ComposablePointcut;
import org.springframework.aop.support.DefaultPointcutAdvisor;
import org.yq.spring.ch7.cflow.SimpleBeforeAdvice;

public class SampleBeanTest {

	@Test
	public void test() {
		SampleBean target = new SampleBean();

		ComposablePointcut pc = new ComposablePointcut(ClassFilter.TRUE,
				new GetterMethodMatcher());

		System.out.println("Test 1");

		SampleBean proxy = getProxy(pc, target);
		testInvoke(proxy);

		System.out.println("Test 2");
		pc.union(new SetterMethodMatcher());
		proxy = getProxy(pc, target);
		testInvoke(proxy);
		
		System.out.println("Test 3");
		pc.intersection(new GetAgeMethodMatcher());
		proxy = getProxy(pc, target);
		testInvoke(proxy);
	}

	private void testInvoke(SampleBean proxy) {
		proxy.getAge();
		proxy.getName();
		proxy.setName("Clarence Ho");

	}

	private SampleBean getProxy(ComposablePointcut pc, SampleBean target) {
		Advisor advisor = new DefaultPointcutAdvisor(pc,
				new SimpleBeforeAdvice());
		ProxyFactory pf = new ProxyFactory();
		pf.setTarget(target);
		pf.addAdvisor(advisor);

		return (SampleBean) pf.getProxy();
	}

}
