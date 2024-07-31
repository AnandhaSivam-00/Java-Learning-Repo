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
        if(head == null) {
            return head;
        }
        else if(head.next == null) { // For single node
            head = null;
            return head;
        }
        else if(head.next.next == null) { // For two nodes only
            ListNode ptr = head;
            ptr = head.next;
            ptr = null;
            head.next = null;
            return head;
        }
        else {  // For more than two nodes
            ListNode fast = head.next; // move the fast pointer one step forward
            ListNode slow = head;

            while(fast.next != null && fast.next.next != null) {
                slow = slow.next;
                fast = fast.next.next;
            }

            // For unlinking the node
            ListNode del = slow.next;

            slow.next = del.next;
            del.next = null;

            return head;
        }
    }
}