package com.fillipelima.linkedlist;

import java.util.HashMap;
import java.util.Map;

class CopyRandomList {
    Map<Node, Node> map = new HashMap<Node, Node>();
    
    public Node copyRandomList(Node head) {
        if (head == null)
            return null;
        
        if (map.containsKey(head))
            return map.get(head);
        
        Node n = new Node(head.val);
        
        map.put(head, n);
        
        n.next = copyRandomList(head.next);
        n.random = copyRandomList(head.random);
        
        return n;
    }
    
    class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }
        
}
