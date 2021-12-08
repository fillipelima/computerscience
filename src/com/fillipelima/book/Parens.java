
package com.fillipelima.book;

import java.util.ArrayList;
import java.util.List;

/*

Parens: Implement an algorithm to print all valid (e.g., properly opened and closed) combinations
of n pairs of parentheses.
EXAMPLE
Input: 3
Output: ( ( () ) ) , ( () () ) , ( () ) () , () ( () ) , () () ()

*/

public class Parens {

	public List<String> parens(int n) {
		List<String> result = new ArrayList<String>();
		result.add(firstPattern(n));
		result.add("(" +secondPattern(n-1)+")");
		result.add(firstPattern(n-1)+"()");
		result.add("()"+firstPattern(n-1));
		result.add(secondPattern(n));
		return result;
	}
	
	/*
	 * Base case with 1:
	 *    1 - ()
	 * Second case with 2:    
	 *    2 - (())
	 * 
	 * ...
	 *  
	 */
	private String firstPattern(int n) {
		if (n == 0)
			return "";
		if (n  == 1)
			return "()";
		else
			return "(" + firstPattern(n-1) + ")"; 
	}
	
	/*
	 * Base case with 1:
	 *    1 - ()
	 * Second case with 2:    
	 *    2 - ( () )
	 * Thrid case with 3:   
	 *    3 - ( () () )
	 * 
	 */
	private String secondPattern(int n) {
		if (n == 0)
			return "";
		if (n  == 1)
			return "()";
		else
			return secondPattern(n-1) + "()"; 
	}
	
	public static void main(String[] args) {
	 System.out.println(new Parens().parens(3));
	}
	
}
