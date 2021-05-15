package com.fillipelima.binarytree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PostOrderTraversalIterative {
	
	public static void main(String[] args) {

		PostOrderTraversalIterative iterative = new PostOrderTraversalIterative();
		System.out.println(iterative.postorderTraversal());
	}

	  public List<Integer> postorderTraversal() {
		  
			TreeNode node3 = new TreeNode(3, null, null);
			TreeNode node2 = new TreeNode(2, node3, null);
			TreeNode node1 = new TreeNode(1, null, node2);		
			
			List<Integer> list = new ArrayList<Integer>();
			Stack<TreeNode> stack = new Stack<TreeNode>();

			// First to be visited (root).
			stack.push(node1);

			TreeNode currentNode = null;
			while (!stack.empty()) {

				currentNode = stack.pop();

				if (currentNode != null) {
					
					// Root
					if (currentNode.left == null && currentNode.right == null) {
						list.add(currentNode.val);
						
					} else {
						TreeNode auxTreeNode = new TreeNode(currentNode.val, null, null);
						stack.push(auxTreeNode);
					}					
					
					// Right
					if (currentNode.right != null) {
						stack.push(currentNode.right);
					}

					// Left
					if (currentNode.left != null) {
						stack.push(currentNode.left);
					}									

				}

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
