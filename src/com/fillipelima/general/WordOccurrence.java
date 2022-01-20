package com.fillipelima.general;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class WordOccurrence {
	public static void parallelStream(String s) {
		
		s = s.replaceAll("[^a-zA-Z0-9\\s+]", "");
		Map<String, Integer> map = new HashMap<String, Integer>();
		Arrays.stream(s.split("\\s+")).parallel().forEach( word -> {
			map.put(word, map.getOrDefault(word, 0)+1);
			System.out.println("Thread: " + Thread.currentThread().getName());});
		
		System.out.println("");
		System.out.println("Result: ");
		System.out.println("");
		
		// Sort by Most occurrences and natural order of words
		map.entrySet().stream().sorted(Comparator.comparing(Map.Entry<String, Integer>::getValue).reversed().thenComparing(Map.Entry<String, Integer>::getKey)).forEach(e -> System.out.println(e));
	}
	public static void main(String[] args) {
		WordOccurrence.parallelStream("Hi, my name is Lima. Hi, my name is Fillipe.");
	}
}
