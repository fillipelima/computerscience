package com.fillipelima.graphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * https://leetcode.com/problems/cheapest-flights-within-k-stops/
 * 
 * There are n cities connected by some number of flights. You are given an
 * array flights where flights[i] = [fromi, toi, pricei] indicates that there is
 * a flight from city fromi to city toi with cost pricei.
 * 
 * You are also given three integers src, dst, and k, return the cheapest price
 * from src to dst with at most k stops. If there is no such route, return -1.
 * 
 * @author Fillipe Lima
 *
 */
public class CheapestFlights {

	public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {

		if (src == dst)
			return -1;

		Map<Integer, List<int[]>> graph = new HashMap<Integer, List<int[]>>();
		Queue<int[]> minHeap = new PriorityQueue<int[]>((a, b) -> Integer.compare(a[1], b[1]));

		// Build the graph
		for (int[] a : flights) {
			// Compute origin
			List<int[]> q = graph.computeIfAbsent(a[0], v -> new ArrayList<int[]>());
			// Add destination with price
			q.add(new int[] { a[1], a[2] });
		}

		Map<Integer, Integer> stopsMap = new HashMap<Integer, Integer>();

		// Dijkstra's algorithm

		// Push first node to min heap
		minHeap.offer(new int[] { src, 0, 0 });

		while (!minHeap.isEmpty()) {
			int[] c = minHeap.poll();
			int currentCity = c[0];
			int currentCost = c[1];
			int currentStops = c[2];
			// Arrived at destiny
			if (currentCity == dst)
				return currentCost;
			if (currentStops > k) // Reached more than max stops. Go to the next node of min heap
				continue;
			stopsMap.put(currentCity, currentStops);
			// Push neighbors to the min heap
			List<int[]> list = graph.get(currentCity);
			if (list != null) {
				for (int[] a : list) {
					int neighborCity = a[0];
					int neighborCost = a[1];
					// If neighbor is already visited and current number of stops is less than
					// number of stops when last visited, then add to visit again
					if (!stopsMap.containsKey(neighborCity) || currentStops < stopsMap.get(neighborCity))
						minHeap.offer(new int[] { neighborCity, currentCost + neighborCost, currentStops + 1 });
				}
			}
		}
		return -1;
	}

}
