package com.fillipelima.binarysearchtree;

public class ContainsDuplicateIII {
	
	public static void main(String[] args) {
		ContainsDuplicateIII c = new ContainsDuplicateIII();
		int[] nums = new int[2];
		nums[0] = -2147483648;
		nums[1] =  2147483647;
		boolean r = c.containsNearbyAlmostDuplicate(nums, 1, 1);
		System.out.println(r);
	}
	
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        for (int i = 0; i < nums.length; i++) {
            long a = nums[i];
            for (int j = 0; j < nums.length; j++) {
                if (i == j)
                    continue;
                long b = nums[j];
                if ((Math.abs(a-b) <= t) && (Math.abs(i-j) <= k)) {
                    return true;
                }
            } 
        }
        return false;
    }
}
