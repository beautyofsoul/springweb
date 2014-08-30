package org.yq.spring.ch4.autowiring;

public class Target {
	
	private Foo foo;
	
	private Foo foo2;
	
	private Bar bar;
	
	public Target() {
	}

	public Target(Foo foo) {
		System.out.println("Target(foo) called");
	}

	public Target(Foo foo, Bar bar) {
		System.out.println("Target(Foo,Bar) called");
	}

	public void setFoo(Foo foo) {
		this.foo = foo;
		System.out.println("Property foo set");
	}

	public void setFoo2(Foo foo2) {
		this.foo2 = foo2;
		System.out.println("Property foo2 set");
		
		
	}

	public void setBar(Bar bar) {
		this.bar = bar;
		System.out.println("Property bar set");
	}

	public Foo getFoo() {
		return foo;
	}

	public Foo getFoo2() {
		return foo2;
	}

	public Bar getBar() {
		return bar;
	}

	
}
