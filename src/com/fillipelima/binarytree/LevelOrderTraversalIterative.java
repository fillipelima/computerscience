package com.fillipelima.binarytree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LevelOrderTraversalIterative {

	public static void main(String[] args) {

		LevelOrderTraversalIterative iterative = new LevelOrderTraversalIterative();
		System.out.println(iterative.levelOrder());
	}

	public List<List<Integer>> levelOrder() {

		TreeNode node3 = new TreeNode(3, null, null);
		TreeNode node2 = new TreeNode(2, node3, null);
		TreeNode node1 = new TreeNode(1, null, node2);			
		
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		List<List<Integer>> list = new ArrayList<List<Integer>>();

		queue.add(node1);

		while (!queue.isEmpty()) {
			List<Integer> subList = new ArrayList<Integer>();
			Queue<TreeNode> queueAux = new LinkedList<TreeNode>();
			for (TreeNode node : queue) {
				if (node != null) {
					subList.add(node.val);
					if (node.left != null)
						queueAux.add(node.left);
					if (node.right != null)
						queueAux.add(node.right);
				}
			}
			if (subList.size() > 0)
				list.add(subList);
			queue = queueAux;
		}
		return list;
	}

	public class TreeNode {
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

}
