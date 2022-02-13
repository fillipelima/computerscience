package com.fillipelima.arrays;
/**
 * 
 * @author Fillipe Lima
 *
 */
public class MissingNumber {
    public int missingNumber(int[] nums) {
        int sum1 = 0;
        int sum2 = 0;
        for (int i = 0; i <= nums.length; i++) {
            sum1 += i;
            if (i < nums.length)
                sum2 += nums[i];
        }
        return sum1 - sum2;
    }
}
