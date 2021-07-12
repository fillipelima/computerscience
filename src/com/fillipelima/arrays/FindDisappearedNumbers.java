package com.fillipelima.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindDisappearedNumbers {
	
	public static void main(String[] args) {
		findDisappearedNumbers(new int[] {4,3,2,7,8,2,3,1});
	}
	
    public static List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> list = new ArrayList<Integer>();        
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i+1) {
                boolean found = false;
                for (int j = i+1; j < nums.length; j++) {
                    if (nums[j] == i+1) {
                        found = true;
                        i = j;
                        break;
                    }
                }
                if (!found)
                    list.add(nums[i]);
            }
        }
        return list;
    }
}
