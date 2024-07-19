import java.util.*;
import java.lang.Thread;

class ThreadingClass extends Thread {
  public void run() {
   for(int i=1; i<=5; i++) {
     try {
       Thread.sleep(1000);
     }
     catch(Exception e) {
       System.out.println(e);
     }
     System.out.println(Thread.currentThread().getName() + " : " + i);
   }
  }
}

public class Thread_Join {
  public static void main(String[] args) {
    ThreadingClass t1 = new ThreadingClass();
    ThreadingClass t2 = new ThreadingClass();
    ThreadingClass t3 = new ThreadingClass();
    
    t1.setName("Thread 1");
    t2.setName("Thread 2");
    t3.setName("Thread 3");

    t2.setPriority(Thread.MAX_PRIORITY); // Setting priority for the second thread.

    try {
      System.out.println(t1.isAlive());
      t1.start();
      System.out.println(t1.isAlive());
      t1.join();
      System.out.println(t2.isAlive());
      t2.start();
      System.out.println(t2.isAlive());
      t3.start();
      System.out.println(t3.isAlive());
    }
    catch(Exception e) {
      System.out.println(e);
    }
  }
}