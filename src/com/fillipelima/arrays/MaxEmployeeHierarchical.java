package com.fillipelima.arrays;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 * Find Max Employee Hierarchical Length
 * 
 * var employees = new string[] { "Richard", "Mark", "Amy", "Cindy", "Kevin" };
 * var managers = new string[] { "Kevin", "Kevin", "Cindy", null, "Cindy" };
 * 
 * @author Fillipe Lima
 *
 */
public class MaxEmployeeHierarchical {

	// Iterative. Better aproach in a production environment
	public static int findIterative(String[] employees, String[] managers) {
		// Build graph using map
		Map<String, String> map = new HashMap<String, String>();
		for (int i = 0; i < employees.length; i++)
			map.put(employees[i], managers[i]);

		// Traverse graph and find max length
		int max = 0;
		for (Map.Entry<String, String> e : map.entrySet()) {
			String curr = e.getValue();
			int count = 1;
			while (curr != null) {
				count++;
				curr = map.get(curr);
			}
			max = Math.max(max, count);
		}

		return max;
	}

	// Recursive. Clean code, but it can throw a StackOverFlowException when dealing with lots of data
	public static int findRecursive(String[] employees, String[] managers) {
		// Build graph using map
		Map<String, String> map = new HashMap<String, String>();
		for (int i = 0; i < employees.length; i++)
			map.put(employees[i], managers[i]);

		// Traverse graph and find max length
		int max = 0;
		for (Map.Entry<String, String> e : map.entrySet()) {
			String curr = e.getValue();
			// Recursion	
			int count = 1 + recursive(map, curr);
			max = Math.max(max, count);
		}

		return max;
	}

	private static int recursive(Map<String, String> map, String curr) {
		if (curr == null)
			return 0;
		return 1 + recursive(map, map.get(curr));
	}

	public static void main(String[] args) {
		System.out.println("Iterative: "
				+ MaxEmployeeHierarchical.findIterative(new String[] { "Richard", "Mark", "Amy", "Cindy", "Kevin" },
						new String[] { "Kevin", "Kevin", "Cindy", null, "Cindy" }));
		System.out.println("Recursively: "
				+ MaxEmployeeHierarchical.findRecursive(new String[] { "Richard", "Mark", "Amy", "Cindy", "Kevin" },
						new String[] { "Kevin", "Kevin", "Cindy", null, "Cindy" }));
	}

}
