package com.fillipelima.graphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}

public class CloneGraph {
    HashMap<Node, Node> map = new HashMap<Node, Node>();
    
    public Node cloneGraph(Node node) {
        if (node == null)
            return null;
        
        if (map.containsKey(node))
            return map.get(node);
        
        Node n = new Node(node.val, new ArrayList<Node>());        
        map.put(node, n);        
        
        for (Node e : node.neighbors) {
            n.neighbors.add(cloneGraph(e));
        }
        
        return n;
    }
}
