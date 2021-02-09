package com.tesfai.duplicates;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Duplicates {
	
	public static void main(String...args) {
		
		//1.
		List<Integer> numbers= Arrays.asList(1,2,3,2,1,3,2,4);
		
		Set<Integer> duplicates1 = 
				numbers.stream()
				.filter(i -> Collections.frequency(numbers, i) >1)
				.collect(Collectors.toSet());
		
		System.out.println("Duplicates using Collections.frequency and Set in stream : " + duplicates1);
		
		//2.
		Set<Integer> allItems = new HashSet<>();
		
		Set<Integer> duplicates2 =  
				numbers.stream()
		        .filter(n -> !allItems.add(n)) //Set.add() returns false if the item was already in the set.
		        .collect(Collectors.toSet());
		
		System.out.println("Duplicates using Set in stream : " + duplicates2);
		
		
		// 3.
		Set<Integer> duplicates3 = new HashSet<>();
				
		for(int k=0;k<numbers.size();k++) {
			if(Collections.frequency(numbers, numbers.get(k))>1) {
				duplicates3.add(numbers.get(k));
			}
		}
		
		System.out.println("Duplicates using Collections.frequency() and Set no stream: " + duplicates3);
		
	}
}
