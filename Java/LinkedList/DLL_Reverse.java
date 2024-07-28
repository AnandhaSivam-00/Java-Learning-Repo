/*
class Node
{
    int data;
    Node next, prev;
    Node(int data)
    {
        this.data = data;
        this.next = null;
        this.prev = null;
    }
}

*/
public static Node reverseDLL(Node  head)
{
    //Your code here
    if(head == null || head.next == null) {
        return head;
    }
    else {
        Node current = head;
        Node front = null;

        while(current != null) {
            front = current.prev;
            current.prev = current.next;
            current.next = front;
            current = current.prev;
        }

        return front.prev;
    }

}