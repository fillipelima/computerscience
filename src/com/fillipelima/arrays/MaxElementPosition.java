package com.fillipelima.arrays;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Given an array of integers, return the position of the maximum element. If
 * the maximum element occurs multiple times, use a random number generator to
 * choose one of the positions uniformly at random.
 * 
 * [-1, 9, 3, 9, 4, 5, 9, 1]
 *  
 * 
 * @author Fillipe Lima
 *
 */

public class MaxElementPosition {

	public static int find(int[] a) {
		if (a == null || a.length == 0)
			return -1;
		int max = Integer.MIN_VALUE;
		List<Integer> list = new ArrayList<Integer>();
		for (int i = 0; i < a.length; i++) {
			if (a[i] > max) {
				max = a[i];
				list.clear();
				list.add(i);
			}else if (a[i] == max) {
				list.add(i);
			}
		}
		Random r = new Random();
		return list.get(r.nextInt(list.size()));
	}

	public static void main(String[] args) {
		System.out.println(MaxElementPosition.find(new int[] {-1, 9, 3, 9, 4, 5, 9, 1}));
	}
	
}
