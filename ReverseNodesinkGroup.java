/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        int count = 0;
        ListNode curt = head;

        while (curt != null && count < k) {
            curt = curt.next;
            count++;
        }

        if (count == k) {
            curt = reverseKGroup(curt, k);

            ListNode newHead = null;
            ListNode tail = head;
            ListNode tmpHead = head;

            while (count-- > 0) {
                tmpHead = head.next;
                head.next = newHead;
                newHead = head;
                head = tmpHead;
            }

            tail.next = curt;
            return newHead;

        } else {
            return head;
        }
    }
}