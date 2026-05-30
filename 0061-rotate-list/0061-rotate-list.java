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
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null)
            return null;
        if (head.next == null)
            return head;
        if( k == 0) return head;
        int n = 1;
        ListNode curr = head;
        while (curr.next != null) {
            curr = curr.next;
            n++;
        }
        k = k % n;
        int temp = n - k;

        curr.next = head;
        ListNode tail = head;
        for (int i = 1; i < temp; i++) {
            tail = tail.next;
        }
        ListNode ptr = tail.next;
        tail.next = null;
        return ptr;

    }
}