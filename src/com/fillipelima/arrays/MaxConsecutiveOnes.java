package com.fillipelima.arrays;

public class MaxConsecutiveOnes {
	
	public static void main(String[] args) {
		System.out.println(findMaxConsecutiveOnes(new int[] {1,0,1,1,0}));
	}
	
    public static int findMaxConsecutiveOnes(int[] nums) {
    	if (nums.length < 2) return nums.length;
    	int countBeforeZero = 0;
        int countAfterZero = 0;
        int max = 0;
        boolean flipped = false;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                if (!flipped)
                    countBeforeZero++;
                else
                    countAfterZero++;
            }
            if (nums[i] == 0 && !flipped) {
                flipped = true;
                countBeforeZero++;
                if ((countBeforeZero + countAfterZero) > max)
                    max = countBeforeZero + countAfterZero;                  
                continue;
            }
            if (nums[i] == 0 && flipped) {
                countBeforeZero = countAfterZero + 1;
                countAfterZero = 0;                     
            }                      
            if ((countBeforeZero + countAfterZero) > max)
                max = countBeforeZero + countAfterZero;             
        }  
        return max;
    }
}
