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
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null || head.next == null) {
            return head;
        }

        ListNode result = new ListNode(0);
        ListNode ptr = result;
        int temp = -999;

        while(head != null) {
            if(head.next != null && (head.val == head.next.val || head.val == temp)) {
                temp = head.val;
            }
            else if(head.val != temp) {
                ptr.next = new ListNode(head.val);
                ptr = ptr.next;
            }
            head = head.next;
        }

        return result.next;

    }
}