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

    public ListNode oddEvenList(ListNode head) {
        if(head == null || head.next == null) {
            return head;
        }
        // Creating temp nodes for insertion
        ListNode evenList = head.next;
        ListNode oddList = head;
        ListNode temp = evenList;


        while(evenList != null && evenList.next != null) {
            oddList.next = oddList.next.next;
            oddList = oddList.next;
            evenList.next = evenList.next.next;
            evenList = evenList.next;
        }
        oddList.next = temp;

        return head;
    }
}