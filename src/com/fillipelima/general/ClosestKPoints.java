package com.fillipelima.general;

import java.util.PriorityQueue;
import java.util.Queue;

class Point {
	int x;
	int y;
	Double distance;

	public Point(int x, int y, Double distance) {
		this.x = x;
		this.y = y;
		this.distance = distance;
	}
}

class ClosestKPoints {
	public int[][] kClosest(int[][] points, int k) {
		Queue<Point> minHeap = new PriorityQueue<Point>((a, b) -> a.distance.compareTo(b.distance));
		for (int i = 0; i < points.length; i++) {
			Double d = euclideanDistance(points[i][0], points[i][1]);
			minHeap.add(new Point(points[i][0], points[i][1], d));
		}
		int[][] result = new int[k][2];
		while (k > 0) {
			Point p = minHeap.poll();
			result[k - 1][0] = p.x;
			result[k - 1][1] = p.y;
			k--;
		}
		return result;
	}

	private double euclideanDistance(int a, int b) {
		return Math.sqrt(Math.pow(a, 2) + Math.pow(b, 2));
	}
}