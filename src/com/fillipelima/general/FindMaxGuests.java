package com.fillipelima.general;

import java.util.Map;
import java.util.TreeMap;

/**
 * 
 * Consider a big party where N guests came to it and a log register for guest’s
 * entry and exit times was maintained. Find the minimum time at which there
 * were maximum guests at the party. Note that entries in the register are not
 * in any order.
 * 
 * Note: Guests are leaving after the exit times.
 * 
 * Example 1:
 * 
 * Input: N = 5 Entry= {1, 2,10, 5, 5} Exit = {4, 5, 12, 9, 12} Output: 3 5
 * Explanation: At time 5 there were guest number 2, 4 and 5 present.
 * 
 * https://practice.geeksforgeeks.org/problems/maximum-intervals-overlap5708/1/#
 * 
 * @author Fillipe Lima
 *
 */
public class FindMaxGuests {
	public int[] findMaxGuests(int[] Entry, int Exit[], int N) {
		Map<Integer, Integer> map = new TreeMap<Integer, Integer>();
		for (int i = 0; i < N; i++) {
			map.put(Entry[i], map.getOrDefault(Entry[i], 0) + 1);
			map.put(Exit[i] + 1, map.getOrDefault(Exit[i] + 1, 0) - 1);
		}
		int[] ans = new int[2];
		int count = 0;
		for (Map.Entry<Integer, Integer> e : map.entrySet()) {
			count = count + e.getValue();
			if (count > ans[0]) {
				ans[0] = count;
				ans[1] = e.getKey();
			}
		}
		return ans;
	}
}
