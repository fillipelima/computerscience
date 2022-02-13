package com.fillipelima.strings;

import java.util.HashMap;
import java.util.Map;

/**
 * Longest Substring Without Repeating Characters
 * 
 * @author Fillipe Lima
 *
 */
public class LongestSubstringWithoutRepeating {
	class Solution {
	    public int lengthOfLongestSubstring(String s) {
	        Map<Character, Integer> map = new HashMap<Character, Integer>();
	        int count = 0;
	        int start = 0;
	        for (int i = 0; i < s.length(); i++) {
	            Character c = s.charAt(i);            
	            if (map.containsKey(c))
	                start = Math.max(start, map.get(c)+1);
	            count = Math.max(count, i-start+1); 
	            map.put(c, i); 
	        }
	        return count;
	    }
	}
}
