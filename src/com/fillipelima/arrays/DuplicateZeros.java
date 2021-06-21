package com.fillipelima.arrays;

public class DuplicateZeros {
    public void duplicateZeros(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0) {
                // shift
                for (int j = arr.length-1; j-1 > i; j--) {
                    arr[j] = arr[j-1];                    
                }
                // duplicate
                if (i < arr.length-1)
                    arr[i+1] = 0;
                i++;
            }
        }
    }
}
