package com.fillipelima.general;

import java.util.LinkedList;
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
	}
}
