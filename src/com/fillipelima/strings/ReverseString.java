package com.fillipelima.strings;

/**
 * 
 * Input:
 * String s = abcdef 
 * 
 * Output:
 * char array -> [a,b,c,d,e,f] -> [f,b,c,d,e,a]  -> [f,e,d,c,b,a] 
 *  
 * 
 * @author Fillipe Lima
 *
 */
public class ReverseString {

	static String reverseInPlace(String s) {
		char[] arr = s.toCharArray();
		int p1 = 0;
		int p2 = arr.length-1;
		while (p1 < p2) {
			char aux = arr[p1];
			arr[p1] = arr[p2];
			arr[p2] = aux;
			p1++;
			p2--;
		}
		return String.valueOf(arr);
	}
	public static void main(String[] args) {
		System.out.println(reverseInPlace("abcdefghi"));
	}
}
