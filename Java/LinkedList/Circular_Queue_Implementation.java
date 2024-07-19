class Circular_Queue {
  class Node {
    int data;
    Node next;

    public Node(int data) {
      this.data = data;
      this.next = null;
    }
  }

  Node front = null;
  Node rear = null;
  Node newNode;

  public boolean createNewNode(int data) {
    newNode = new Node(data);

    if(rear == null) {
      front = newNode;
      rear = newNode;
      return false;
    }
    else {
      return true;
    }
  }

  public boolean isEmpty() {
    if(front == null && rear == null) {
      System.out.println("Queue is empty");
      return true;
    }
    return false;
  }

  public void enQueue(int data) {
    if(createNewNode(data)) {
      rear.next = newNode; // Store the address of the new node into the next part of the rear node
      rear = newNode; // Make the new node as the rear

      rear.next = front; // Make the rear node point to the front node by storing the front's address
    }
  }

  public void deQueue() {
    if(!isEmpty()) {
      System.out.println("Dequeued element : " + front.data);
      front = front.next; // Move the front to the next node
      
      rear.next = front; // Make the rear node point to the front node
    }
  }

  public void displayQueue() {
    Node temp = front;

    while(temp != rear) {
      System.out.print(temp.data + " ");
      temp = temp.next;
    }
    System.out.print(temp.data + " ");
    System.out.println();
  }
}

public class Circular_Queue_Implementation {
  public static void main(String[] args) {
    Circular_Queue q = new Circular_Queue();

    q.enQueue(10);
    q.enQueue(20);
    q.enQueue(30);
    q.enQueue(40);
    q.enQueue(50);
    q.displayQueue();
    
    q.deQueue();
    q.displayQueue();

    q.deQueue();
    q.displayQueue();

    q.enQueue(70);
    q.enQueue(80);
    q.displayQueue();
    
    q.deQueue();
    q.displayQueue();
    
  }
}