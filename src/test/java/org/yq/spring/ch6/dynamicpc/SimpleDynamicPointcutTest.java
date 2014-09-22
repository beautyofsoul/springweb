package org.yq.spring.ch6.dynamicpc;

import org.junit.Test;
import org.springframework.aop.Advisor;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.aop.support.DefaultPointcutAdvisor;
import org.yq.spring.ch6.staticpc.SimpleAdvice;

public class SimpleDynamicPointcutTest {

	@Test
	public void test() {
	    SimpleBean target = new SimpleBean();
	    
	    Advisor advisor = new DefaultPointcutAdvisor(new SimpleDynamicPointcut(),new SimpleAdvice());
	    
	    ProxyFactory pf = new ProxyFactory();
	    pf.addAdvisor(advisor);
	    pf.setTarget(target);
	    
	    SimpleBean proxy = (SimpleBean)pf.getProxy();
	    
	    proxy.foo(1);
	    proxy.foo(10);
	    proxy.foo(100);
	    
	    proxy.bar();
	    proxy.bar();
	    proxy.bar();
	}

}
