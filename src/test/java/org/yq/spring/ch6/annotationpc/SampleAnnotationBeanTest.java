package org.yq.spring.ch6.annotationpc;

import org.junit.Test;
import org.springframework.aop.Advisor;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.aop.support.DefaultPointcutAdvisor;
import org.springframework.aop.support.annotation.AnnotationMatchingPointcut;
import org.yq.spring.ch6.staticpc.SimpleAdvice;

public class SampleAnnotationBeanTest {

	@Test
	public void test() {
		SampleAnnotationBean target = new SampleAnnotationBean();
		
		AnnotationMatchingPointcut pc = AnnotationMatchingPointcut.forMethodAnnotation(AdviceRequired.class);
	    
		Advisor advisor = new DefaultPointcutAdvisor(pc, new SimpleAdvice());
		
		ProxyFactory pf = new ProxyFactory();
		pf.setTarget(target);
		pf.addAdvisor(advisor);
		
		SampleAnnotationBean proxy = (SampleAnnotationBean)pf.getProxy();
		proxy.foo(10);
		proxy.bar();
	
	}

}
