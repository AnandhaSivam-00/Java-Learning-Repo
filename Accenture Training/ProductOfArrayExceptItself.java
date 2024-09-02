// Given an integer array nums, return an array answer such that answer[i] is equal to the product of all the 
// elements of nums except nums[i].
// The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.
// You must write without using the division operation.

// Input Format
// Size of an array The input consists of an integer array nums.
// Constraints

// The length of the array nums (n) is at most 10^5. The elements of the array are integers ranging from -10^9 to 10^9.
// Output Format

// Return an integer array answer where each element answer[i] is the product of all elements of nums except nums[i].
// Sample Input 0

// 4
// 1 2 3 4
// Sample Output 0

// 24 12 8 6
// Sample Input 1
// 5
// -1 1 0 -3 3
// Sample Output 1
// 0 0 9 0 0



import java.util.*;

public class Main {
    protected static void productOfArray(int arr[], int n) {
        int result[] = new int[n], sum;
        
        for(int i=0; i<n; i++) {
            sum = 1;
            for(int j=0; j<n; j++) {
                if(i != j) {
                    sum *= arr[j];
                }
            }
            result[i] = sum;
        }
        
        for(int i=0; i<n; i++) {
            System.out.print(result[i] + " ");
        }
    }
    
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();
        int arr[] = new int[n];
        
        for(int i=0; i<n; i++) {
            arr[i] = sc.nextInt();
        }
        
        productOfArray(arr, n);
    }
}
