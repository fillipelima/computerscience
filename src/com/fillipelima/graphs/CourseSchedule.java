package com.fillipelima.graphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * There are a total of numCourses courses you have to take, labeled from 0 to
 * numCourses - 1. You are given an array prerequisites where prerequisites[i] =
 * [ai, bi] indicates that you must take course bi first if you want to take
 * course ai.
 * 
 * For example, the pair [0, 1], indicates that to take course 0 you have to
 * first take course 1. Return the ordering of courses you should take to finish
 * all courses. If there are many valid answers, return any of them. If it is
 * impossible to finish all courses, return an empty array.
 * 
 * Example 1:
 * 
 * Input: numCourses = 2, prerequisites = [[1,0]] Output: [0,1] Explanation:
 * There are a total of 2 courses to take. To take course 1 you should have
 * finished course 0. So the correct course order is [0,1]. 
 * 
 * Example 2:
 * 
 * Input: numCourses = 4, prerequisites = [[1,0],[2,0],[3,1],[3,2]] Output:
 * [0,2,1,3] Explanation: There are a total of 4 courses to take. To take course
 * 3 you should have finished both courses 1 and 2. Both courses 1 and 2 should
 * be taken after you finished course 0. So one correct course order is
 * [0,1,2,3]. Another correct ordering is [0,2,1,3]. 
 * 
 * Example 3:
 * 
 * Input: numCourses = 1, prerequisites = [] Output: [0]
 * 
 * https://leetcode.com/problems/course-schedule-ii/submissions/
 * 
 * @author Fillipe
 *
 */
class CourseSchedule {
	Boolean isDeadLock = false;

	public int[] findOrder(int numCourses, int[][] prerequisites) {

		int[] ans = new int[numCourses];
		int j = numCourses;
		if (prerequisites == null || prerequisites.length == 0) {
			for (int i = 0; i < numCourses; i++)
				ans[i] = --j;
			return ans;
		}

		// Graph of dependecies
		Map<Integer, List<Integer>> graph = new HashMap<>();

		// Visited
		int[] visited = new int[numCourses];

		// Topological sorted Stack
		LinkedList<Integer> list = new LinkedList<Integer>();

		// Build graph
		for (int[] a : prerequisites)
			graph.computeIfAbsent(a[1], v -> new ArrayList<Integer>()).add(a[0]);

		// Traverse graph
		for (Map.Entry<Integer, List<Integer>> e : graph.entrySet()) {
			// Not visited
			if (visited[e.getKey()] == 0) {
				dfs(graph, visited, list, e.getKey());
				list.add(e.getKey());
			}
			if (isDeadLock)
				return new int[] {};
		}

		// Empty stack
		if (list.isEmpty())
			return new int[] {};

		// Add not visited before
		int k = 0;
		for (int i = 0; i < visited.length; i++) {
			if (visited[i] == 0)
				ans[k++] = i;
		}

		// Add stack elements
		while (!list.isEmpty())
			ans[k++] = list.removeLast();

		return ans;

	}

	private void dfs(Map<Integer, List<Integer>> graph, int[] visited, LinkedList<Integer> list, Integer currNode) {
		if (isDeadLock)
			return;

		// Visit current node
		visited[currNode] = 1;

		// Get Adjacents
		List<Integer> adjacentNodes = graph.get(currNode);
		adjacentNodes = adjacentNodes == null ? new ArrayList<Integer>() : adjacentNodes;

		// Traverse adjacents
		for (Integer adjacentNode : adjacentNodes) {

			// Not visited yet
			if (visited[adjacentNode] == 0) {
				dfs(graph, visited, list, adjacentNode);
				list.add(adjacentNode);
			} else if (visited[adjacentNode] == 1) {
				this.isDeadLock = true;
			}
		}

		visited[currNode] = 2;

	}
}
