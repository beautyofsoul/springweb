package org.yq.spring.ch5.lifecycle;

import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

public class SimpleBeanWithInterface implements InitializingBean,
		DisposableBean,BeanNameAware {

	private static final String DEFAULT_NAME = "Luke Skywalker";

	private String name = null;

	private int age = Integer.MIN_VALUE;

	
	private String beanName;
	public void myInit() {
		System.out.println("My Init");
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("Initializing bean");
		if (name == null) {
			System.out.println("Using default name");
			name = DEFAULT_NAME;
		}

		if (age == Integer.MIN_VALUE) {
			throw new IllegalArgumentException(
					"You must set age property of type "
							+ SimpleBeanWithInterface.class);
		}

	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	
	

	@Override
	public String toString() {
		return "SimpleBeanWithInterface [name=" + name + ", age=" + age
				+ ", beanName=" + beanName + "]";
	}

	@Override
	public void destroy() throws Exception {
		System.out.println("dispose bean " + this);

	}

	@Override
	public void setBeanName(String name) {
		beanName = name;
		
	}
	
	

}
