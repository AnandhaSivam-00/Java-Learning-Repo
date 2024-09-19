// The program must accept N integers and for each integer value 
// must print the sum of the largest and the second largest digit. 
// If the integer value is a single digit value or does not 
// contain at least two distinct digits, then just print the 
// largest digit.

// Boundary Condition(s):
// 1 <= N <= 1000
// 1 <= Each integer value <= 10^9

// Example Input/Output 1:
// Input:
// 5
// 7056 6 999 9995 800

// Output:
// 13 6 9 14 8


import java.util.*;

public class SumOfTheLargestSecondLargest {
  protected static int findingTheSum(int num) {
    int sum = 0;
    int max = 0, secondMax = 0;
    int temp = num;
    int digit = 0;
    
    while(temp > 0) {
      digit = temp % 10;
      temp /= 10;

      if(digit > max) {
        secondMax = max;
        max = digit;
      }
      else if(digit > secondMax && digit < max) {
        secondMax = digit;
      }
    }
    
    sum = max + secondMax;
    
    if(max == secondMax) return max;
    return sum;
  }

  
  public static void main(String args[]) {
    Scanner sc = new Scanner(System.in);

    int n = sc.nextInt(), temp;

    for(int i=0; i<n; i++) {
      temp = sc.nextInt();
      System.out.print(findingTheSum(temp) + " ");
    }
  }
}