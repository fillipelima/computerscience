package com.fillipelima.arrays;

import java.util.LinkedList;
import java.util.Queue;

public class ShortestPath {
	int min = -1;
	int[][] directions = { { 0, -1 }, { 0, 1 }, { -1, 0 }, { 1, 0 } }; // left, right, up, down

	int shortestDistance(int N, int M, int A[][], int X, int Y) {
		if (A[0][0] == 0)
			return min;

		Queue<int[]> queue = new LinkedList<int[]>();
		boolean[][] visited = new boolean[A.length][A[0].length];

		queue.add(new int[] { 0, 0 });
		visited[0][0] = true;
		A[0][0] = 0;
		while (!queue.isEmpty()) {
			// Visit cell
			int[] curr = queue.poll();
			
			// Keep Exploring
			for (int i = 0; i < directions.length; i++) {
				int nextX = curr[0] + directions[i][0]; // x
				int nextY = curr[1] + directions[i][1]; // y

				if (nextX < 0 || nextY < 0 || nextX > A.length - 1 || nextY > A[0].length - 1)
					continue;

				// Hit target, update min
				if (curr[0] == X && curr[1] == Y) {
					return A[curr[0]][curr[1]];
				}

				if (A[nextX][nextY] == 1 && !visited[nextX][nextY]) {
					visited[curr[0]][curr[1]] = true;
					A[nextX][nextY] = A[curr[0]][curr[1]] + 1;
					queue.add(new int[] { nextX, nextY });
				}
			}
		}
		return min;

	}

	public static void main(String[] args) {
		int r = new ShortestPath().shortestDistance(0, 0,
				new int[][] { { 1, 0, 0, 0 }, { 1, 1, 0, 1 }, { 0, 1, 1, 1 } }, 2, 3);
		System.out.println(r);
	}
}
