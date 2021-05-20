package com.fillipelima.binarysearchtree;

import java.util.Stack;

class BSTIterator {
    
    Stack<TreeNode> stack = new Stack<TreeNode>();
    TreeNode currentNode;

    public BSTIterator(TreeNode root) {
        currentNode = root;
    }
    
    public int next() {
        while (currentNode != null) {
            stack.push(currentNode);
            currentNode = currentNode.left;
        }
        
        currentNode = stack.pop();
        TreeNode node = currentNode;
        currentNode = currentNode.right;
        
        return node.val;
    }
    
    public boolean hasNext() {
        return !stack.isEmpty() || currentNode != null;
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