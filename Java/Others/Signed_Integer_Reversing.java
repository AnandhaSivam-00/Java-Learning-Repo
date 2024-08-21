import java.util.*;

public class Signed_Integer_Reversing {
  public static void main(String args[]) {
    Scanner sc = new Scanner(System.in);

    int n = sc.nextInt(), digit;
    String reversedString = "";

    while(n != 0) {
      digit = n % 10;
      reversedString += digit;
      n /= 10;
    }
    System.out.println(Integer.valueOf(reversedString));
  }
}