package com.fillipelima.book;

import java.util.ArrayList;

/*
 * Permutations without Dups: 
 * Write a method to compute all permutations of a string of unique characters.
 * 
 * abc -> abc bac bca cba cab acb  	
 * 
 */
public class PermutationsWithoutDups {
	
	public static void main(String[] args) {
		System.out.println(new PermutationsWithoutDups().getPerms("abc"));
	}

	public ArrayList<String> getPerms(String str) {
		if (str == null)
			return null;
		ArrayList<String> permutations = new ArrayList<String>();
		if (str.length() == 0) {// base case
			permutations.add("");
			return permutations;
		}

		char first = str.charAt(0); // get the first char
		String remainder = str.substring(1); // remove the first char
		ArrayList<String> words = getPerms(remainder);
		for (String word : words) {
			for (int j = 0; j <= word.length(); j++) {
				String s = insertCharAt(word, first, j);
				permutations.add(s);
			}
		}
		return permutations;
	}

	/* Insert char c at index i in word. */
	String insertCharAt(String word, char c, int i) {
		String start = word.substring(0, i);
		String end = word.substring(i);
		return start + c + end;
	}

}
