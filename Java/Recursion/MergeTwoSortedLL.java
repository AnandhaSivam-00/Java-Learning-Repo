import java.util.*;

class Node {
  int data;
  Node next;

  Node(int data) {
    this.data = data;
    this.next = null;
  }
}

public class MergeTwoSortedLL {
  protected static Node mergeTwoSortedLL(Node A, Node B) {
    if(A == null) {
      return B;
    }
    if(B == null) {
      return A;
    }

    if(A.data < B.data) {
      A.next = mergeTwoSortedLL(A.next, B);
      return A;
    }
    else {
      B.next = mergeTwoSortedLL(A, B.next);
      return B;
    }
  }
  
  public static void main(String args[]) {
    Node A = new Node(1);
    Node n1 = new Node(8);
    Node n2 = new Node(22);
    Node n3 = new Node(40);
    
    Node B = new Node(4);
    Node n4 = new Node(11);
    Node n5 = new Node(16);
    Node n6 = new Node(20);

    A.next = n1;
    n1.next = n2;
    n2.next = n3;
    
    B.next = n4;
    n4.next = n5;
    n5.next = n6;
    Node head = mergeTwoSortedLL(A, B);

    while(head != null) {
      System.out.print(head.data + " ");
      head = head.next;
    }
  }
}