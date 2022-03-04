package com.fillipelima.linkedlist;

public class ReverseLinkedList {
    public ListNode reverseList(ListNode head) {
        if (head == null)
            return null;
        ListNode prev = head;
        ListNode curr = head.next;
        prev.next = null;        
        while (curr != null) {            
            ListNode copy = curr.next;            
            
            curr.next = prev;
            
            prev = curr;
            curr = copy;
             
        }
        return prev;
    }	
}
