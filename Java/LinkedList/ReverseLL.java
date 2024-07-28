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
    public ListNode reverseList(ListNode head) {
        if(head == null) {
            return null;
        }
        else if(head.next == null) {
            return head;
        }
        else {
            ListNode temp = head;
            ListNode prev = null;
            ListNode front;

            while(temp != null) {
                front = temp.next;
                temp.next = prev;
                prev = temp;
                temp = front;
            }

            return prev;  // Lastly prev points to the last value
        }
    }
}