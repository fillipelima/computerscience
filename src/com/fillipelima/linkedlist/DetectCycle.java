package com.fillipelima.linkedlist;

class DetectCycle {

    public ListNode detectCycle(ListNode head) {
        boolean isCycle = false;
        if(head==null) return null;
        ListNode walker = head;
        ListNode runner = head;
        while(runner.next!=null && runner.next.next!=null) {
            walker = walker.next;
            runner = runner.next.next;
            if(walker==runner){
                isCycle = true;
                break;
            } 
                
        }
        if (isCycle) {
            ListNode walker2 = head;
            while (walker != walker2) {
                walker = walker.next;
                walker2 = walker2.next;
            }
            return walker;            
        }else{
            return null;
        }

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