package com.fillipelima.arrays;

/**
 * Given an array Arr (distinct elements) of size N. Rearrange the elements of
 * array in zig-zag fashion. The converted array should be in form a < b > c < d
 * > e < f. The relative order of elements is same in the output i.e you have to
 * iterate on the original array only.
 * 
 * https://practice.geeksforgeeks.org/problems/convert-array-into-zig-zag-fashion1638/1/
 * 
 * @author Fillipe Lima
 *
 */
public class ConvertArrayIntoZigZag {
	void zigZag(int arr[], int n) {
		boolean mustBeSmaller = true;
		for (int i = 0; i < n - 1; i++) {
			if (mustBeSmaller) {
				if (arr[i] > arr[i + 1])
					swap(arr, i, i + 1);
			} else {
				if (arr[i] < arr[i + 1])
					swap(arr, i, i + 1);
			}
			mustBeSmaller = !mustBeSmaller;
		}
	}

	private void swap(int[] a, int i, int j) {
		int aux = a[i];
		a[i] = a[j];
		a[j] = aux;
	}
}
