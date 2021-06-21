package com.fillipelima.arrays;

import java.util.Arrays;

public class SquaresOfSortedArray {
	
	public int[] sortedSquares(int[] nums) {
        Integer[] square = new Integer[nums.length];
        int c = 0;
        for (int n : nums) {
            int s = n * n;
            square = insertInOrder(s, square, c);
            c++;
        }
        return Arrays.stream(square).mapToInt(Integer::intValue).toArray();
    }
    
    private Integer[] insertInOrder(int s, Integer[] square, int c) {
        for (int i = 0; i < square.length; i++) {
            if (square[i] == null) {
                square[i] = s;
                break;
            }else if (s < square[i]){
                shift(square, i, c);
                square[i] = s;                
                break;
            }
        }
        return square;
    }
    
    private Integer[] shift(Integer[] square, int i, int c) {
        for (int j = c; j > i; j--) {
            square[j] = square[j-1];
        }
        return square;
    }
}
