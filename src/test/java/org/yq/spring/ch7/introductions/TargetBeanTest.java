package org.yq.spring.ch7.introductions;

import org.junit.Test;
import org.springframework.aop.IntroductionAdvisor;
import org.springframework.aop.framework.ProxyFactory;

public class TargetBeanTest {

	@Test
	public void test() {
		TargetBean target = new TargetBean();
		target.setName("Clarence Ho1");

		IntroductionAdvisor advisor = new IsModifiedAdvisor();

		ProxyFactory pf = new ProxyFactory();

		pf.setTarget(target);
		pf.addAdvisor(advisor);
		pf.setOptimize(true);

		TargetBean proxy = (TargetBean) pf.getProxy();

		IsModified proxyInterface = (IsModified) proxy;

		System.out.println("Is TargetBean?:" + (proxy instanceof TargetBean));
		System.out.println("Is IsModified?:" + (proxy instanceof IsModified));

		System.out.println("Has been modified?:" + proxyInterface.isModified());
		proxy.setName("Clarence Ho");
		System.out.println("Has been modified?:" + proxyInterface.isModified());
		proxy.setName("Rob Harrop");
		System.out.println("Has been modified?:" + proxyInterface.isModified());
	}

}
