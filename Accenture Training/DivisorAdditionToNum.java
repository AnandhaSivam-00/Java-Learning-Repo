// The program must accept N integers and add the integer value K 
// to the values that are multiples of K. Then the program must 
// print the revised N integer values as the output.

// Boundary Condition(s):
// 2 <= N <= 100
// 1 <= Each integer value <= 10^5
// 1 <= K <= 10^5

// Input Format:
// The first line contains N.
// The second line contains N integer values.
// The third line contains K.

// Output Format:
// The first line contains N integer values.

// Example Input/Output 1:
// Input:
// 5
// 56 500 25 20000 44
// 100

// Output:
// 56 600 25 20100 44

// Explanation:
// Here K=100. As 500 and 20000 are multiples of K=100, K is added to them.


import java.util.*;

public class DivisorAdditionToNum {
  public static void main(String args[]) {
    Scanner sc = new Scanner(System.in);

    int n = sc.nextInt(), i;
    int arr[] = new int[n];
    for(i=0; i<n; i++) {
      arr[i] = sc.nextInt();
    }

    int k = sc.nextInt();

    for(i=0; i<n; i++) {
      if(arr[i] % k == 0) {
        arr[i] += k;
      }
    }

    for(i=0; i<n; i++) {
      System.out.print(arr[i] + " ");
    }
  }
}