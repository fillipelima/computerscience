package com.fillipelima.strings;

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

	public static void main(String[] args) {
		System.out.println(ValidParentheses.isValid("((([{[{[()]}]}])))"));
	}
}
