package com.fillipelima.book;

public class StringCompression {

	public static void main(String[] args) {
		System.out.println(compress("aaabbbbcccccce"));
	}

	public static String compress(String s) {
		int count = 1;
		String r = "";
		for (int i = 0; i < s.length(); i++) {
			if (i + 1 < s.length()) {
				if (s.charAt(i) == s.charAt(i + 1)) {
					count++;
				} else {
					if (count > 1) {
						r = r + s.charAt(i) + count;						
					}else {
						r = r + s.charAt(i);
					}
					count = 1;					
				}
			}else {
				r = r + s.charAt(i);
			}
		}
		return r;
	}
}
