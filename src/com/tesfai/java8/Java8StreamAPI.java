package com.tesfai.java8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Java8StreamAPI {

	public static void main(String[] args) {
		List<Integer> myList = new ArrayList<>();
		for (int i = 0; i < 100; i++)
			myList.add(i);

		// sequential stream
		myList.stream().filter(p -> p % 2 != 0 && p > 50)
				.forEach(p -> System.out.println("High Nums sequential = " + p));

		// parallel stream
		myList.parallelStream().filter(p -> p % 2 != 0 && p > 50)
				.forEach(p -> System.out.println("High Nums parallel = " + p));

		//
		myList.stream();

		String[][] str = new String[][] { { "a", "b" }, { "c", "d" } };

		Arrays.stream(str)
			.flatMap(s -> Arrays.stream(s))
			.filter(a -> a != "c")
			.forEach(System.out::println);

	}

}
