class Queue {
  class  Node {
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

    if(front == null && rear == null) {
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
      rear.next = newNode;
      rear = newNode;
    }
  }

  public void deQueue() {
    if(!isEmpty()) {
      System.out.println("Dequeued element : " + front.data);
      front = front.next;
    }
  }

  public void displayQueue() {
    Node temp = front;

    while(temp != null) {
      System.out.print(temp.data + " ");
      temp = temp.next;
    }
    System.out.println();
  }
}

public class Queue_Implementation {
  public static void main(String[] args){
    Queue q = new Queue();

    q.enQueue(10);
    q.enQueue(20);
    q.enQueue(30);
    q.enQueue(40);
    q.enQueue(50);
    q.displayQueue();
    
    q.deQueue();
    q.displayQueue();
    
  }
}