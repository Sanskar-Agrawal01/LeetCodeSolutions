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
    public int pairSum(ListNode head) {
        if(head.next == null){
            return head.val;
        }
        if(head.next.next == null){
            return head.val + head.next.val;
        }
        int n = 0;
        ListNode curr = head;
        while (curr != null) {
            curr = curr.next;
            n++;
        }
        ListNode temp = head;
        n = n / 2;
        for (int i = 0; i < n -1 ; i++) {
            temp = temp.next;
        }
        ListNode tail = temp.next;
        tail = reverse(tail);
        int max = 0;
        for (int i = 0; i < n; i++) {
            max = Math.max(max, head.val + tail.val);
            head = head.next;
            tail = tail.next;
        }

        return max;
    }

    public static ListNode reverse(ListNode head) {
        ListNode prev = null;
        ListNode next = head;
        while (head != null) {
            next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        return prev;
    }
}