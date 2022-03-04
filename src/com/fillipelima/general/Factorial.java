package com.fillipelima.general;

import java.math.BigDecimal;

public class Factorial {

	public static BigDecimal calcIterative(int n) {
		BigDecimal result = new BigDecimal(1);
		for (int i = 2; i <= n; i++) {
			result = result.multiply(BigDecimal.valueOf(i));
		}
		return result;
	}
	
	public static BigDecimal calcRecursive(int n) {
		if (n == 1)
			return BigDecimal.valueOf(1);
		return BigDecimal.valueOf(n).multiply(calcRecursive(n-1));
	}
	
	public static void main(String[] args) {
		System.out.println(Factorial.calcIterative(80000).toString());
		System.out.println(Factorial.calcRecursive(80000));
	}
}
