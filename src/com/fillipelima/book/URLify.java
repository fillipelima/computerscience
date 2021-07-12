package com.fillipelima.book;

public class URLify {
	
	public static void main(String[] args) {
		System.out.println(urlify("Mr John Smith    ", 13));
	}
	
	public static String urlify(String s, int trueLength) {
		char[] array = s.toCharArray();
		for (int i = 0; i < trueLength; i++) {
			if (array[i] == ' ') {
				shift(array, i, trueLength);
				array[i] = '%';
				array[i+1] = '2';
				array[i+2] = '0';
				trueLength++;
				trueLength++;
				i++;
				i++;
			}
		}
		return new String(array);
	}
	
	private static void shift(char[] array, int i, int trueLength) {
		for (int j = trueLength+1; j-2 > i; j--) {
			array[j] = array[j-2];
			array[j-1] = array[j-3];
		}
	}
}
