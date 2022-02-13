package com.fillipelima.general;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Given an array of strings words and an integer k, return the k most frequent
 * strings.
 * 
 * Return the answer sorted by the frequency from highest to lowest. Sort the
 * words with the same frequency by their lexicographical order.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: words = ["i","love","leetcode","i","love","coding"], k = 2 Output:
 * ["i","love"] Explanation: "i" and "love" are the two most frequent words.
 * Note that "i" comes before "love" due to a lower alphabetical order.
 * 
 * 
 * 
 * @author Fillipe Lima
 *
 */
public class TopKFrequent {
	public List<String> topKFrequent(String[] words, int k) {
		// Map to store words and number of occurence
		Map<String, Integer> map = new HashMap<String, Integer>();

		// Result list
		List<String[]> list = new ArrayList<String[]>();

		// Build the map
		for (String s : words)
			map.put(s, map.getOrDefault(s, 0) + 1);

		// Build the result list
		for (Map.Entry<String, Integer> e : map.entrySet())
			list.add(new String[] { e.getKey(), String.valueOf(e.getValue()) });

		Collections.sort(list, (a, b) -> a[1].equals(b[1]) ? a[0].compareTo(b[0])
				: -Integer.valueOf(a[1]).compareTo(Integer.valueOf(b[1])));

		return list.stream().map(v -> v[0]).limit(k).collect(Collectors.toList());
	}
	
	// With Streams
    public int[] topKFrequentWithStream(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        Arrays.stream(nums).forEach(e -> map.put(e, map.getOrDefault(e, 0)+1));
        return map.entrySet().stream().sorted(Comparator.comparing(Map.Entry<Integer, Integer>::getValue).reversed()).mapToInt(x -> x.getKey()).limit(k).toArray();
    }
}
