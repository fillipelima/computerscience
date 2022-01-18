package com.fillipelima.general;

import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class OptimalFileMergePattern {
	public static int getMinComputation(int[] arr) {
		List<Integer> list = Arrays.stream(arr).boxed().toList();
		Queue<Integer> queue = new PriorityQueue<Integer>(list);
		int cost = 0;
		while (queue.size() > 1) {
			int a = queue.poll();
			int b = queue.poll();
			int sum = a + b;
			cost += sum;
			queue.add(sum);
		}
		return cost;
	}
	public static void main(String[] args) {
		System.out.println(OptimalFileMergePattern.getMinComputation( new int[] {5,10,20,30,30}  ));
	}
}
