package com.fillipelima.arrays;

public class SortArrayByParity {
	
	public static void main(String[] args) {
		System.out.println(sortArrayByParity(new int[] {0,1, 2}));
	}
	
    public static int[] sortArrayByParity(int[] nums) {
        int l = nums.length;
        int i = 0;
        while (i < l) {
            // odd
            if (i+1!=nums.length && nums[i] % 2 != 0) {
                int aux = nums[i];
                shift(nums, i);
                nums[l-1] = aux;
                l--;
            }else{
                i++;
            }
        }
        return nums;
    }
    private static void shift(int[] nums, int i) {
        for (int j = 0; j < nums.length-1; j++) {
            nums[j] = nums[j+1];
        }
    }
}
