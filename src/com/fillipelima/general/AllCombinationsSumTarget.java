package com.fillipelima.general;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;
import java.util.stream.Collectors;

/**
 * 
 * Find All Combination of Numbers Sum to Target
 * 
 * Example
 * 
 * Input: 5
 * 
 * Output: 
 * 
 * 1, 4
 * 2, 3
 * 1, 1, 3
 * 1, 2, 2
 * 1, 1, 1, 2
 * 1, 1, 1, 1, 1 
 * 
 * @author Fillipe Lima
 *
 */
public class AllCombinationsSumTarget {
	public static List<List<Integer>> find(int n) {
		// Result list
		List<List<Integer>> list = new ArrayList<List<Integer>>();
		
		// Create stack and add first element
		Stack<Integer> stack = new Stack<Integer>();
		stack.add(n);
		
		// While the last combination (Made by only number 1) is not built
		while (!stack.isEmpty() && stack.size() < n) {
			// Break last element with 1 and complement
			int pop = stack.pop();
			
			// Compute main combination
			stack.push(1);
			stack.push(pop-1);
			
			// Add main combination to result list
			List<Integer> combination = new ArrayList<Integer>();
			combination.addAll(stack);
			list.add(combination);
			Collections.sort(combination);
			
			if (stack.size() < n) {
				// Compute second combination if possible (get All Pairs of 1 and transform in 2)
				List<Integer> listFromStack = stack.stream().collect(Collectors.toList());
				List<Integer> combination2 = new ArrayList<Integer>();
				for (int i = 0; i < listFromStack.size(); i++) {
					// Pair found [1, 1] => Sum, so it will be 2 and put in combination list
					if (i < listFromStack.size()-1 && listFromStack.get(i) == 1 && listFromStack.get(i+1) == 1) {
						combination2.add(2);
						i++; // Increment as we already visited this index
					}else {
						combination2.add(listFromStack.get(i));
					}
				}
				
				// If it was possible to build the second combination, add it to final result list
				if (combination2.size() < listFromStack.size()) {
					Collections.sort(combination2);
					list.add(combination2);	
				}
			}
		}
		
		// Result list
		Collections.sort(list, (a, b) -> compareLists(a, b));
		return list;
	}
	
	private static int compareLists(List<Integer> a, List<Integer> b) {
		if (a.size() == b.size()) {
			int i = 0;
			while (i < a.size()) {
				if (a.get(i) != b.get(i)) {
					return a.get(i) - b.get(i); 
				}
				i++;
			}
			return 0;
		}else {
			return a.size() - b.size();
		}
		
	}
	
	public static void main(String[] args) {
		System.out.println(AllCombinationsSumTarget.find(5));
	}
}
