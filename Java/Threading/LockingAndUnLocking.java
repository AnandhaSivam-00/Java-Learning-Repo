import java.util.concurrent.locks.*;
import java.util.*;

class SharedResoureces {
    private int count = 0;
    Lock lock = new ReentrantLock();

    protected void increment() {
      lock.lock();
      try {
        count++;
      }
      finally {
        lock.unlock();
      }
    }

    protected void decrement() {
      lock.lock();
      try {
        count--;
      }
      finally {
        lock.unlock();
      }
    }

    protected int getCount() {
      lock.lock();
      try {
        return count;
      }
      finally {
        lock.unlock();
      }
    }
}

class Incrementer extends Thread {
  SharedResoureces resources;

  public Incrementer(SharedResoureces resources) {
    this.resources = resources;
  }

  public void run() {
    for(int i=0; i<100; i++) {
      resources.increment();
    }
  }
}


class Decrementer extends Thread {
  SharedResoureces resources;

  public Decrementer(SharedResoureces resources) {
    this.resources = resources;
  }

  public void run() {
    for(int i=0; i<10; i++) {
      resources.decrement();
    }
  }
}


public class LockingAndUnLocking {
  public static void main(String args[]) {
    SharedResoureces resources = new SharedResoureces();
    Incrementer incrementer = new Incrementer(resources);
    Decrementer decrementer = new Decrementer(resources);

    incrementer.start();
    decrementer.start();

    try {
      incrementer.join();
      decrementer.join();
    }
    catch(InterruptedException e) {
      e.printStackTrace();
    }

    System.out.println("Count: " + resources.getCount());
  }
}

