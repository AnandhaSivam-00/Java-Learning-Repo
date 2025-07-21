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
        ListNode ptr = head;
        ListNode after = head;

        while(ptr != null && ptr.next != null) {
            after = ptr.next;
            while(after != null && ptr.val == after.val) {
                ptr.next = after.next;
                after = after.next;
            }
            ptr = ptr.next;
        }

        return head;
    }
}