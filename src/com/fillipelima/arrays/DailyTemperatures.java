package com.fillipelima.arrays;

import java.util.Arrays;
import java.util.Stack;

/**
 * Given an array of integers temperatures represents the daily temperatures,
 * return an array answer such that answer[i] is the number of days you have to
 * wait after the ith day to get a warmer temperature. If there is no future day
 * for which this is possible, keep answer[i] == 0 instead.
 * 
 * 
 * @author Fillipe Lima
 *
 */
public class DailyTemperatures {
	
	// Using monotonic stack
	public static int[] find(int[] temperatures) {
		int[] ans = new int[temperatures.length];
		Stack<int[]> stack = new Stack<int[]>();
		// Go backwards
		for (int i = temperatures.length - 1; i >= 0; i--) {
			while (!stack.isEmpty() && stack.peek()[0] <= temperatures[i]) {
				stack.pop();
			}
			ans[i] = stack.isEmpty() ? 0 : stack.peek()[1] - i;
			stack.push(new int[] { temperatures[i], i });
		}
		return ans;
	}
	
	private static String printArray(int[] arr) {
		StringBuilder sb = new StringBuilder(); 
		sb.append("[");
		Arrays.stream(arr).forEach(e -> sb.append(e + ","));
		sb.replace(sb.length()-1, sb.length(), "]");
		return sb.toString();
	}
	
	public static void main(String[] args) {
		System.out.println("Input: [73,74,75,71,69,72,76,73]" + " Expected: " + "[1,1,4,2,1,1,0,0]" + " Actual: " + printArray(DailyTemperatures.find(new int[] {73,74,75,71,69,72,76,73})));
	}
}
