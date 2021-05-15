package com.fillipelima.binarytree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class SymmetricTree {
	
	public static void main(String[] args) {

		SymmetricTree symetric = new SymmetricTree();
		System.out.println(symetric.isSymmetric());
	}

    public boolean isSymmetric() {
		
    	TreeNode node3left = new TreeNode(3, null, null);
		TreeNode node4left = new TreeNode(4, null, null);
		
		TreeNode node3right = new TreeNode(3, null, null);
		TreeNode node4right = new TreeNode(4, null, null);		
		
		TreeNode node2left = new TreeNode(2, node3left, node4left);
		TreeNode node2right = new TreeNode(2, node4right, node3right);
		
		TreeNode root = new TreeNode(1, node2left, node2right);	
		
		Stack<TreeNode> stack = new Stack<TreeNode>();        

        // pre order traversal (root / left / right)        
        stack.push(root.left);
        List<Integer> list1 = new ArrayList<Integer>();
        while (!stack.isEmpty()) {
            TreeNode currentNode = stack.pop();
            if (currentNode != null) {
                list1.add(currentNode.val);            
                if (currentNode.right != null || currentNode.left != null) {
                    stack.push(currentNode.right==null?new TreeNode(-200):currentNode.right);    
                    stack.push(currentNode.left==null?new TreeNode(-200):currentNode.left);
                }                                    
            }
        }
        
        
        // personalized order traversal (root / right / left)
        stack.push(root.right);
        List<Integer> list2 = new ArrayList<Integer>();
        while (!stack.isEmpty()) {
            TreeNode currentNode = stack.pop();
            if (currentNode != null) {
                list2.add(currentNode.val);            
                if (currentNode.right != null || currentNode.left != null) {
                    stack.push(currentNode.left==null?new TreeNode(-200):currentNode.left);                
                    stack.push(currentNode.right==null?new TreeNode(-200):currentNode.right);                     
                }                                                                       
                
            }
        }
        
        return (list1.equals(list2));
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
