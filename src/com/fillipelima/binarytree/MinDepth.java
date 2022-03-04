package com.fillipelima.binarytree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode() {
	}

	TreeNode(int val) {
		this.val = val;
	}

	TreeNode(int val, TreeNode left, TreeNode right) {
		this.val = val;
		this.left = left;
		this.right = right;
	}
}

class TreeNodeCount {
	TreeNode node;
	int count;

	TreeNodeCount(TreeNode node, int count) {
		this.node = node;
		this.count = count;
	}
}

public class MinDepth {
	public int dfs(TreeNode root) {
		if (root == null)
			return 0;
		int min = Integer.MAX_VALUE;
		Stack<TreeNodeCount> stack = new Stack<TreeNodeCount>();
		stack.push(new TreeNodeCount(root, 1));
		while (!stack.isEmpty()) {
			TreeNodeCount curr = stack.pop();
			if (curr.node.left == null && curr.node.right == null)
				min = Math.min(min, curr.count);
			if (curr.node.left != null)
				stack.push(new TreeNodeCount(curr.node.left, curr.count + 1));
			if (curr.node.right != null)
				stack.push(new TreeNodeCount(curr.node.right, curr.count + 1));
		}
		return min;
	}
	public int bfs(TreeNode root) {
		if (root == null)
			return 0;
		int min = Integer.MAX_VALUE;
		Queue<TreeNodeCount> queue = new LinkedList<TreeNodeCount>();
		queue.add(new TreeNodeCount(root, 1));
		while (!queue.isEmpty()) {
			TreeNodeCount curr = queue.poll();
			if (curr.node.left == null && curr.node.right == null)
				min = Math.min(min, curr.count);
			if (curr.node.left != null)
				queue.add(new TreeNodeCount(curr.node.left, curr.count + 1));
			if (curr.node.right != null)
				queue.add(new TreeNodeCount(curr.node.right, curr.count + 1));
		}
		return min;
	}
	// from leet code solution
	public int recursive(TreeNode root) {
		if (root == null)
			return 0;
		if (root.left == null && root.right == null) {
			return 1;
		}
		int min = Integer.MAX_VALUE;
		if (root.left != null) {
			min = Math.min(recursive(root.left), min);
		}
		if (root.right != null) {
			min = Math.min(recursive(root.right), min);
		}
		return min + 1;
	}
	
	// my solution
	public int recursive2(TreeNode root) {
		if (root == null)
			return 0;
        if (root.left == null && root.right == null)
            return 1;
        int left = Integer.MAX_VALUE;
        int right = Integer.MAX_VALUE;
        if (root.left != null)
            left = 1 + recursive2(root.left);
        if (root.right != null)
            right = 1 + recursive2(root.right);
		return Math.min(left, right);
	}	
}
