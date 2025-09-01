import java.util.*;

interface BinaryOperation {
  public abstract int addOperation(int a, int b);
}

public class LambdaExpression {
  public static void printBinaryResult(int a, int b, BinaryOperation func) {
    System.out.println(func.addOperation(a, b));  
  }
  
  public static void main(String args[]) {
    printBinaryResult(10, 20, (x, y) -> x + y);
    printBinaryResult(10, 20, (x, y) -> x - y);
  }
}