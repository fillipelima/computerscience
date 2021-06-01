package com.fillipelima.linkedlist;

class OddEvenLinkedList {

	public static void main(String[] args) {
		ListNode node5 = new OddEvenLinkedList().new ListNode(5);
		ListNode node4 = new OddEvenLinkedList().new ListNode(4);
		ListNode node3 = new OddEvenLinkedList().new ListNode(3);
		ListNode node2 = new OddEvenLinkedList().new ListNode(2);
		ListNode node1 = new OddEvenLinkedList().new ListNode(1);
		node1.next = node2;
		node2.next = node3;
		node3.next = node4;
		node4.next = node5;
		OddEvenLinkedList o = new OddEvenLinkedList();
		o.oddEvenList(node1);
	}
	
    public ListNode oddEvenList(ListNode head) {
        if (head == null)
            return null;
        if (head.next == null)
            return head;
        ListNode node = head;
        ListNode nodeNext = head.next;
        ListNode odd = head;
        ListNode even = head.next;
        ListNode curr = head.next.next;
        while (curr != null) {
            odd.next = curr;
            odd = curr;
            even.next = curr.next;
            even = curr.next;
            curr = curr.next == null ? null : curr.next.next;
        }
        odd.next = nodeNext;       
        return node;
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