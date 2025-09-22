// Create a thread that prints a random greeting every 2 seconds. 
// If the greeting is "Vanakkam", then the thread should be interrupted.


import java.util.*;

class ThreadingClass extends Thread {
  private List<String> randomGreetings = Arrays.asList("Hello", "Bonjour", "Hola", "Ciao", "Namaste", "Vanakkam", "Kon'nichiwa", "Annyeonghaseyo", "Salam", "Sawubona");
  
  @Override
  public void run() {
    try {
      while(true) {
        int randomIndex = (int)(Math.random() * randomGreetings.size());
        System.out.println(randomGreetings.get(randomIndex));

        Thread.sleep(2000);

        if(randomGreetings.get(randomIndex).equals("Vanakkam")) {
          Thread.currentThread().interrupt();
        }
      }
    }
    catch(InterruptedException e) {
      System.out.println("Thread has been interrupted.");
    }
    catch(Exception e) {
      System.out.println(e);
    }
  }
}

public class NewThread {
  public static void main(String[] args) {
    Thread t1 = new ThreadingClass();
    t1.start();
  }
}