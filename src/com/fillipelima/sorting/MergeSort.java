package com.fillipelima.sorting;

import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * 
 * @author Fillipe
 *
 */
public class MergeSort {

	public static void sort(int[] a, int l, int r) {
		if (l >= r)
			return;
		int m = l + (r - l) / 2;
		sort(a, l, m);
		sort(a, m + 1, r);
		merge(a, l, m, r);
	}

	private static void merge(int[] a, int l, int m, int r) {
		int[] left = Arrays.copyOfRange(a, l, m + 1);
		int[] right = Arrays.copyOfRange(a, m + 1, r + 1);
		int i = 0;
		int j = 0;
		int k = l;
		while (i < left.length && j < right.length) {
			if (left[i] <= right[j]) {
				a[k] = left[i];
				i++;
			} else {
				a[k] = right[j];
				j++;
			}
			k++;
		}
		while (i < left.length) {
			a[k] = left[i];
			i++;
			k++;
		}
		while (j < right.length) {
			a[k] = right[j];
			j++;
			k++;
		}
	}

	public static void main(String[] args) {
		int[] a = new int[]
		{6334,4098,7968,4523,277,6956,4560,2062,5705,5743,879,5626,9961,491,2995,741,4827};
		MergeSort.sort(a, 0, a.length - 1);
		System.out.println(Arrays.stream(a).boxed().collect(Collectors.toList()));
	}
}
