package com.fillipelima.arrays;

public class MergeSortedArrays {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        for (int i = 0; i < nums2.length; i++) {
            boolean inserted = false;
            for (int j = 0; j < nums1.length; j++) {
                if (nums1[j] == 0 && j >= m)
                    break;        
                if (nums2[i] < nums1[j]) {
                    shift(nums1, j, m);
                    nums1[j] = nums2[i];
                    inserted = true;
                    m++;
                    break;
                }
            }
            if (!inserted) {
                nums1[m] = nums2[i];
                m++;
            }
                
        }
    }
    private void shift(int[] nums1, int j, int m) {
        for (int i = m-1; i >= j; i--) {
            nums1[i+1] = nums1[i];
        }
    }
}
