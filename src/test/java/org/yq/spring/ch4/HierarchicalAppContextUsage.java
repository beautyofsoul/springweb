package org.yq.spring.ch4;

import org.junit.Test;
import org.springframework.context.support.GenericXmlApplicationContext;

public class HierarchicalAppContextUsage {

	@Test
	public void test() {
		GenericXmlApplicationContext parent = new GenericXmlApplicationContext();
		parent.load("classpath:META-INF/spring/parent.xml");
		parent.refresh();
		
		GenericXmlApplicationContext child = new GenericXmlApplicationContext();
		child.load("classpath:META-INF/spring/app-context-xml.xml");
		
		child.setParent(parent);
		child.refresh();
		
		SimpleTarget target1 = child.getBean("target1",SimpleTarget.class);
		SimpleTarget target2 = child.getBean("target2",SimpleTarget.class);
		SimpleTarget target3 = child.getBean("target3",SimpleTarget.class);
		
		System.out.println(target1.getVal());
		System.out.println(target2.getVal());
		System.out.println(target3.getVal());
		
		child.close();
	
	}

}
