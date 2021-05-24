package com.fillipelima.binarysearchtree;

class InsertBST {
    TreeNode node;
    public TreeNode insertIntoBST(TreeNode root, int val) {
        return recursive(root, root, val);
    }
    
    private TreeNode recursive(TreeNode root, TreeNode node, int val) {
        if (root == null && node == null)
            return new TreeNode(val, null, null);
        if (root == null)
            return null;        
        if (root.left == null && val < root.val) {
            root.left = new TreeNode(val, null, null);
            return node;
        }
        
        if (root.right == null && val > root.val) {
            root.right = new TreeNode(val, null, null);
            return node;
        }        
        
        if (val < root.val)
            return recursive(root.left, node, val);
        return recursive(root.right, node, val);        
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