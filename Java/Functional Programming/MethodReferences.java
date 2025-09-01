import java.util.function.*;

public class MethodReferences {
  public static int squareNum(int num) {
    return num * num;
  }
  
  public static void main(String args[]) {
    // Referencing the static method
    Function<Integer, Integer> func = MethodReferences::squareNum;
    System.out.println(func.apply(10));

    // Reference to an Instance Method of a Particular Object
    String str = "WELCOME";
    Predicate<String> func2 = str::contains;
    System.out.println(func2.test("COME"));

    // Reference to an Instance Method of an Arbitrary Object of a Particular Type
    BiPredicate<String, String> func3 = String::contains;
    System.out.println(func3.test(str, "COME"));
  }
}