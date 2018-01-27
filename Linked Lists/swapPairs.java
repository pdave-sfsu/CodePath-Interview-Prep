/**
 * Definition for singly-linked list.
 * class ListNode {
 *     public int val;
 *     public ListNode next;
 *     ListNode(int x) { val = x; next = null; }
 * }
 */
public class Solution {
public ListNode swapPairs(ListNode A) {
        if (A == null || A.next == null) return A;
        ListNode prev = A;
        ListNode ahead = A.next;
        A = ahead;
        while (true) {
                ListNode temp = ahead.next;
                ahead.next = prev;
                if (temp == null || temp.next == null) {
                        prev.next = temp;
                        break;
                }
                prev.next = temp.next;
                prev = temp;
                ahead = prev.next;
        }
        return A;
}
}
