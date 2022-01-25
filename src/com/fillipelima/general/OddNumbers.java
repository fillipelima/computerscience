package com.fillipelima.general;

import java.util.List;

public class OddNumbers {

	public static void findOddsStream(List<Integer> list) {
		list.stream().filter(n -> n % 2 != 0).forEach( n -> System.out.println(n));
	}
	
	public static void findOddsIterative(List<Integer> list) {
		int count = 0;
		for (Integer n : list) 
			if (n % 2 != 0)
				count = count + 1;
		System.out.println(count);
	}
	
	public static void main(String[] args) {
		OddNumbers.findOddsStream(List.of(1, 2, 3, 4, 5, 6, 7, 8, 9));
		OddNumbers.findOddsIterative(List.of(1, 2, 3, 4, 5, 6, 7, 8, 9));
	}
}
