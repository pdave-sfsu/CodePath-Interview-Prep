// https://www.interviewbit.com/problems/list-cycle/

/**
 * Definition for singly-linked list.
 * class ListNode {
 *     public int val;
 *     public ListNode next;
 *     ListNode(int x) { val = x; next = null; }
 * }
 */
public class Solution {
public ListNode detectCycle(ListNode a) {

								if (a.next == null || a.next.next == null) {
																return null;
								}

								ListNode slow = a.next;
								ListNode fast = a.next.next;

								while (fast.next != null && fast.next.next != null && fast != slow) {
																slow = slow.next;
																fast = fast.next.next;
								}

								if (fast == slow) {
																ListNode head = a;
																while (head != fast) {
																								head = head.next;
																								fast = fast.next;
																}
																return fast;
								}

								return null;
}
}
