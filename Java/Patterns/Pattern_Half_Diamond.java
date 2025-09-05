import java.util.*;
class Pattern_Half_Diamond {
  public static void main(String args[]) {
    Scanner sc = new Scanner(System.in);
    int size = sc.nextInt();

    // Single outer loop for both upper and lower parts
    for(int row = 1; row <= 2 * size - 1; row++) {
      int stars, spaces;
      
      // Determine number of stars and spaces based on row position
      if(row <= size) {
        // Upper half (including middle)
        stars = row;
        spaces = size - row;
      } else {
        // Lower half
        stars = 2 * size - row;
        spaces = row - size;
      }
      
      // Print spaces
      for(int space = 1; space <= spaces; space++) {
        System.out.print(" ");
      }
      
      // Print stars
      for(int col = 1; col <= stars; col++) {
        System.out.print("* ");
      }
      
      System.out.println();
    }
  }
}