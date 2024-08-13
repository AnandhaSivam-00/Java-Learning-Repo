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
    protected static ListNode findingKthNode(ListNode list, int k) {
        while(list != null && --k > 0) {
            list = list.next;
        }

        return list;
    }

    protected static ListNode reverseSubLL(ListNode list) {
        if(list == null || list.next == null) {
            return list;
        }

        ListNode prev = null;
        ListNode current = list;
        ListNode front;

        while(current != null) {
            front = current.next;
            current.next = prev;
            prev = current;
            current = front;
        }

        return prev;
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        if(head == null || head.next == null) {
            return head;
        }

        ListNode temp = head;
        ListNode nextNode; // To go to the next Node before break the link.
        ListNode prevNode = null; // To preserve the past LL's last node for linking the next set of LL's

        while(temp != null) {
            ListNode KthNode = findingKthNode(temp, k);

            if(KthNode == null) {  // If the KthNode is the last Node and previous node is not null, then past LL is exists, we wants to link that with the remaining nodes
                if(prevNode != null) {
                    prevNode.next = temp;
                }
                break;
            }
            else {
                nextNode = KthNode.next; // Before break the link go to next node
                KthNode.next = null;

                reverseSubLL(temp); // After reverse all the pointer's positions are preserved on the same positions.

                if(temp == head) { // For first separation only applicable
                    head = KthNode;
                }
                else {
                    prevNode.next = KthNode;
                }

                prevNode = temp;
                temp = nextNode;

            }
        }
        return head;
    }
}