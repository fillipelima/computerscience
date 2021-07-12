package com.fillipelima.linkedlist;

public class InsertIntoASortedCirucularLinkedList {
    public Node insert(Node head, int insertVal) {
        Node n = new Node(insertVal);
        
        if (head == null) {        
            n.next = n;
            return n;
        }
        
        if (head.next == head) {
             n.next = head;
             head.next = n;
            return head;
        }
        
        Node prev = null;              
        Node curr = head;
        boolean inserted = false;
        while (!inserted) {
            if (prev != null && insertVal <= curr.val && (insertVal >= prev.val || prev.val > curr.val)) {
                prev.next = n;
                n.next = curr;
                inserted = true;
            }
            if (insertVal > curr.val && (insertVal < curr.next.val || curr.val > curr.next.val)) {
                n.next = curr.next;
                curr.next = n; 
                inserted = true;
            }
            if ((curr.next == head) && !inserted) {
                curr.next = n;
                n.next = head;
                break;
            }
            prev = curr;    
            curr = curr.next;                        
        }
        return head;
    }
    class Node {
        public int val;
        public Node next;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _next) {
            val = _val;
            next = _next;
        }
    };    
}
