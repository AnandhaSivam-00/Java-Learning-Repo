class Stack {

  class Node {
    int data;
    Node next;

    public Node(int data) {
      this.data = data;
      this.next = null;
    }
  }

  Node top = null;
  Node newNode;

  public boolean creatingNewNode(int data) {
    // Creating a new node
    newNode = new Node(data);

    if(top == null) {
      top = newNode; // Make new node as top
      return false;
    }
    return true;
  }

  public boolean isEmpty() {
    // check for empty stack
    if(top == null) {
      System.out.println("Stack is empty");
      return true;
    }
    return false;
  }

  public void push(int data) {
    if(creatingNewNode(data)) {
      newNode.next = top; // Store the address of the top into the next part of the new node
      top = newNode; // Make the new node as top
    }
  }

  public void pop() {
    if(!isEmpty()) { 
      System.out.println("Popped element : " + top.data);
      top = top.next; // Move the top to the next node
    }
  }

  public void peek() {
    if(!isEmpty()) {
      System.out.println("Stacks Peek Element : " + top.data);
    }
  }

  public void displayStackItem() {
    Node temp = top;
    
    while(temp != null) {
      System.out.print(temp.data + " ");
      temp = temp.next;
    }
    System.out.println();
  }
  
}

public class Stack_Implementation {
  public static void main(String[] args) {
    Stack s = new Stack();

    s.push(10);
    s.push(20);
    s.push(30);
    s.push(40);
    s.push(50);
    s.displayStackItem();  

    s.pop();
    s.displayStackItem();

    s.peek();
  }
}