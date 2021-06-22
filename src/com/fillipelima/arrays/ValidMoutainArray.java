package com.fillipelima.arrays;

public class ValidMoutainArray {
    public boolean validMountainArray(int[] arr) {
        if (arr.length < 3)
            return false;
        boolean increasing = true;
        boolean decreasing = false;
        for (int i = 0; i < arr.length; i++) {
            if (i > 0) {
                if ((increasing && arr[i-1] >= arr[i]) || (decreasing && arr[i-1] <= arr[i]))
                    return false;
                if (i+1 < arr.length && arr[i-1] < arr[i] && arr[i] > arr[i+1]) {
                    decreasing = true;
                    increasing = false;
                }
            }                
        }
        if (!decreasing) return false;
        return true;
    }
}
