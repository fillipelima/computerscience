package com.fillipelima.arrays;

public class RemoveElement {
    public int removeElement(int[] nums, int val) {
        // remaining elements in the array
        int r = nums.length;
        int i = 0;
        boolean shifted = false;
        while (i < r) {
            shifted = false;
            if (val == nums[i]) {
                if (i < r-1) {
                    shift(nums, i, r);    
                    shifted = true;
                }                    
                r--;
            }
            if (!shifted)
                i++;
        }
        return r;
    }
    private void shift(int[] nums, int i, int r) {
        for (int j = i; j < r-1; j++) {
            nums[j] = nums[j+1];
        }
    }
}
