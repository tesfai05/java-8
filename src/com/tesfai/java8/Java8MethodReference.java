package com.tesfai.java8;

@FunctionalInterface
interface Interface_default {
	void display();
}

class Derived_class {
	public void classMethod() {
		System.out.println("Derived class Method");
	}
}

public class Java8MethodReference {
	public static void main(String[] args) {
		//code reusablity
		Derived_class obj1 = new Derived_class();
		Interface_default ref = obj1::classMethod;
		ref.display();
		 
		Interface_default i =()->System.out.println("Derived class Method"); 
		i.display();
		
	}
}
