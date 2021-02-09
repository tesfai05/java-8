package com.tesfai.java8;

import java.util.function.BiConsumer;
import java.util.function.BiFunction;

public class Java8FunctionalnterfacesLambdaExpressions {

	public static void main(String[] args) {

		Interface11 it1 = new Interface11() {
			@Override
			public void print(String s) {
				System.out.println("Annonymous : " + s);
			}
		};
		it1.print("<<<< functional Inteface >>>>>>");

		Interface11 it2 = (s) -> System.out.println("Lambda : " + s);
		it2.print("<<<< functional Inteface >>>>>>");

		BiConsumer<Integer, Integer> c = (x, y) -> System.out.println("BiConsumer : " + (x + y));
		c.accept(34, 23);

		BiFunction<Integer, Integer, Integer> f = (x, y) -> x+y;
		System.out.println("BiFunction : " +f.apply(34, 8));

	}

}

@FunctionalInterface
interface Interface11 {
	void print(String str);
	
	@Override
	String toString();
}
