package com.fillipelima.strings;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class SmallestDistinctWindow {
	public String findSubString(String str) {
		char[] arr = str.toCharArray();
		Set<Character> set = new HashSet<Character>();
		for (char c : arr) {
			set.add(c);
		}

		String min = null;
		List<Character> list = new ArrayList<Character>();
		int p1 = 0;
		int p2 = 0;
		while (p1 < arr.length && p2 < arr.length) {
			list.add(arr[p2]);
			if (list.containsAll(set)) {
				String s = list.stream().map(String::valueOf).collect(Collectors.joining());
				list.clear();
				p2 = p1++;
				if (min == null || s.length() < min.length()) {
					min = s;
				}
			} else {
				p2++;
			}
		}
		return min;
	}
	
	// Min Window
	public static String minWindow(String s, String t) {
		char[] arr = s.toCharArray();
		List<Character> dictionary = new ArrayList<Character>();
		for (char c : t.toCharArray())
			dictionary.add(c);
			
        String min = null;
		List<Character> currentWindow = new ArrayList<Character>();
		int p1 = 0;
		int p2 = 0;
		while (p1 < arr.length && p2 < arr.length) {
			currentWindow.add(arr[p2]);
			if (listContainsAll(currentWindow, dictionary)) {
				String str = currentWindow.stream().map(String::valueOf).collect(Collectors.joining());
				currentWindow.clear();
				p2 = ++p1;
				if (min == null || str.length() < min.length()) {
					min = str;
				}
			} else {
				p2++;
			}
		}
		return min == null ? "" : min;        
    }
	
	private static boolean listContainsAll(List<Character> window, List<Character> dictionary) {
		List<Character> w = new ArrayList<Character>(window);
		w.retainAll(dictionary);		
		if (w.size() < dictionary.size())
			return false;
		Map<Character, Integer> map = new HashMap<Character, Integer>();
		for (Character c : window)
			map.put(c, map.getOrDefault(c, 0)+1);
		
		for (Character c : dictionary) {
			if (!map.containsKey(c))
				return false;
			int count = map.get(c) - 1; 
			if (count == -1)
				return false;
			map.put(c, count);	
		}
		return true;
			
	}
	
	public static void main(String[] args) {
		System.out.println(SmallestDistinctWindow.minWindow("ADOBECODEBANC", "ABC"));
	}
}
