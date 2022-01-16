package com.fillipelima.arrays;

public class ReverseArrayInPlace {
	
	public static void reverse(int[] a) {
		int p1 = 0;
		int p2 = a.length-1;
		while (p1 < p2) {
			int aux = a[p1];
			a[p1] = a[p2];
			a[p2] = aux;
			p1++;
			p2--;
		}
	}
	
	public static void main(String[] args) {
		int[] a = new int[]{1,2,3,4,5,6};
		int[] b = new int[]{1,2,3,4,5,6,7};
		
		ReverseArrayInPlace.reverse(a);
		ReverseArrayInPlace.reverse(b);
		
		for (int x : a)
			System.out.print(x);
		
		System.out.println("");
		
		for (int x : b)
			System.out.print(x);
	}
	
}
