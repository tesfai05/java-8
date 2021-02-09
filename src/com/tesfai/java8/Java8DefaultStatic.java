package com.tesfai.java8;

public class Java8DefaultStatic {

	public static void main(String[] args) {
		MyClass obj = new MyClass();
		
		obj.log("<<<<<<< MyClass >>>>>>");
		obj.m();
	}
}


@FunctionalInterface
interface Interface1 {

	void method1(String str);
	
	public default void log(String str){
		System.out.println("Interface1 logging : "+str);
	}
	
	static void print(String str){
		System.out.println("Printing : "+str);
	}
	
//	Trying to override Object method gives compile-time error as
//	"A default method cannot override a method from java.lang.Object"
//  Coz it is irrelevant
	
//	default String toString(){
//		return "i1";
//	}
	
}

@FunctionalInterface
interface Interface2 {

	void method2();
	
	default void log(String str){
		System.out.println("Interface2 logging : "+str);
	}

}


@FunctionalInterface
interface Interface3 {

	void method3();
	//String toString();
//	default String toString() {
//		
//	}
	default void log(String str){
		System.out.println("Interface2 logging : "+str);
	}

}

class MyClass implements Interface1,Interface2 {
	
	@Override
	public void method1(String str) {
	}
	
	@Override
	public void method2() {
	}

	//MyClass won't compile without having it's own log() implementation
	@Override
	public void log(String str){
		System.out.println("MyClass logging : "+str);
		Interface1.print("<<< static method of Interface1 >>>>>");
	}
	
	public void m() {
		Interface1.super.log("<< INTERFACE1>>");
		Interface2.super.log("<< INTERFACE2>>");
	}
	
}


