package com.fillipelima.binarysearchtree;

class BalancedBST {
    public boolean isBalanced(TreeNode root) {
        if (root == null)
            return true;        
        int diff = Math.abs(maxDepth(root.left) - maxDepth(root.right));
        if (diff > 1)
            return false;                            
        return (isBalanced (root.left) && isBalanced (root.right));                              
    }
    private int maxDepth(TreeNode root) {
        if (root == null) 
            return 0;
        return Math.max(maxDepth(root.left), maxDepth(root.right)) +1;
    }
   
}