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
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }

        ListNode res = lists[0];

        for (int i = 1; i < lists.length; i++) {
            res = merge(res, lists[i]);
        }

        return res;
    }

    public ListNode merge(ListNode a, ListNode b) {
        ListNode head = new ListNode(0);
        ListNode cur = head;

        while (a != null && b != null) {
            if (a.val <= b.val) {
                cur.next = a;
                a = a.next;
            } else {
                cur.next = b;
                b = b.next;
            }

            cur = cur.next;
        }

        if (a != null) {
            cur.next = a;

        } else if (b != null) {
            cur.next = b;
        }

        return head.next;
    }
}
