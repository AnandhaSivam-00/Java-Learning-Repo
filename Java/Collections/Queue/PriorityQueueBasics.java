import java.util.*;

public class PriorityQueueBasics {
  public static void main(String args[]) {
    PriorityQueue<Integer> pq = new PriorityQueue<>();

    pq.add(10);
    pq.add(50);
    pq.add(40);
    pq.add(30);
    pq.add(20);

    System.out.println(pq);

    System.out.println("Peek Element : " + pq.peek());
    System.out.println("Poll Elements");
    System.out.println(pq.poll());
    System.out.println(pq.poll());
    System.out.println(pq.poll());
    System.out.println(pq.poll());
    System.out.println(pq);
  }
}