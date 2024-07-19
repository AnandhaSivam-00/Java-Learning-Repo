import java.lang.*;

class Node_Creation {
  // Creating a node
  class Node {
    int data;
    Node next;

    Node(int data) {
      this.data = data;
      next = null;
    }
  }

  // Initial state of head
  Node head = null;
  Node newNode;

  public void insertBeginning(int data) {

    if(creatingNewNode(data)) {
      // Store the address of the head to the next of the new node
      newNode.next = head;

      // Make the new node as head
      head = newNode;
    }
  }

  public boolean creatingNewNode(int data) {
    // Creating a new node
    newNode = new Node(data);

    if(head == null) {
      head = newNode; // Make new node as head
      return false;
    }
    return true;
  }

  public void insertEnd(int data) {

    if(creatingNewNode(data)) {
      Node ptr = head;

      while(ptr.next != null) {
        ptr = ptr.next;
      }
      ptr.next = newNode;
    }
  }

  public void insertAfter(int data, int after) {
    if(after < 0 || after > linkedlistLength(head)) {
      System.out.println("Invalid position");
      return;
    }
    else if(creatingNewNode(data)) {
      Node ptr = head;

      // Traverse till the position
      while(--after > 0) {
        ptr = ptr.next;
      }
      newNode.next = ptr.next; // Make the new node as the next of the ptr
      ptr.next = newNode; //
    }
  }

  public void deleteNode(int num) {
    
    if(head == null) {
      // if head is null, then the linked list is empty
      System.out.println("List is empty");
      return;
    }
    
    if(head.data == num) {
      // if we found the num in a first position, we simply move the head to the next position
      head = head.next;
      return;
    }
    
    Node ptr = head;
    while(ptr.next != null && ptr.next.data != num) {
      ptr = ptr.next;
    }
    if(ptr.next == null) {
      System.out.println("Element not found");
    }
    else {
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

public class LinkedList_Creation {
  public static void main(String args[]) {
    Node_Creation n = new Node_Creation();
  
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
