package com.fillipelima.binarytree;

public class MaxDepth {
	
	public static void main(String[] args) {

		MaxDepth maxDepth = new MaxDepth();
		
		TreeNode node3 = maxDepth.new TreeNode(3, null, null);
		TreeNode node2 = maxDepth.new TreeNode(2, node3, null);
		TreeNode node1 = maxDepth.new TreeNode(1, null, node2);			
		
		System.out.println(maxDepth.maxDepth(node1));
	}

	  public int maxDepth(TreeNode root) {
		  
	        if (root == null)
	            return 0;
	        int countLeft = 1 + maxDepth(root.left);
	        int countRight = 1 + maxDepth(root.right);                
	        return Math.max(countLeft, countRight);
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
