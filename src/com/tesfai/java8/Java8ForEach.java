package com.tesfai.java8;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Consumer;

public class Java8ForEach {

	public static void main(String[] args) {
		// creating sample Collection
		List<Integer> myList = new ArrayList<Integer>();
		for (int i = 0; i < 10; i++)
			myList.add(i);

		// traversing using Iterator
		Iterator<Integer> it = myList.iterator();
		while (it.hasNext()) {
			Integer i = it.next();
			System.out.println("Iterator Value -" + i);
		}

		// traversing through forEach method of Iterable with anonymous class
		myList.forEach(new Consumer<Integer>() {
			@Override
			public void accept(Integer t) {
				System.out.println("forEach anonymous class Value -" + t);
			}

		});

		// traversing through forEach method of Iterable with lambda expression
		myList.forEach((t) -> {
			System.out.println("forEach lambda Value -" + t);
		});

		// traversing with Consumer interface implementation
		MyConsumer action = new MyConsumer();
		myList.forEach(action);

		// removeIf
		myList.removeIf((t) -> t % 2 == 0);
		System.out.println(myList);

		// forEachRemaining
		Iterator<Integer> a = myList.iterator();
		a.forEachRemaining(t -> {
			System.out.println("Consumer impl Value- " + t * 2);
		});

		// ConcurrentHashMap

		ConcurrentHashMap<String, Integer> map = new ConcurrentHashMap<>();
		map.put("a", 1);
		map.put("b", 2);
		map.put("c", 3);
		map.put("d", 4);
		map.put("e", 5);
		map.put("f", 6);
		map.put("g", 7);
		map.put("h", 8);
		map.put("i", 9);
		map.put("j", 10);
		map.put("k", 11);
		map.put("l", 12);

		map.forEach(3, (x, y) -> {
			System.out.println("forEach " + (x + y));
		});

		map.forEachEntry(3, x -> {
			System.out.println("forEachEntry " + x);
		});

		map.forEachKey(3, x -> {
			System.out.println("forEachKey " + x);
		});

		map.forEachValue(3, x -> {
			System.out.println("forEachValue " + x);
		});

	}

}

// Consumer implementation that can be reused
class MyConsumer implements Consumer<Integer> {

	public void accept(Integer t) {
		System.out.println("Consumer impl Value- " + t);
	}

}
