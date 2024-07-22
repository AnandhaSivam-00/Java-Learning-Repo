import java.util.*;

class Task {
  private int id;
  private String taskName;
  private int priority;

  public Task(int id, int priority, String taskName) {
    this.id = id;
    this.taskName = taskName;
    this.priority = priority;
  }

  protected int getId() {
    return id;
  }
  protected String getTaskName() {
    return taskName;
  }
  protected int getPriority() {
    return priority;
  }
}

public class TaskExecution {
  public static void main(String args[]) {
    Scanner sc = new Scanner(System.in);
    boolean flag = true;
    int priority, id, counter = 1;
    String task = "Task ";

    PriorityQueue<Task> execution = new PriorityQueue<>((o1, o2) -> o1.getPriority() - o2.getPriority());

    while(flag) {
      System.out.println("Enter the id: ");
      id = sc.nextInt();
      System.out.println("Enter the priority: ");
      priority = sc.nextInt();
      execution.add(new Task(id, priority, task + Integer.toString(counter)));
      counter++;

      System.out.println("Do you want to add more tasks? (y/n)");
      if(sc.next().equals("n")) {
        flag = false;
      }
    }

    while(!execution.isEmpty()) {
      System.out.println(execution.peek().getTaskName() + " Id: " + execution.peek().getId() + " Priority: " + execution.peek().getPriority());
      System.out.println(execution.poll());
    }
  }
}