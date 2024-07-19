import java.util.*;

class Pattern_Spiral_Matrix {
  public static void main(String args[]) {
    Scanner sc = new Scanner(System.in);

    int n = sc.nextInt();
    int row, col, counter = 1;

    for (row = 1; row <= n; row++) {
      if(row % 2 == 0) {
        counter += (n - 1);
        for (col = 1; col <= n; col++) {
          System.out.print(counter + " ");
          counter--;
        }
        counter += (n + 1);
      }
      else {
        for (col = 1; col <= n; col++) {
          System.out.print(counter + " ");
          counter++;
        }
      }
      System.out.println();
    }
  }
}