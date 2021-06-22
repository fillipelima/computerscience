package com.fillipelima.arrays;

public class ReplaceElements {
    public int[] replaceElements(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (i == arr.length-1) {
                arr[i] = -1;
                continue;
            }
            arr[i] = greatest(i+1, arr);
        }
        return arr;
    }
    private int greatest(int i, int[] arr) {
        int g = arr[i];
        for (int j = i+1; j < arr.length; j++) {
            if (arr[j] > g) {
                g = arr[j];
            }
        }        
        return g;
    }
}
