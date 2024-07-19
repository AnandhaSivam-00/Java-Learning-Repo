import java.lang.*;

class Doubly_Node_Creation {
  class Node {
    int data;
    Node next;
    Node prev;

    Node(int data) {
      this.data = data;
      next = null;
      prev = null;
    }
  }

  // Initial state of head
  Node head = null;
  Node newNode;

  public boolean creatingNewNode(int data) {
    // Creating a new node
    newNode = new Node(data);

    if(head == null) {
      head = newNode; // Make new node as head
      return false;
    }
    return true;
  }

  public void insertBeginning(int data) {

    if(creatingNewNode(data)) {
      // Store the address of the head to the next of the new node
      newNode.next = head; 
      // Store the address of the new node to the previous of the head
      head.prev = newNode;

      // Make the new node as head
      head = newNode;
    }
    else {
      return;
    }
  }

  public void insertEnd(int data) {

    if(creatingNewNode(data)) {
      Node ptr = head;

      while(ptr.next != null) {
        ptr = ptr.next;
      }

      // Store the address of the new node to the next of the ptr
      ptr.next = newNode;
      // Store the address of the ptr to the previous of the new node
      newNode.prev = ptr;
    }
  }

  public void insertAfter(int data, int after) {
    if(after < 0 || after > linkedlistLength(head)) {
      System.out.println("Invalid position");
      return;
    }
    else if(creatingNewNode(data)) {
      Node ptr = head;

      while(--after > 0) {
        ptr = ptr.next;
      }

      // Store the address of the ptr node to the new node's previous area
      newNode.prev = ptr;
      // Store the address of the current pointers next part into the new node's next area
      newNode.next = ptr.next;
      // Store the address of the new node to the ptr node's next area
      ptr.next = newNode;
      // Store the address of the new node to the ptr node's next node's previous area
      ptr.next.prev = newNode;
    }
  }

  public void deleteNode(int num) {
    if(head == null) {
      // if head is null, then the linked list is empty
      System.out.println("List is empty");
      return;
    }
    if(head.data == num) {
      head = head.next;
      return;
    }
      Node ptr = head;

      while(ptr.next != null && ptr.next.data != num) {
        ptr = ptr.next;
      }
      if(ptr.next == null) {
        System.out.println("Element not found");
        return;
      }
      else {
        //ptr.next = ptr.next.next;
        ptr.next.prev = ptr;
        ptr.next = ptr.next.next;
      }
  }

  public void printList() {
    // Creating temp as pointer to traverse
    Node temp = head;
    while(temp != null) {
      System.out.print(temp.data + " ");
      temp = temp.next;
    }
    System.out.println();
  }

  public int linkedlistLength(Node ptr) {
    int counter = 0;
    while(ptr != null) {
      counter++;
      ptr = ptr.next;
    }

    return counter; 
  }
}

public class Doubly_LinkedList_Creation {
  public static void main(String args[]) {
    Doubly_Node_Creation n = new Doubly_Node_Creation();

    n.insertBeginning(10);
    n.insertBeginning(20);
    n.insertBeginning(30);
    n.insertBeginning(40);
    n.insertBeginning(50);
    System.out.println("Inserting at the beginning : ");
    n.printList();


    n.insertEnd(60);
    n.insertEnd(70);
    System.out.println("Inserting at the end : ");
    n.printList();

    n.insertAfter(80, 3);
    System.out.println("Inserting at the given position : ");
    n.printList();

    n.deleteNode(70);
    System.out.println("Delete a node : ");
    n.printList();
  }
}