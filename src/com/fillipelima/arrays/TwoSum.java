package com.fillipelima.arrays;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 * Given an array of integers nums and an integer target, return indices of the
 * two numbers such that they add up to target.
 * 
 * You may assume that each input would have exactly one solution, and you may
 * not use the same element twice.
 * 
 * You can return the answer in any order.
 * 
 * @author Fillipe Lima
 *
 */
public class TwoSum {
	public int[] twoSum(int[] nums, int target) {
		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < nums.length; i++) {
			int x = target - nums[i];
			if (map.containsKey(x)) {
				return new int[] { i, map.get(x) };
			}
			map.put(nums[i], i);
		}
		return null;
	}
}
