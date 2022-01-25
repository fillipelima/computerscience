package com.fillipelima.general;

import java.util.Arrays;
import java.util.Random;

public class RandomizeArrays {
	static int[] shuffle(int[] arr) {
		Random random = new Random();
		for (int i = 0; i < arr.length-1; i++) {
			int j = random.nextInt(i+1, arr.length);
			int aux = arr[i];
			arr[i] = arr[j];
			arr[j] = aux;
		}
		return arr;
	}
	public static void main(String[] args) {
		int[] arr = new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9};
		int[] randomized = RandomizeArrays.shuffle(arr);
		Arrays.stream(randomized).forEach(v -> System.out.print(v));
	}
}
