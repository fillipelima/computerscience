package com.fillipelima.book;

import java.util.Arrays;

public class ThirdMax {
	
	public static void main(String[] args) {
		thirdMax(new int[] {1,2});
	}
	
	public static int thirdMax(int[] nums) {
        if (nums.length == 1)
            return nums[0];
        Arrays.sort(nums);
        Integer[] third = new Integer[3];
        int count = 2;
        for (int i = nums.length-1; i >= 0 && count >= 0; i--) {
            if (i == nums.length-1) {
                third[count] = nums[i];
                count--;
                continue;
            }
            if (nums[i] != nums[i+1]) {
                third[count] = nums[i];
                count--;
            }
        }
        if (count == -1)
            return third[count+1];
        else
            return third[2];
    }
}
