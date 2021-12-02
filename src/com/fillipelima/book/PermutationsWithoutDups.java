package com.fillipelima.book;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/*
 * Permutations without Dups: 
 * Write a method to compute all permutations of a string of unique characters.
 */
public class PermutationsWithoutDups {
	
	public static void main(String[] args) {
		System.out.println("Brute Force           :" + new PermutationsWithoutDups().compute("abcd"));
		System.out.println("Recursive with Java 8+:" + new PermutationsWithoutDups().recursive("abcd"));
	}
	
	// Brute Force
	public List<String> compute(String s) {
		List<String> list = new ArrayList<String>();
		for (int i = 0; i < s.length(); i++) {
			String a = String.valueOf(s.charAt(i));
			List<String> newPermutations = new ArrayList<String>();
			for (String e : list) {
				newPermutations.add(e+a);
			}
			list.addAll(newPermutations);	
			list.add(a);						
		}
		return list;
	}
	
	// Recursive with Jaba 8
	public List<String> recursive(String s) {
		List<String> list = new ArrayList<String>();				
		helper(s, list);
		return list;
	}
	
	private void helper(String s, List<String> list) {
		if (s.length() == 0)
			return;
		List<String> newPermutation = list.stream().map(e -> e + String.valueOf(s.charAt(0)) ).collect(Collectors.toList());
		list.addAll(newPermutation);		
		list.add(String.valueOf(s.charAt(0)));
		
		helper(s.length()==1 ? "" : s.substring(1), list);
	}
	
	
	// Best time / space complexity
	
	
}
