package com.fillipelima.arrays;

import java.util.ArrayList;
import java.util.List;

/**
 * Days forecast for camping
 * 
 * Input: [3,2,2,2,3,4], 2 Output: [3, 4]
 *
 * @author Fillipe Lima
 *
 */
public class DaysForecast {
	public static List<Integer> find(int[] prediction, int k) {
		List<Integer> ans = new ArrayList<Integer>();
		int[] nonIncreasingDaysBefore = new int[prediction.length];
		int[] nonDecreasingDaysAfter = new int[prediction.length];

		// For each day count days before that are non-increasing
		int count = 0;
		for (int i = 0; i < prediction.length; i++) {
			// First element or there is a Increase
			if (i == 0 || prediction[i] > prediction[i - 1])
				count = 0;
			// There is a Non-increase
			else
				count++;
			nonIncreasingDaysBefore[i] = count;
		}
		// For each day count days after that are non-decreasing
		count = 0;
		for (int i = prediction.length - 1; i >= 0; i--) {
			// Last element or there is a Decrease
			if (i == prediction.length - 1 || prediction[i] > prediction[i + 1])
				count = 0;
			// There is a Non-Decrease
			else
				count++;
			nonDecreasingDaysAfter[i] = count;
		}
		// Check day with k days good before and k days good after
		for (int i = k; i < prediction.length-k; i++) {
			if (nonIncreasingDaysBefore[i] >= k && nonDecreasingDaysAfter[i] >= k) {
				ans.add(i + 1);
			}
		}
		return ans;
	}

	public static void main(String... args) {
		System.out.println("Input: [3, 2, 2, 2, 3, 4], Expected: [3, 4], Actual: " + find(new int[] { 3, 2, 2, 2, 3, 4 }, 2));
		System.out.println("Input: [1, 0, 1, 0, 1], Expected: [2, 4], Actual: " + find(new int[] { 1, 0, 1, 0, 1 }, 1));
		System.out.println("Input: [1, 0, 0, 0, 1], Expected: [3], Actual: " + find(new int[] { 1, 0, 0, 0, 1 }, 2));
		System.out.println("Input: [1, 1, 1, 1, 1, 1, 1, 1, 1, 1],  Expected: [4, 5, 6, 7], Actual: " + find(new int[] { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 }, 3));
	}
}
