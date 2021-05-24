	package com.fillipelima.binarytree;

public class PopulatingNextRight2 {
	
	public static void main(String[] args) {
		PopulatingNextRight2 p = new PopulatingNextRight2();
		TreeNode root = p.new TreeNode(1, p.new TreeNode(2, p.new TreeNode(4, null, null), null), p.new TreeNode(3, null, p.new TreeNode(5, null, null)));
		p.connect(root);
	}
	
    public TreeNode connect(TreeNode root) {
        if (root == null)
            return null;
        TreeNode left = root.left;
        TreeNode right = root.right;
        while (left != null) {
            left.next = right;                
            left = left.right!=null?left.right:left.left;
            right = right==null?null:(right.left!=null?right.left:right.right);
        }
        
//        connect(root.left);
//        connect(root.right);
        return root;        
    }
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode next;

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
