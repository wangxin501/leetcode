package interview.leetcode.linkedlist;

public class LinkedListCycle {

	/**
	 * Given a linked list, determine if it has a cycle in it.
	 * 
	 * Follow up: Can you solve it without using extra space?
	 */

	public boolean hasCycle1(ListNode head) {

		if (head == null)
			return false;

		ListNode fast = head;
		ListNode slow = head;

		while (fast.next != null && fast.next.next != null) {
			fast = fast.next.next;
			slow = slow.next;
			if (slow == fast)
				return true;
		}

		return false;
	}

	public boolean hasCycle(ListNode head) {

		if (head == null)
			return false;
		ListNode p = head;
		ListNode p2 = head;
		while (true) {
			if (p == null || p2 == null)
				return false;
			p = p.next;
			if (p2.next == null)
				return false; // wrong here miss the check for null
			p2 = p2.next.next;
			if (p == p2) {
				return true;
			}
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
