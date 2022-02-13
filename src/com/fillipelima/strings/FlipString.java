package com.fillipelima.strings;

/**
 * 
 * A binary string is monotone increasing if it consists of some number of 0's
 * (possibly none), followed by some number of 1's (also possibly none).
 * 
 * You are given a binary string s. You can flip s[i] changing it from 0 to 1 or
 * from 1 to 0.
 * 
 * Return the minimum number of flips to make s monotone increasing.
 *
 * Approach: In this algorithm, I traverse the entire String and count how many
 * ones appeared in total and how many flips is necessary after finding the
 * first 'one' in the sequence. The amount of flips are determined by total amount
 * of zeros, but if at any time the amount of zeros is greater than amount of
 * ones, better flip the amount of ones found so far. 
 * 
 * Time complexity: O(n) linear, as the algorithm is taking only one pass
 * Space complexity: O(1) constant, as the algorithm is using constant memory with two variables
 * 
 * @author Fillipe Lima
 *
 */
public class FlipString {
	public int minFlipsMonoIncr(String s) {
		int ones = 0;
		int flips = 0;
		// Traverse String chars
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == '1') {
				ones++;
				// Only increment flips (zeros) after finding the first '1' in the char sequence
			} else if (ones > 0) {
				flips++;
			}
			// If the amount of flips (zeros) found so far is greater than amount of ones
			// found, we
			// better consider the ones flip instead of zeros flip, so we update the value
			// of flips to the ones count.
			flips = Math.min(flips, ones);
		}
		return flips;
	}
}
