package com.fillipelima.general;

public class FibonacciNumber {
	public static int calculateRecursive(int N) {
		if (N <= 1) {
			return N;
		}
		return calculateRecursive(N - 1) + calculateRecursive(N - 2);
	}
	public static void main(String[] args) {
		System.out.println(FibonacciNumber.calculateRecursive(4));
	}
}
