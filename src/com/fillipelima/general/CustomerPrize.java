package com.fillipelima.general;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 
 * Example 1: 
 * Input: 
 * 	codeList =     [[apple, apple], [banana, anything, banana]]
 * 	shoppingCart = [orange, apple, apple, banana, orange, banana]
 * 
 * Output: 1
 * 
 * @author Fillipe Lima
 *
 */
public class CustomerPrize {
	public static int isWinner(String[][] codeList, String[] shoppingCart) {
		int currIndex = 0;
		for (String[] a : codeList) {
			List<String> sourceList = Arrays.asList(shoppingCart).stream().skip(currIndex).collect(Collectors.toList());
			int i = indexOfSubList(sourceList, Arrays.asList(a));
			if (i == -1)
				return 0;
			currIndex = i + a.length;
		}
		return 1;
	}
	private static int indexOfSubList(List<String> sourceList, List<String> subList) {
		boolean match = false;
		int i = 0;
		int j = 0; 
		int k = 0;
		if (!subList.contains("anything")) {
			return Collections.indexOfSubList(sourceList, subList);
		}else {
			while (i < subList.size()) {
				while (j < sourceList.size()) {
					if (!subList.get(i).equals("anything") && !subList.get(i).equals(sourceList.get(j))) {
						i = 0;
						j = k++;
						match = false;
					}else {
						i++;
						j++;
						match = true;
					}
				}
			}
		}
		return match ? k : -1;
	}
	
	public static void main(String[] args) {
		String[][] codeList = {{"apple", "apple"}, {"banana", "anything", "banana"}};
		String[] shoppingCart = {"orange", "apple", "apple", "banana", "orange", "banana"};
		int w = CustomerPrize.isWinner(codeList, shoppingCart);
		System.out.println(w);
		
		String[][] codeList2 = {{"apple", "apple"}, {"apple", "apple", "banana"}};
		String[] shoppingCart2 = {"apple", "apple", "apple", "banana"};
		int l = CustomerPrize.isWinner(codeList2, shoppingCart2);
		System.out.println(l);
	}
}
