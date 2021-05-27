package com.fillipelima.linkedlist;

class MyLinkedList {

    private Node head;
    
    /** Initialize your data structure here. */
    public MyLinkedList() {
        
    }
    
    /** Get the value of the index-th node in the linked list. If the index is invalid, return -1. */
    public int get(int index) {
        if (head == null || index < 0)
            return -1;
        Node curr = head;
        int count = 0;
        while (curr != null) {             
            if (count == index)
                return curr.val;
            curr = curr.next;
            count++;
        }
        return -1;
    }
    
    /** Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list. */
    public void addAtHead(int val) {
        Node n = new Node(val);
        n.next = head;
        head = n;
    }
    
    /** Append a node of value val to the last element of the linked list. */
    public void addAtTail(int val) {
        Node n = new Node(val);
        if (head == null) {
            head = n;
            return;
        }            
        Node curr = head;
        while (curr != null) {           
            if (curr.next == null) {
                curr.next = n;
                break;
            }
            curr = curr.next;
        }        
    }
    
    /** Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted. */
    public void addAtIndex(int index, int val) {
        Node prev = null;
        Node curr = head;        
        int count = 0;
        while (count <= index) {             
            if (count == index){
                Node n = new Node(val);                
                if (prev != null)
                    prev.next = n;
                else
                    head = n;                
                n.next = curr;                
                break;
            }
            prev = curr;
            curr = curr.next;
            count++;
        }        
    }
    
    /** Delete the index-th node in the linked list, if the index is valid. */
    public void deleteAtIndex(int index) {
        Node prev = null;
        Node curr = head;        
        int count = 0;
        while (curr != null) {             
            if (count == index){
                if (prev != null && curr.next != null){
                    prev.next = curr.next;
                }
                if (index == 0){
                    head = curr.next;
                }
                if (curr.next == null){
                    if (prev != null)
                        prev.next = null;
                    else
                        head = null;
                }                
                break;
            }
            prev = curr;
            curr = curr.next;
            count++;
        }          
    }
    
    class Node {
        int val;
        Node next;
        Node(int val) {
            this.val = val;
        }
    }
}
