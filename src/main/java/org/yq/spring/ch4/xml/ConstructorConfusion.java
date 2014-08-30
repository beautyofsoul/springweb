package org.yq.spring.ch4.xml;

public class ConstructorConfusion {
	
	private String someValue;
	
	public ConstructorConfusion(String someValue) {
        System.out.println("ConstrutctorConfusion(String) called");
        this.someValue = someValue;
	}
	
	public ConstructorConfusion(int someValue) {
		System.out.println("ConstrutctorConfusion(int) called");
		this.someValue = "Number:"+Integer.toString(someValue);
	}
	
	@Override
	public String toString() {
		return someValue;
	}

}
