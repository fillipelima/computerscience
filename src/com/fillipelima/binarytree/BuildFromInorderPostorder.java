	package com.fillipelima.binarytree;

public class BuildFromInorderPostorder {
	
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return buildRecursively(inorder, postorder, 0, inorder.length-1, 0, postorder.length-1);
    }
    private TreeNode buildRecursively(int[] inorder, int[] postorder, int iStart, int iEnd, int pStart, int pEnd) {
        if (iStart > iEnd || pStart > pEnd) {
            return null;
        }
        int currentValue = postorder[pEnd]; // get the last postorder element        
        int indexInorder = searchIndex(inorder, currentValue); // find the current value in the inorder array
        int leftSize = indexInorder - iStart; // left size in the inorder array
        
        TreeNode node = new TreeNode(currentValue); // create the node with current value
        node.left = buildRecursively(inorder, postorder, iStart, indexInorder - 1, pStart, pStart+leftSize-1);
        node.right = buildRecursively(inorder, postorder, indexInorder + 1, iEnd, pStart+leftSize, pEnd-1);
        
        return node;
    }
    private int searchIndex(int[] array, int element) {
        for (int i = 0; i < array.length; i++) {
            if (element == array[i]) 
                return i;
        }
        return -1;
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
