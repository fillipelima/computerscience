package com.fillipelima.general;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * 
 * Given a matrix with values 0 (trenches), 1 (flat), and 9 (obstacle) you have
 * to find the minimum distance to reach 9 (obstacle). If not possible then
 * return -1. The demolition robot must start at the top left corner of the
 * matrix, which is always flat and can move on the block up, down, right, left.
 * The demolition robot cannot enter 0 trenches and cannot leave the matrix.
 * 
 * Sample Input :
 * 
 * [1, 0, 0],
 * 
 * [1, 0, 0],
 * 
 * [1, 9, 1]]
 * 
 * Sample Output :
 * 
 * 3
 * 
 * @author Fillipe Lima
 *
 */
public class MinimumDistanceToReachObstacle {
	// My implementation
	public static int find(int[][] m) {
		// Min Heap of points (x, y) and distance
		// [0] = x
		// [1] = y
		// [2] = distance
		// Compare by distance [2]
		Queue<int[]> queue = new PriorityQueue<int[]>((a, b) -> a[2] - b[2]);

		// Add first node
		queue.add(new int[] { 0, 0, 0 });

		// Create directios
		int[][] directions = new int[][] { 
				{ 0, 1 }, // right
				{ 1, 0 }, // down
				{ 0, -1 }, // left
				{ -1, 0 } }; // up

		// BFS - Djikstra Algorithm
		while (!queue.isEmpty()) {
			// Current Node
			int[] curr = queue.poll();

			// Found destiny (Obstacle)
			if (m[curr[0]][curr[1]] == 9)
				return curr[2];

			// Possible paths
			for (int[] d : directions) {
				// Calculate current direction change
				int x = curr[0] + d[0];
				int y = curr[1] + d[1];

				// Make sure indexes to desired direction are possible (are in range of matrix
				// and differs from zero (trenches))
				if (x >= 0 && y >= 0 && x < m.length && y < m[0].length && m[x][y] != 0)
					queue.add(new int[] { x, y, curr[2] + 1 });
			}
		}
		return -1;
	}

	// From leetcode discussion
	public static int demolitionRobot(int[][] grid) {

		int n = grid.length;
		int m = grid[0].length;

		Queue<int[]> q = new LinkedList<>();
		boolean[][] visited = new boolean[n][m];

		int minD = Integer.MAX_VALUE;

		int[][] directions = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };

		q.add(new int[] { 0, 0 });
		visited[0][0] = true;
		while (!q.isEmpty()) {
			int[] cur = q.remove();
			for (int[] d : directions) {
				int nX = cur[0] + d[0];
				int nY = cur[1] + d[1];

				if (nX < 0 || nY < 0 || nX >= n || nY >= m || grid[nX][nY] == 0)
					continue;

				if (grid[nX][nY] == 9)
					minD = Math.min(minD, grid[cur[0]][cur[1]]);

				if (grid[nX][nY] == 1 && !visited[nX][nY]) {
					grid[nX][nY] = grid[cur[0]][cur[1]] + 1;
					visited[nX][nY] = true;
					q.add(new int[] { nX, nY });
				}
			}
		}

		return minD;
	}

	public static void main(String[] args) {
		System.out.println(
				MinimumDistanceToReachObstacle.demolitionRobot(new int[][] { { 1, 0, 0 }, { 1, 0, 0 }, { 1, 9, 1 } }));
		System.out.println(MinimumDistanceToReachObstacle.find(new int[][] { { 1, 0, 0 }, { 0, 0, 0 }, { 1, 9, 1 } }));
		System.out.println(MinimumDistanceToReachObstacle.find(new int[][] { { 1, 1, 1 }, { 1, 1, 1 }, { 1, 1, 9 } }));
	}
}
