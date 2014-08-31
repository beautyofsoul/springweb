package org.yq.spring.ch5.lifecycle;

public class SimpleBean {

	private static final String DEFAULT_NAME = "Luke Skywalker";

	private String name = null;

	private int age = Integer.MIN_VALUE;

	public void init() {
		System.out.println("Initializing bean");
		if (name == null) {
			System.out.println("Using default name");
			name = DEFAULT_NAME;
		}

		if (age == Integer.MIN_VALUE) {
			throw new IllegalArgumentException(
					"You must set age property of type " + SimpleBean.class);
		}
	}
	
	public void destory()
	{
		System.out.println("Destory bean");
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
		return "SimpleBean [name=" + name + ", age=" + age + "]";
	}

   
	
	

}
