// Input:
// 5
// 6
// 100

// Output:
// 5 6 55 56 65 66


import java.util.*;

public class Combinations {
  public static boolean isAppearInRange(int num, int num1, int num2) {
    while(num != 0) {
      int rem = num % 10;
      if(rem != num1 && rem != num2) {
        return false;
      }
      num = num / 10;
    }

    return true;
  }
  
  public static void main(String args[]) {
    Scanner sc = new Scanner(System.in);

    int num1 = sc.nextInt();
    int num2 = sc.nextInt();
    int range = sc.nextInt();

    for(int i=1; i<=range; i++) {
      if(isAppearInRange(i, num1, num2)) {
        System.out.print(i + " ");
      }
    }
  }
}