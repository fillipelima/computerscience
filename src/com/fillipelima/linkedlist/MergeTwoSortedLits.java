package com.fillipelima.linkedlist;

class MergeTwoSortedLits {

	ListNode head;

	public static void main(String[] args) {

		ListNode node4 = new MergeTwoSortedLits().new ListNode(4);
		ListNode node2 = new MergeTwoSortedLits().new ListNode(2);
		ListNode node1 = new MergeTwoSortedLits().new ListNode(1);
		node1.next = node2;
		node2.next = node4;

		ListNode node24 = new MergeTwoSortedLits().new ListNode(4);
		ListNode node23 = new MergeTwoSortedLits().new ListNode(3);
		ListNode node21 = new MergeTwoSortedLits().new ListNode(1);
		node21.next = node23;
		node23.next = node24;

		MergeTwoSortedLits mergeTwoSortedLits = new MergeTwoSortedLits();
		mergeTwoSortedLits.mergeTwoLists(node1, node21);
	}

	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {

		if (l1 == null)
			return l2;
		if (l2 == null)
			return l1;

		ListNode head = l2;

		ListNode curr1 = l1;
		while (curr1 != null) {
			ListNode aux = curr1;
			curr1 = curr1.next;

			ListNode curr2 = head;
			boolean inserted = false;
			while (curr2 != null) {
				if ((curr2.next == null && aux.val >= curr2.val)
						|| (curr2.next != null && aux.val >= curr2.val && aux.val <= curr2.next.val)) {
					aux.next = curr2.next;
					curr2.next = aux;
					inserted = true;
					break;
				}
				curr2 = curr2.next;
			}
			if (!inserted) {
				aux.next = head;
				head = aux;
			}
		}
		return head;
	}

	// Recursive
	public ListNode mergeTwoListsRecursive(ListNode l1, ListNode l2) {

		if (l1 == null)
			return l2;
		if (l2 == null)
			return l1;

		if (l1.val < l2.val) {
			l1.next = mergeTwoLists(l1.next, l2);
			return l1;
		} else {
			l2.next = mergeTwoLists(l1, l2.next);
			return l2;
		}
	}

	// Iterative better
	public ListNode mergeTwoListsIterativeBetter(ListNode list1, ListNode list2) {
		ListNode head = new ListNode(0);
		ListNode curr = head;
		while (list1 != null && list2 != null) {
			if (list1.val <= list2.val) {
				curr.next = list1;
				list1 = list1.next;
			} else {
				curr.next = list2;
				list2 = list2.next;
			}
			curr = curr.next;
		}
		if (list1 != null) {
			curr.next = list1;
		} else if (list2 != null) {
			curr.next = list2;
		}
		return head.next;
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
