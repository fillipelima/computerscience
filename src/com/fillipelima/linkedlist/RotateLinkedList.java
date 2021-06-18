package com.fillipelima.linkedlist;

import java.util.LinkedList;

class RotateLinkedList {

    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || k == 0)
            return head;
        LinkedList<ListNode> list = new LinkedList<ListNode>();
        ListNode curr = head;
        int len = 0;
        while (curr != null) {
            list.add(curr);
            len++;
            curr = curr.next;
        }
        
        int rotate = k % len;
        
        if (rotate == 0 || head.next == null)
            return head;
        
        while (rotate > 0 && !list.isEmpty()) {            
            ListNode tail = list.removeLast();
            ListNode beforeTail = list.getLast();
            if (beforeTail != null) {
                beforeTail.next = null;
                tail.next = list.getFirst();
                list.addFirst(tail);
            }
            rotate--;
        }
        
        return list.getFirst();
        
    }

	class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
			next = null;
		}
	}
}