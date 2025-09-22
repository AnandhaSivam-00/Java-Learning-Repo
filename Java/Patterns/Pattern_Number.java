/* Starts at bottom right corner 
* If n = 5
*
*          11
*        12 7
*      13 8 4
*    14 9 5 2
* 15 10 6 3 1

*/


import java.util.*;

public class Pattern_Number {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int counter, decrementer;

        for(int row = 1; row <= n; row++) {
            counter = n * (n - 1) / 2;
            for(int space = 1; space <= n - row; space++) {
                System.out.print("  ");
            }

            counter += row;
            decrementer = n;
            for(int col = 1; col <= row; col++) {
                if(col == 1) {
                    System.out.print(counter + " ");
                }
                else {
                    counter -= decrementer;
                    System.out.print(counter + " ");
                    decrementer--;
                }
            }
            System.out.println();
        }
    }
}