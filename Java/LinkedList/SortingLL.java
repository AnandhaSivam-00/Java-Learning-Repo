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
    protected static ListNode findMiddle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head.next;

        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

    protected static ListNode mergeTwoLL(ListNode left, ListNode right) {
        ListNode resultList = new ListNode(-1);
        ListNode temp = resultList;

        while(left != null && right != null) {
            if(left.val <= right.val) {
                temp.next = left;
                left = left.next;
            }
            else {
                temp.next = right;
                right = right.next;
            }
            temp = temp.next;
        }

        if(left != null) {
            temp.next = left;
        }
        else {
            temp.next = right;
        }

        return resultList.next;
    }

    public ListNode sortList(ListNode head) {
        if(head == null || head.next == null) {
            return head;
        }

        ListNode midPtr = findMiddle(head);

        ListNode left = head;
        ListNode right = midPtr.next;
        midPtr.next = null;

        left = sortList(left);
        right = sortList(right);

        return mergeTwoLL(left, right);
    }
}