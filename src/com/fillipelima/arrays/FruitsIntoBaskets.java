package com.fillipelima.arrays;

import java.util.HashSet;
import java.util.Set;

public class FruitsIntoBaskets {

	// Sliding Window Approach
    public int slidingWindow(int[] fruits) {
        int i = 0;
        int j = 1;
        int maxFruitCount = 0;
        int runningCount = 1;
        Set<Integer> set = new HashSet<Integer>();
        set.add(fruits[i]);
        while (j < fruits.length) {
            set.add(fruits[j]);
            // Broke the rule
            if (set.size() > 2) {
                maxFruitCount = Math.max(maxFruitCount, runningCount);                
                i++;
                j = i + 1;    
                set.clear();
                set.add(fruits[i]);                
                runningCount = 1;
            }else{
                runningCount++;
                j++;    
            }
        }
        maxFruitCount = Math.max(maxFruitCount, runningCount);
        return maxFruitCount;
    }
}
