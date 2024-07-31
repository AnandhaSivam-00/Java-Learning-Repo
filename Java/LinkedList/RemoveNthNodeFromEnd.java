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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head == null) {
            return head;
        }
        else if(head.next == null) {
            head = null;
            return head;
        }
        else {
            ListNode ptr = head;
            int listLength = 0, nodePosition;

            while(ptr != null) {
                ptr = ptr.next;
                listLength++;
            }

            if(listLength == n) {
                return head.next;
            }

            nodePosition = listLength - n ;
            ListNode delPtr = head;

            while(delPtr != null) {
                nodePosition--;
                if(nodePosition == 0) {
                    break;
                }
                delPtr = delPtr.next;
            }

            delPtr.next = delPtr.next.next;
            return head;
        }
    }
}