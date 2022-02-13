package com.fillipelima.arrays;

/**
 * 
 * Problem Statement: Find a subarray of maximum length such that the product of
 * all the elements in the subarray is 1.
 * 
 * Sample input: array size: n = 6 array = [1, -1, -1, -1, 1, 1]
 * 
 * Sample output: 4
 * 
 * Explanation: These are a few of the subarrays whose product is equal to 1:
 * Subarray with indices from (0,2), length of the subarray is 3 Subarray with
 * indices from (1,2), length of the subarray is 2 Subarray with indices from
 * (2,5), length of the subarray is 4 Subarray with indices from (4,5), length
 * of the subarray is 2
 * 
 * Approach: In this algorithm, I traverse the entire array counting how many
 * negatives appears and record its first index. I also record the general
 * starting index as when it reaches zero, it's necessary to start count from
 * there. Each iteration I check if there is even or odd number of negatives and
 * update max according to start index (when even) or first negative index (when odd).
 * 
 * @author Fillipe Lima
 *
 */
public class SubArrayOfMaxLength {
	public int getMaxLen(int[] nums) {
		int startIndex = 0;
		int firstNegativeIndex = 0;

		int negativeCount = 0;

		int max = 0;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] < 0) {
				negativeCount++;
				if (negativeCount == 1)
					firstNegativeIndex = i;
			} else if (nums[i] == 0) {
				startIndex = i + 1;
				negativeCount = 0;
				continue;
			}
			// Even amount of negative, time to update max if current length is greater
			if (negativeCount % 2 == 0) {
				max = Math.max(max, i - startIndex + 1);
				// Odd amount of negatives, check if current length since first negative is
				// greater than max
			} else {
				max = Math.max(max, i - firstNegativeIndex);
			}
		}
		return max;
	}
}
