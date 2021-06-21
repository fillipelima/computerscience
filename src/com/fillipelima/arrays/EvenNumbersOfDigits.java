package com.fillipelima.arrays;

public class EvenNumbersOfDigits {
    public int findNumbers(int[] nums) {
        int countEven = 0;
        for (Integer n : nums) {
            String s = n.toString();
            if (s.length() % 2 == 0)
                countEven++;
        }
        return countEven;
    }
}
