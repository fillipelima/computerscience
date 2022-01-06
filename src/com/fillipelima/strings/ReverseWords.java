package com.fillipelima.strings;

/**
 * https://practice.geeksforgeeks.org/problems/reverse-words-in-a-given-string5459/1/
 * 
 * Given a String S, reverse the string without reversing its individual words.
 * Words are separated by dots.
 * 
 * Input: 
 * 
 * S = i.like.this.program.very.much 
 * 
 * Output:
 * 
 * much.very.program.this.like.i Explanation: After reversing the whole
 * string(not individual words), the input string becomes
 * much.very.program.this.like.i
 * 
 * @author Fillipe Lima
 *
 */
public class ReverseWords {
	
	public static String reverseWords(String S) {
		StringBuilder sb = new StringBuilder();
		String[] array = S.split("\\.");
		for (int i = array.length - 1; i >= 0; i--) {
			sb.append(array[i]);
			if (i > 0)
				sb.append(".");
		}
		return sb.toString();
	}
	
	public static void main(String[] args) {
		System.out.println(ReverseWords.reverseWords("much.very.program.this.like.i"));
	}
}
