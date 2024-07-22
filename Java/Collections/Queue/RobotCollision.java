import java.util.*;

class Robot {
  private int position;
  private int health;
  private String direction;

  public Robot(int position, int health, String direction) {
    this.position = position;
    this.health = health;
    this.direction = direction;
  }

  protected int getPosition() {
    return position;
  }

  protected int getHealth() {
    return health;
  }

  protected void setHealth(int health) {
    this.health = health;
  }

  protected String getDirection() {
    return direction;
  }
}

public class RobotCollision {

  protected static List<Integer> movingRobotProcess(int pos[], int health[], String direction[]) {
    int i;
    List<Integer> afterProcessHealth = new ArrayList<>();
    //List<Integer> result = new ArrayList<>();

    PriorityQueue<Robot> robots = new PriorityQueue<>(new Comparator<Robot>() {
      @Override
      public int compare(Robot r1, Robot r2) {
        return r1.getPosition() - r2.getPosition();
      }
    });

    // PriorityQueue<Robot> robots = new PriorityQueue<>((o1, o2) -> o1.getPosition() - o2.getPosition());
    
    Stack<Robot> stack = new Stack<>();

    for(i=0; i<pos.length; i++) {
      robots.offer(new Robot(pos[i], health[i], direction[i]));
    }

    // while(!robots.isEmpty()) {
    //   System.out.println(robots.peek().getPosition() + " " + robots.peek().getHealth() + " " + robots.peek().getDirection());
    //   robots.poll();
    // }

    while(!robots.isEmpty()) {
      if(robots.peek().getDirection().equals("R")) {
        stack.push(robots.poll());
      }
      else {
        while(!stack.isEmpty() && robots.peek().getHealth() > 0) {
          Robot r = stack.pop();

          if(r.getHealth() < robots.peek().getHealth()) {
            robots.peek().setHealth(robots.peek().getHealth() - 1);
            r.setHealth(0);
          }
          else if(r.getHealth() > robots.peek().getHealth()) {
            robots.peek().setHealth(0);
            r.setHealth(r.getHealth() - 1);
            stack.push(r);
          }
          else {
            robots.peek().setHealth(0);
            r.setHealth(0);
          }
        }
        robots.poll();
      }
    }

    while(!stack.isEmpty()) {
      afterProcessHealth.add(stack.pop().getHealth());
    }

    // Collections.sort(index, (o1, o2) -> o1.getPosition() - o2.getPosition());
    return afterProcessHealth;
  }
  
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int n = sc.nextInt(), i;

    int positions[] = new int[n];
    int healths[] = new int[n];
    String directions[] = new String[n];

    for(i = 0; i < n; i++) {
      positions[i] = sc.nextInt();
      healths[i] = sc.nextInt();
      directions[i] = sc.next();
    }

    System.out.println(movingRobotProcess(positions, healths, directions));
  }
}