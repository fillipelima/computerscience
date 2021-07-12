package com.fillipelima.book;

public class CheckPermutation {
	
	public static void main(String[] args) {
		System.out.println(checkPermutation("abc", "cbda"));
	}
	
	public static boolean checkPermutation(String s1, String s2) {
		int sumCharS1 = 0;
		
		for (int i = 0; i < s1.length(); i++) {
			sumCharS1 += s1.charAt(i);
		}
		
		int sumCharS2 = 0;
		
		for (int i = 0; i < s2.length(); i++) {
			sumCharS2 += s2.charAt(i);
		}		
		
		return sumCharS1 == sumCharS2;
		
	}
}
