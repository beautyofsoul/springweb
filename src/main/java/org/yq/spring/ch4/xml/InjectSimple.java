package org.yq.spring.ch4.xml;

public class InjectSimple {
	private String name;
	private int age;
	private float height;
	private boolean programmer;
	private Long ageInSecond;
	public void setName(String name) {
		this.name = name;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public void setHeight(float height) {
		this.height = height;
	}
	public void setProgrammer(boolean programmer) {
		this.programmer = programmer;
	}
	public void setAgeInSecond(Long ageInSecond) {
		this.ageInSecond = ageInSecond;
	}

	@Override
	public String toString() {
		return "InjectSimple [name=" + name + ", age=" + age + ", height="
				+ height + ", programmer=" + programmer + ", ageInSecond="
				+ ageInSecond + "]";
	}
	
	
	
	

}
