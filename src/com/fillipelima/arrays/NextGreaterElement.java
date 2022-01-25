package com.fillipelima.arrays;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

/**
 * You are given two arrays (without duplicates): nums1nums1 and nums2nums2
 * where nums1nums1’s elements are subset of nums2nums2. Find all the next
 * greater numbers for nums1nums1's elements in the corresponding places of
 * nums2nums2.
 * 
 * The Next Greater Number of a number xx in nums1nums1 is the first greater
 * number to its right in nums2nums2. If it does not exist, output \text{-1}-1
 * for this number.
 * 
 * 
 * @author Fillipe Lima
 *
 */
public class NextGreaterElement {
	public static int[] find(int[] nums1, int[] nums2) {
		int[] ans = new int[nums1.length];
		List<Integer> listNums1 = Arrays.stream(nums1).boxed().collect(Collectors.toList());
		Stack<Integer> stack = new Stack<Integer>();
		for (int i = nums2.length - 1; i >= 0; i--) {
			while (!stack.isEmpty() && stack.peek() <= nums2[i])
				stack.pop();
			int indexOf = listNums1.indexOf(nums2[i]);
			if (indexOf >= 0)
				ans[indexOf] = stack.isEmpty() ? -1 : stack.peek();
			stack.push(nums2[i]);
		}
		return ans;
	}
	
    public static int[] findUsingMap(int[] nums1, int[] nums2) {
        int[] ans = new int[nums1.length];
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        AtomicInteger index = new AtomicInteger();
        Arrays.stream(nums1).forEach(e -> map.put(e, index.getAndIncrement()));
        Stack<Integer> stack = new Stack<Integer>();
        for (int i = nums2.length-1; i >= 0; i--) {        
            while (!stack.isEmpty() && stack.peek() <= nums2[i])
                stack.pop();
            Integer indexOf = map.get(nums2[i]);
            if (indexOf != null)
                ans[indexOf] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(nums2[i]);
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
		System.out.println("Input: [4,1,2] [1,3,4,2]" + " Expected: " + "[-1,3,-1]" + " Actual: " + printArray(NextGreaterElement.find(new int[] {4, 1, 2}, new int[] {1,3, 4, 2})));
		System.out.println("Input: [4,1,2] [1,3,4,2]" + " Expected: " + "[-1,3,-1]" + " Actual: " + printArray(NextGreaterElement.findUsingMap(new int[] {4, 1, 2}, new int[] {1,3, 4, 2})));
	}
}
