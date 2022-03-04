package com.fillipelima.linkedlist;

class ListNode {
     int val;
     ListNode next;
     ListNode() {}
     ListNode(int val) { this.val = val; }
     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
 
public class ReverseLinkedListBetween {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (head == null)
            return null;
        
        if (head.next == null || left == right)
            return head;
        
        // find Left Node and the Node before
        ListNode currNode = head;
        ListNode leftNode = null;        
        ListNode prevLeftNode = null;
        int count = 1;
        while (currNode != null) {
            if (count == left) {
                leftNode = currNode;
                break;
            }
            prevLeftNode = currNode;
            currNode = currNode.next;
            count++;
        }
        
        // Disconnect Node before left
        if (prevLeftNode != null)
            prevLeftNode.next = null;
        
        // Find Right Node
        ListNode rightNode = null;
        while (currNode != null) {
            if (count == right) {
                rightNode = currNode;
                break;
            }
            currNode = currNode.next;
            count++;
        }
        
        // Keep the rightNode.next
        ListNode rightNodeNext = rightNode != null ? rightNode.next : null;
        
        // Reverse
        // Prev starts with leftNode or Head
        ListNode prev = leftNode == null ? head : leftNode;
        ListNode curr = prev.next;
        prev.next = null;
        // Take a copy of starting node, to connect it later
        ListNode prevCopy = prev;
        count = left+1;
        while (curr != null) {
            
            ListNode copy = curr.next;
            
            curr.next = prev;
            
            prev = curr;   
            
            if (count == right)
                break;
            
            curr = copy;
            count++;
            
        }
        
        // Connect prev copy to right next
        prevCopy.next = rightNodeNext;
        
        // Connect node before left to curr prev
        if (prevLeftNode != null) {
            prevLeftNode.next = prev;
            return head;
        }else{
            return prev;
        }            
            
    }
}
