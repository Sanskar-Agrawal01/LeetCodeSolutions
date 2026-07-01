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
    public ListNode sortList(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode start = mid(head);
        ListNode mnext = start.next;
        start.next = null;

        ListNode left = sortList(head);
        ListNode right = sortList(mnext);

        return sort(left, right);

    }
    public static ListNode mid(ListNode node){
        if(node == null) return node;
        ListNode slow = node;
        ListNode fast = node.next;
        while(fast != null && fast.next!= null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
    public ListNode sort(ListNode a, ListNode b){
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;
        while(a != null && b != null){
            if(a.val > b.val){
                curr.next = b;
                b = b.next;
            }
            else{
                     curr.next = a;
                     a = a.next;
            }
            curr =  curr.next;
        }
        if(a != null){
            curr.next = a;      
        }
        else{
            curr.next = b;
        }
        return dummy.next;
    }
}