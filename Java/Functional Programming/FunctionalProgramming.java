import java.util.Scanner;
// import java.util.Function;

@functionalInterface
public interface Prittifier {
  public abstract String prittifyObject(Object o); // Parameter is cannot be a primitive type
}

// Implementing the functional interface using the lamda expression
public class FunctionalProgramming {
  public static void main(String args[]) {
    Prittifier p = x -> "*~*~ " + x + " ~*~*"; // Short-hand implementation of the interface's method like overriding using the child class

    Integer num = 10;
    String result = p.prittifyObject(num);
    System.out.println(result);
  }
}