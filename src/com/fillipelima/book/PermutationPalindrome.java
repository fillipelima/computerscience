package com.fillipelima.book;

public class PermutationPalindrome {
	
	public static void main(String[] args) {
		System.out.println(isPermutationOfPalindrome("tactcoa"));
	}
	
	public static boolean isPermutationOfPalindrome(String s) {		
		int bitVec = createBitVector(s);
		return checkAtMostOneBit(bitVec);
	}
	
	private static int createBitVector(String s) {
		int bitVec = 0;
		for (int i = 0; i < s.length(); i++) {
			bitVec = toggle(bitVec, s.charAt(i));
		}
		return bitVec;
	}
	
	private static int toggle(int bitVec, char c) {
		int charPosition = 1 << c - 'a';
		if ((bitVec & charPosition) == 0)
			bitVec |= charPosition;
		else 
			bitVec &= ~charPosition;
		return bitVec;
	}
	
	private static boolean checkAtMostOneBit(int bitVec) {
		return (bitVec & (bitVec - 1)) == 0;
	}
	
}
