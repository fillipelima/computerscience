package com.fillipelima.binarytree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ZigZagLevelOrder {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if (root == null)
            return new ArrayList<List<Integer>>();
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        queue.add(null);
        LinkedList<Integer> levelList = new LinkedList<Integer>();
        boolean isLeftToRight = true;
        while (!queue.isEmpty()) {
            TreeNode curr = queue.poll();
            if (curr != null) {
                if (isLeftToRight) {
                    levelList.add(curr.val);
                }else{
                    levelList.addFirst(curr.val);
                }
                if (curr.left != null)
                    queue.add(curr.left);
                if (curr.right != null)
                    queue.add(curr.right);
            }else{
                isLeftToRight = !isLeftToRight;
                if (queue.size() > 0)
                    queue.add(null);
                result.add(levelList);
                levelList = new LinkedList<Integer>(); 
            }
        }
        return result;
    }
    
    protected void DFS(TreeNode node, int level, List<List<Integer>> results) {
        if (level == results.size()) {
          LinkedList<Integer> newLevel = new LinkedList<Integer>();
          newLevel.add(node.val);
          results.add(newLevel);
        } else {
          if (level % 2 == 0)
            results.get(level).add(node.val);
          else
            results.get(level).add(0, node.val);
        }

        if (node.left != null) DFS(node.left, level + 1, results);
        if (node.right != null) DFS(node.right, level + 1, results);
      }

      public List<List<Integer>> zigzagLevelOrderDFS(TreeNode root) {
        if (root == null) {
          return new ArrayList<List<Integer>>();
        }
        List<List<Integer>> results = new ArrayList<List<Integer>>();
        DFS(root, 0, results);
        return results;
      }    
}
