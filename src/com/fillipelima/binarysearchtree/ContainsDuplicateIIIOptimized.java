	package com.fillipelima.binarysearchtree;

import java.util.TreeSet;

public class ContainsDuplicateIIIOptimized {
	
	public static void main(String[] args) {
		ContainsDuplicateIIIOptimized c = new ContainsDuplicateIIIOptimized();
		int[] nums = new int[2];
		nums[0] = -2147483648;
		nums[1] =  2147483647;
		boolean r = c.containsNearbyAlmostDuplicate(nums, 1, 1);
		System.out.println(r);
	}
	
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        TreeSet<Integer> treeSet = new TreeSet<>();
        for (int i = 0; i < nums.length; i++) {
            Integer low = treeSet.floor(nums[i]);
            Integer high = treeSet.ceiling(nums[i]);
            if ((low != null && (long) nums[i] - low <= t) || (high != null && (long) high - nums[i] <= t)) {
                return true;
            }
            treeSet.add(nums[i]);
            if (i >= k) {
                treeSet.remove(nums[i - k]);
            }
        }
        return false;   
    }
}
