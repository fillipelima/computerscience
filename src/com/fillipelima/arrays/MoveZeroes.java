package com.fillipelima.arrays;

public class MoveZeroes {
    public void moveZeroes(int[] nums) {
        int i = 0;
        int l = nums.length;
        while (i < l) {
            if (nums[i] == 0) {
                shift(nums, i);
                l--;
            }else{
                i++;
            }
        }
        fillZeroes(nums, nums.length-l);
    }
    
    private void shift(int[] nums, int i) {
        for (int j = i; j < nums.length-1; j++) {
            nums[j] = nums[j+1];
        }
    }
    
    private void fillZeroes(int[] nums, int count) {
        while (count > 0) {
            nums[nums.length-count] = 0;
            count--;
        }
    }
}
