/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode prevReverse = null;
        ListNode nextReverse = null;
        ListNode cur = head;
        int i = 1;

        while (cur != null) {
            if (i + 1 == left) {
                prevReverse = cur;
            } else if (i - 1 == right) {
                nextReverse = cur;
            }

            cur = cur.next;
            i++;
        }

        cur = (prevReverse == null) ? head : prevReverse.next;
        ListNode prev = prevReverse;
        ListNode reverseStart = cur;
        i = left;

        while (i < right + 1) {
            System.out.println("cur: " + cur.val);
            ListNode tmpNext = cur.next;
            cur.next = prev;
            prev = cur;
            cur = tmpNext;
            i++;
        }
        ListNode reverseEnd = prev;

        reverseStart.next = nextReverse;
        if (prevReverse != null) prevReverse.next = reverseEnd;

        return (left == 1) ? reverseEnd : head;
    }
}