package com.fillipelima.general;

import java.util.Map;
import java.util.TreeMap;

public class OddEvenJumps {
	 public int oddEvenJumps(int[] arr) {
	        // Array size
	        int length = arr.length;
	        
	        // Count good jumps
	        int count = 1;
	        
	        // Jump possibilities table. Init false for All
	        boolean[] canJumpToLargest = new boolean[length];
	        boolean[] canJumpToSmaller = new boolean[length];
	        
	        // Define a Map to store already visited elements and its indexes
	        TreeMap<Integer, Integer> map = new TreeMap<Integer, Integer>();
	        
	        // Configure last element
	        map.put(arr[length-1], length-1);        
	        canJumpToLargest[length-1] = true;
	        canJumpToSmaller[length-1] = true;
	        
	        
	        // Traverse the array and calculates possibilities backward.
	        for (int i = length-2; i >= 0; --i) {
	            // Current value
	            Integer element = Integer.valueOf(arr[i]);
	            
	            // Calculate possibility to Jump to a Largest element
	            Map.Entry<Integer, Integer> largestElement = map.ceilingEntry(element);
	            if (largestElement != null)
	                canJumpToLargest[i] = canJumpToSmaller[(int)largestElement.getValue()];
	            
	            // Calculate possibility to Jump to a Smaller element
	            Map.Entry<Integer, Integer> smallerElement = map.floorEntry(element);
	            if (smallerElement != null)
	                canJumpToSmaller[i] = canJumpToLargest[(int)smallerElement.getValue()];            
	            
	            if (canJumpToLargest[i])
	                count++;
	            
	            map.put(element, i);
	        }
	        
	        return count;
	        
	    }
}
