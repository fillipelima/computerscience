package com.fillipelima.book;

public class Fibonacci {
	
	public static void main(String[] args) {
		System.out.println("-- begin --");
		System.out.println(fib(100));
		System.out.println("-- end --");
	}

	static int fib(int n) {
		if (n <= 0)
			return 0;
		else if (n == 1)
			return 1;
		return fib(n - 1) + fib(n - 2);
	}

}
