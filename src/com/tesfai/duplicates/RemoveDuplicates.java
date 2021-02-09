package com.tesfai.duplicates;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class RemoveDuplicates {

	public static void main(String... args) {
		
		List<Integer> numbers = new ArrayList<>();
		for (int i = 1; i < 1000; i++) {
			if (i > 700) {
				numbers.add(i);
			}
			numbers.add(i);
		}
		
		// 1.
		Long start1 = System.currentTimeMillis();
		Set<Integer> set = numbers.stream().filter(i -> Collections.frequency(numbers, i) > 1)
				.collect(Collectors.toSet());
		System.out.println("Duplicates : " + set);
		System.out.println(System.currentTimeMillis() - start1);
		
		// 2.
		Set<Integer> allItems = new HashSet<>();
		Long start2 = System.currentTimeMillis();
		Set<Integer> duplicates = numbers.stream().filter(n -> allItems.add(n)).collect(Collectors.toSet());
		System.out.println("Duplicates removed : " + duplicates);
		System.out.println(System.currentTimeMillis() - start2);
		
		// 3.
		Long start3 = System.currentTimeMillis();
		Set<Integer> duplicateRemoved = numbers.stream().distinct().collect(Collectors.toSet());
		System.out.println("Duplicates removed : " + duplicateRemoved);
		System.out.println(System.currentTimeMillis() - start3);
		
		// 4.
		Set<Integer> s = new HashSet<>();
		Long start4 = System.currentTimeMillis();
		for (Integer r : numbers) {
			s.add(r);
		}
		System.out.println("Duplicates removed : " + s);
		System.out.println(System.currentTimeMillis() - start4);
	}
}
