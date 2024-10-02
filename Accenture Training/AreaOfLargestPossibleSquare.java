// In connection to the National Mathematics Day celebration, the Regional Mathematical Scholars Society 
// had arranged for a Mathematics Challenge Event where school kids participated in large number. 
// Many interesting math games were conducted, one such game that attracted most kids was the tile 
// game where the kids were given 'n' square tiles of the same size and were asked to form the 
// largest possible square using those tiles.

// Help the kids by writing a program to find the area of the largest possible square that can be formed, 
//   given the side of a square tile (in cms) and the number of square tiles available.

// Input Format
// First line of the input is an integer that corresponds to the side of a square tile (in cms).
// Second line of the input is an integer that corresponds to the number of square tiles available.

// Constraints
// No Constraints

// Output Format
// Output should display the area of the largest possible square that can be formed (in square cms) with the available tiles

// Sample Input 0
// 10
// 20

// Sample Output 0
// 1600

// Sample Input 1
// 3
// 15

// Sample Output 1
// 81


import java.util.*;

public class AreaOfLargestPossibleSquare {
  public static void main(String args[]) {
    Scanner sc = new Scanner(System.in);

    int side = sc.nextInt(), tiles = sc.nextInt();
    int maxArea = 0;

    int perfectSquare = tiles / 4;

    while(perfectSquare * perfectSquare > tiles) {
      perfectSquare--;
    }
    maxArea = (perfectSquare * side) * (perfectSquare * side);

    System.out.println(maxArea);
  }
}