package com.fillipelima.general;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

public class WordOccurrence {
	class MutableInteger {
		private int i = 0;
		void increment() {
			i++;
		}
		public int getValue() {
			return i;
		}
		public boolean equals(Object o) {
			return i == ((MutableInteger) o).getValue();
		}
		public int hashCode() {
			return Objects.hash(i);
		}
	}
	public static void parallelStream(String s) {
		s = s.replaceAll("[^a-zA-Z0-9\\s+]", "");
		
		Map<String, Integer> map = new ConcurrentHashMap<String, Integer>();
		
		Arrays.stream(s.split("\\s+")).parallel().forEach( word -> {
			map.compute(word, (k, v) -> v == null ? 1 : v + 1);
			System.out.println("Thread: " + Thread.currentThread().getName());
			});
		
		System.out.println("");
		System.out.println("Result: ");
		System.out.println("");
		
		// Sort by Most occurrences and natural order of words
		map.entrySet().stream().sorted(Comparator.comparing(Map.Entry<String, Integer>::getValue).reversed().thenComparing(Map.Entry<String, Integer>::getKey)).forEach(e -> System.out.println(e));
	}
	
	public static void parallelThreads(String s) {
		Thread t1 = new Thread(() -> {
			
		});
	}
	
	public static void test() {
		
	}
	
	public static void main(String[] args) {
		WordOccurrence.parallelStream("Hi, my name is Lima. Hi, my name is Fillipe. Hi, my name is Lima. Hi, my name is Fillipe. Hi, my name is Lima. Hi, my name is Fillipe. Hi, my name is Lima. Hi, my name is Fillipe. Hi, my name is Lima. Hi, my name is Fillipe. Hi, my name is Lima. Hi, my name is Fillipe. Hi, my name is Lima. Hi, my name is Fillipe. Hi, my name is Lima. Hi, my name is Fillipe. Hi, my name is Lima. Hi, my name is Fillipe. Hi, my name is Lima. Hi, my name is Fillipe.");
	}
}
