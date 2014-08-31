package org.yq.spring.ch5.lifecycle;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class DestructiveBeanWithJSR250 {
     
	@PostConstruct
	public void afterPropertiesSet() {
		System.out.println("init bean");
	}
	
	@PreDestroy
	public void destory()
	{
		System.out.println("destory bean");
	}
}
