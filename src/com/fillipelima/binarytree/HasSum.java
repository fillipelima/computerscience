package com.fillipelima.binarytree;

public class HasSum {
	
	public static void main(String[] args) {

		HasSum maxDepth = new HasSum();
		
		TreeNode node3 = maxDepth.new TreeNode(3, null, null);
		TreeNode node2 = maxDepth.new TreeNode(2, node3, null);
		TreeNode node1 = maxDepth.new TreeNode(1, null, node2);			
		
		System.out.println(maxDepth.hasPathSum(node1, 6));
	}

    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null)
            return false;
        if (targetSum - root.val == 0 && root.left == null && root.right == null) 
            return true;
        return hasPathSum(root.left, targetSum - root.val) || hasPathSum(root.right, targetSum - root.val);
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
