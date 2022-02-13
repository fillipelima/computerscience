package com.fillipelima.sorting;

public class QuickSort {

	public void sort(int[] a) {
		quickSort(a, 0, a.length - 1);
	}

	private void quickSort(int[] a, int l, int r) {
		if (l >= r)
			return;
		int pivotIndex = rearrangePivot(a, l, r);
		quickSort(a, l, pivotIndex - 1);
		quickSort(a, pivotIndex + 1, r);
	}

	private int rearrangePivot(int[] a, int l, int r) {
		int pivot = a[r];
		// index of last smaller element found so far.
		// this is one index before where pivot will be placed after all.
		int k = l - 1;
		for (int i = l; i <= r; i++) {
			if (a[i] < pivot) {
				k++;
				swap(a, k, i);
			}
		}
		swap(a, k + 1, r);
		return k + 1;
	}

	private void swap(int[] a, int i, int j) {
		int aux = a[i];
		a[i] = a[j];
		a[j] = aux;
	}

}
