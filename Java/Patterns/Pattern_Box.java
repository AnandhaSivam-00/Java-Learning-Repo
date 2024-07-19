import java.util.*;

class Pattern_Box {
  public static void main(String args[]) {
    Scanner sc = new Scanner(System.in);

    int n = sc.nextInt();
    int i, j;

    for (i = 1; i < n*2; i++) {
      for (j = 1; j < n*2; j++) {
        if (i == 1 || i == n || j == 1 || j == n) {
          System.out.print("*");
        } else {
          System.out.print(" ");
        }
      }
      System.out.println();
    }
  }
}