package com.fillipelima.strings;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * https://leetcode.com/problems/valid-parentheses/
 * 
 * Given a string s containing just the characters '(', ')', '{', '}', '[' and
 * ']', determine if the input string is valid.
 * 
 * An input string is valid if:
 * 
 * Open brackets must be closed by the same type of brackets. Open brackets must
 * be closed in the correct order.
 * 
 * 
 * @author Fillipe Lima
 *
 */

public class ValidParentheses {
	
    public boolean isValid3(String s) {
        Map<Character, Character> map = Map.of('(', ')', '[', ']', '{', '}');
        Stack<Character> stack = new Stack<Character>();
        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i)))
                stack.add(map.get(s.charAt(i)));
            else if (!stack.isEmpty() && stack.peek().equals(s.charAt(i)))
                stack.pop();
            else
                return false;
        }
        return stack.isEmpty();       
    }	

	public static boolean isValid(String s) {
		if (s.length() < 2)
			return false;
		Map<Character, Character> map = Map.of('(', ')', '{', '}', '[', ']');
		if (!map.containsKey(s.charAt(0)))
			return false;

		Stack<Character> stack = new Stack<Character>();
		for (Character c : s.toCharArray()) {
			if (!stack.isEmpty() && map.get(stack.peek()).equals(c))
				stack.pop();
			else if (map.containsKey(c))
				stack.add(c);
			else
				return false;
		}
		return stack.isEmpty();
	}
	
	   public boolean isValid2(String s) {
	        if (s.length() == 0)
	            return false;
	        Stack<String> stack = new Stack<String>();
	        HashMap<String, String> openMap = new HashMap<String, String>();
	        openMap.put("(", ")");
	        openMap.put("{", "}");
	        openMap.put("[", "]");
	        HashMap<String, String> closeMap = new HashMap<String, String>();
	        closeMap.put(")", "(");
	        closeMap.put("}", "{");
	        closeMap.put("]", "[");      
	        for (int i = 0; i < s.length(); i++) {
	            char c = s.charAt(i);
	            String s2 = Character.toString(c);
	            if (openMap.containsKey(s2)) {
	                stack.push(s2);
	            }else{
	                if (!stack.isEmpty()) {
	                    String pop = stack.pop();
	                    if (!closeMap.get(s2).equals(pop))
	                        return false;
	                }else{
	                    return false;
	                }
	            }
	        }
	        if (!stack.isEmpty())
	            return false;
	        return true;
	    }	

	public static void main(String[] args) {
		System.out.println(ValidParentheses.isValid("((([{[{[()]}]}])))"));
	}
}
