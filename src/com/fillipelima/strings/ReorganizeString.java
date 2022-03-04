package com.fillipelima.strings;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 
 * Given a string s, rearrange the characters of s so that any two adjacent
 * characters are not the same.
 * 
 * Return any possible rearrangement of s or return "" if not possible.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: s = "aab" Output: "aba" Example 2:
 * 
 * Input: s = "aaab" Output: ""
 * 
 * 
 * https://leetcode.com/problems/reorganize-string/
 * 
 * @author Fillipe Lima	
 *
 */
public class ReorganizeString {
	public String reorganizeString(String s) {

		Map<Character, Integer> map = new HashMap<Character, Integer>();

		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			map.put(c, map.getOrDefault(c, 0) + 1);
		}

		char[] arr = new char[s.length()];

		List<Map.Entry<Character, Integer>> list = map.entrySet().stream()
				.sorted(Comparator.comparing(Map.Entry<Character, Integer>::getValue).reversed()).toList();

		Map.Entry<Character, Integer> e = list.get(0);
		if (e.getValue() > (s.length() + 1) / 2)
			return "";

		// Setup the odds indexes
		int k = 0;
		for (int j = 0; j < e.getValue(); j++) {
			arr[k] = e.getKey();
			k += 2;
		}

		// Fill the rest of array
		for (int l = 1; l < list.size(); l++) {
			e = list.get(l);
			for (int j = 0; j < e.getValue(); j++) {
				if (k >= s.length())
					k = 1;
				arr[k] = e.getKey();
				k += 2;
			}
		}

		return String.valueOf(arr);
	}
}
