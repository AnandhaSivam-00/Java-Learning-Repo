import java.util.*;

public class Pattern_Full_Triangle {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    
    int n = sc.nextInt(), row, col, space;
    
    for(row = 0; row < n; row++) {
      for(space = n-1; space > row; space--) {
        System.out.print("  ");
      }

      for(col=row; col >= 0; col--) {
        System.out.print(col + " ");
      }

      for(col = 1; col <= row; col++) {
        System.out.print(col + " ");
      }

      System.out.println();
    }
  }
}