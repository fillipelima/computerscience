package com.fillipelima.book;

public class RotateMatrix {
	
	public static void main(String[] args) {
		System.out.println(rotate(new int[][]{{1,2,3,4}, {5,6,7,8}, {9,10,11,12}, {13,14,15,16}}));
	}
	
	public static int[][] rotate(int[][] m) {
		// rotate edges
		int i = 0;
		int j = m.length-1;
		int k = 0;
		int w = m.length-1;
		int l = m.length/2;
		while (i <= l) {
			int aux = m[i][k];
			m[i][k] = m[k][j];
			m[k][j] = m[j][w];
			m[j][w] = m[w][i];
			m[w][i] = aux;
			if (i == m.length/2) {
				k++;
				i = k;
				j = m.length-1 - k;
				w = m.length-1 - k;
				l--;
			}else {
				i++;
				j--;				
			}
		}
		return m;
	}
}
