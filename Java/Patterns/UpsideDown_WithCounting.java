import java.util.*;
public class Pattern {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt(), row, col, space, counter = 1;

        for(row=1; row<=n; row++) {
            for(space=1; space<row; space++) {
                System.out.print(" ");
            }

            for(col=row; col<=n; col++) {
                System.out.print(counter + "*");
                counter++;
            }

            for(col=row; col<=n; col++) {
                if(col == n) {
                    System.out.print("-");
                }
                else {
                  else {
                     System.out.print("-" + "*");
                  }

            }

            System.out.println();
            System.out.println();
          }
        }
    }
}
