package org.yq.spring.ch4.annotation;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service("injectSimpleSpel")
public class InjectSimpleSpel {
	@Value("#{injectSimpleConfig.name}")
	private String name;
	@Value("#{injectSimpleConfig.age+2}")
	private int age;
	@Value("#{injectSimpleConfig.height}")
	private float height;
	@Value("#{injectSimpleConfig.programmer}")
	private boolean programmer;
	@Value("#{injectSimpleConfig.ageInSeconds}")
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
		return "InjectSimpleSpel [name=" + name + ", age=" + age + ", height="
				+ height + ", programmer=" + programmer + ", ageInSecond="
				+ ageInSecond + "]";
	}

}
