package com.fillipelima.linkedlist;

import java.util.Stack;

class FlattenDoublyLinkedList {
    
    Stack<Node> keepStack = new Stack<Node>();
    
    public Node flatten(Node head) {
        
        if (head == null) {
            return null;
        }
        
        if (head.next == null && head.child == null) {
            if (!keepStack.isEmpty()) {
                Node n = keepStack.pop();
                n.prev = head;
                head.next  = flatten(n);                
            }
        }
        
        if (head.child != null) {
            head.child.prev = head;
            keepStack.push(head.next);
            head.next = flatten(head.child);
        }else if (head.next != null) {
            head.next = flatten(head.next);
        }        
        
        return head;
        
    }
    
    class Node {
        public int val;
        public Node prev;
        public Node next;
        public Node child;
        public Node(int n) {
        	val = n;
        }
    }
        
}
