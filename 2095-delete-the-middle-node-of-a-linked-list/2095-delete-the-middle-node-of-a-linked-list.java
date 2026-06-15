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
    public ListNode deleteMiddle(ListNode head) {
        if(head == null || head.next == null){
            return null;
        }
        int n = 0;
        ListNode curr = head;
        while(curr != null){
            curr = curr.next;
            n++;
        }
        n = n /2;
        curr = head;
        for(int i = 0;i<n - 1;i++){
            curr = curr.next;
        }
        curr.next = curr.next.next;
        return head;
    }
}