package com.fillipelima.linkedlist;

import java.math.BigDecimal;
import java.util.Stack;

class AddTwoNumbers {

	ListNode head;

	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		Stack<Integer> stack1 = new Stack<Integer>();
		Stack<Integer> stack2 = new Stack<Integer>();

		while (l1 != null) {
			stack1.push(l1.val);
			l1 = l1.next;
		}

		while (l2 != null) {
			stack2.push(l2.val);
			l2 = l2.next;
		}

		StringBuilder sb1 = new StringBuilder();
		while (!stack1.isEmpty()) {
			sb1.append(stack1.pop());
		}

		StringBuilder sb2 = new StringBuilder();
		while (!stack2.isEmpty()) {
			sb2.append(stack2.pop());
		}

		BigDecimal sum = new BigDecimal(sb1.toString()).add(new BigDecimal(sb2.toString()));

		String sumStr = sum.toString();

		ListNode head = null;

		ListNode currNode = null;

		for (int i = sumStr.length() - 1; i >= 0; i--) {
			ListNode node = new ListNode(Character.getNumericValue(sumStr.charAt(i)));
			if (head == null) {
				head = node;
				currNode = head;
			} else {
				currNode.next = node;
				currNode = currNode.next;
			}
		}

		return head;

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
