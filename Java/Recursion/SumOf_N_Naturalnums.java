import java.util.*;

public class SumOf_N_Naturalnums {
  protected static int sumOfNaturalNums(int n) {
    if(n == 0) {
      return 0;
    }
    else {
      return n + sumOfNaturalNums(n-1);
    }
  }
  
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    System.out.print("Enter a number: ");
    int n = sc.nextInt();
    System.out.println("Sum of first " + n + " natural numbers is: " + sumOfNaturalNums(n));
  }
}