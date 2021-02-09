package com.tesfai.java8;

class ParentClass {
	public void hello() {
		System.out.println("Hello ParentClass!");
	}
}

interface InterfaceFoo {
	default public void hello() {
		System.out.println("Hello InterfaceFoo!");
	}
}

interface InterfaceBar {
	default public void hello() {
		System.out.println("Hello InterfaceBar!");
	}
}

public class Java8DefaultMethodOnly extends ParentClass implements InterfaceFoo, InterfaceBar {
	public void hello() {
		super.hello(); // (note: ParentClass.super could not be used)
		InterfaceFoo.super.hello();
		InterfaceBar.super.hello();
	}

	public static void main(String[] args) {
		new Java8DefaultMethodOnly().hello();
	}
}
