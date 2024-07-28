class Solution {
    public Node deleteNode(Node head, int x) {
        if(head == null) {
            return head;
        }
        else if(x == 1) {
            head = head.next;
            head.prev = null;
        }
        else {
            Node ptr = head;

            while(x-- > 1) {
                ptr = ptr.next;
            }

            if(ptr.next == null) {
                ptr.prev.next = null;
                ptr.prev = null;
            }
            else {
                ptr.prev.next = ptr.next;
                ptr.next.prev = ptr.prev;
                ptr.next = null;
                ptr.prev = null;
            }


        }
        return head;
    }
}