package com.fillipelima.linkedlist;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class OddEvenLinkedList {

    public boolean isPalindrome(ListNode head) {
        List<Integer> listOne = new ArrayList<Integer>(); 
        List<Integer> listTwo = new ArrayList<Integer>(); 
        while (head != null) {
            listOne.add(head.val);
            head = head.next;
        }
        listTwo.addAll(listOne);
        Collections.reverse(listTwo);
        return listOne.equals(listTwo);
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