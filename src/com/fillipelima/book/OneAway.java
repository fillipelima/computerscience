package com.fillipelima.book;

public class OneAway {
	
	public static void main(String[] args) {
		System.out.println(check("pale", "bale"));
	}
	
	public static boolean check(String s1, String s2) {
		if (s1.equals(s2))
			return false;
		if (s1.length() == s2.length())
			return checkReplace(s1, s2);
		else if (s1.length() > s2.length())
			return checkInsert(s1, s2);
		else
			return checkInsert(s2, s1);
	}
	
	private static boolean checkReplace(String s1, String s2) {
		int count = 0;
		for (int i = 0; i < s1.length(); i++) {
			if (s1.charAt(i) != s2.charAt(i) ) {
				count++;
			}
		}
		return count == 1;
	}
	
	private static boolean checkInsert(String s1, String s2) {
		int i = 0;
		int j = 0;
		int count = 0;
		while (i < s1.length() && count < 2) {
			if (j >= s2.length() || s1.charAt(i) != s2.charAt(j)) 
				count++;
			else 
				j++;			
			i++;
		}
		return count == 1;
	}	
	
}
