package com.fillipelima.sorting;
//    [5,6,9,1,4,8,2,0]
// 1: [5,6,1,4,8,2,0,9]
// 2: [5,1,4,6,2,0,8,9]
// 3: [1,4,5,2,]
public class BubbleSort {

	public void sort(int[] a) {
		for (int i = 0; i < a.length-1; i++) {
			boolean swapped = false;
			for (int j = 0; j < a.length-1-i; j++ ) {
				if (a[j] > a[j+1]) {
					swap(a, j, j+1);
					swapped = true;
				}
			}
			if (!swapped) break;
		}
	}
	private void swap(int[] a, int i, int j) {
		int aux = a[i];
		a[i] = a[j];
		a[j] = aux;
	}
}
