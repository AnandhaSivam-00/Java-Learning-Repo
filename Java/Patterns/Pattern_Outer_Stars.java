import java.util.*;

class Pattern_Outer_Stars {

  protected static void singleWidthBox(int n) {
    int row, col, leftCounter = 1, rightCounter = 1;

    for (row = 0; row < n*2; row++) {
      for (col = 0; col < n*2; col++) {
        // Need to be Do 
      }
      System.out.println(); 
    }
  }

  protected static void onlyOuterStars(int n) {
    int row, col;

    for (row = 1; row <= n; row++) {
      for (col = 1; col <= n; col++) {
        if(row == 1 || row == n || col == 1 || col == n) {
          System.out.print("* ");
        }
        else {
          System.out.print("  ");
        }
      }
      System.out.println();
    }
  }
  
  public static void main(String args[]) {
    Scanner sc = new Scanner(System.in);

    int n = sc.nextInt();

    // onlyOuterStars(n);

    singleWidthBox(n);
    
  }
}