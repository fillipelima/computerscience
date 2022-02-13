package com.fillipelima.arrays;

/**
 * 
 * Find Kth element in Asc order
 * 
 * @author Fillipe Lima
 *
 */
public class FindKthElement {		
	
	// Using common way of implementing bubble sort
	public static int findStandard(int[] a, int k) {
		int n = a.length;
		for (int i = 0; i < n-1; i++) {
			boolean swapped = false;
			for (int j = 0; j < n-1-i; j++) {
				if (a[j] > a[j+1]) {
					swap(a, j, j+1);
					swapped = true;
				}				
			}
			if (!swapped) break;
		}
		return a[k-1];
	}
	
	// Using my bubble sort
	public static int find(int[] a, int k) {
		boolean swapped = true;		
		int n = a.length-1;
		int i = 0;
		while (true) {
			if (a[i] > a[i+1]) {
				swap(a, i, i+1);
				swapped = true;
			}							
			i++;			
			// Reched the end of current pass. Go to next pass or break
			if (i == n) {
				if (!swapped)
					break;
				swapped = false;
				i = 0;
				n--;
			}
		}
		return a[k-1];
	}
	
	private static void swap(int[] a, int i, int j) {
		int aux = a[i];
		a[i] = a[j];
		a[j] = aux;
	}
	
	public static void main(String[] args) {
		System.out.println("Standard Bubble Sort: " + FindKthElement.findStandard(new int[] {3,5,2,9,1,6,4,8,7}, 3));
		System.out.println("My Bubble Sort: " + FindKthElement.find(new int[] {3,5,2,9,1,6,4,8,7}, 3));
	}
	
}
