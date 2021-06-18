package com.fillipelima.arrays;

public class MaxConsecutiveOnes {
	
	public static void main(String[] args) {
		findMaxConsecutiveOnes(new int[] {1,0,1,1,0,1});
	}
	
    public static int findMaxConsecutiveOnes(int[] nums) {
        int count = 0;
        int max = 0;
        for (int i : nums) {
            if (i == 1) {
                count++;
                if (count > max)
                    max = count;
            }else{
                count = 0;
            }            
        }
        return max;
    }
}
