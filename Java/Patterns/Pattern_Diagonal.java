import java.util.*;

class Pattern_Diagonal {
  public static void main(String args[]) {
    Scanner sc = new Scanner(System.in);

    int n = sc.nextInt();
    int row, col;

    for (row = 1; row <= n; row++) {
      for (col = 1; col <= n; col++) {
        if(row == col || row + col == n + 1) {
          System.out.print(col);
        }
        else {
          System.out.print(" ");
        }
      }
      System.out.println();
    }
  }
}