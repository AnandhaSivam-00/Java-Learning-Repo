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
        if(head == null || head.next == null || k == 0) {
            return head;
        }

        ListNode current = head;
        int size = 1;

        while(current.next != null) {
            current = current.next;
            size++;
        }
        k = k % size;     // Important if the k is greater than the size of the list
        int untill = size - k;    // Travsersing the list untill the kth node from the end
        current.next = head;

        while(untill-- > 0) {
            current = current.next;
        }
        head = current.next;
        current.next = null;

        return head;
    }
}