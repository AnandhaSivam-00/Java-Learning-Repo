// Given an array of integers, rearrange the elements such that all even numbers appear on the 
// //left side of the array in decreasing order, and all odd numbers appear on the right side of 
// the array in decreasing order. The algorithm should not use any extra space.

// Input Format
// An integer array arr of length n (1 ≤ n ≤ 10^5) Each element of the array is an integer ranging from -10^9 to 10^9.

// Constraints
// The algorithm should not use any extra space. The elements of the array can be negative, zero, or positive integers. There can be duplicate elements in the array.

// Output Format
// The modified array arr after rearranging its elements according to the given conditions.

// Sample Input 0
// 5
// 10 8 6 4 2
// Sample Output 0
// 10 8 6 4 2

// Sample Input 1
// 8
// 7 6 9 8 3 2 5 4
// Sample Output 1
// 8 6 4 2 9 7 5 3

import java.util.*;

public class SortEvenAndOddInDescending {
    protected static void swap(int arr[], int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    
    protected static void sortDescending(int arr[], int i, int j) {
        int start, end;
        for(start=i; start<j; start++) {
            end = start;
            
            while(end > i && arr[end-1] < arr[end]) {
                swap(arr, end-1, end);
                end--;
            }
        }
    }
    
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt(), i, j, oddStartIndex = 0;
        int arr[] = new int[n];
        
        for(i=0; i<n; i++) {
            arr[i] = sc.nextInt();
            if(arr[i] % 2 == 0) {
                oddStartIndex++;
            }
        }
        
        Arrays.sort(arr);
        
        i = 0;
        j = oddStartIndex;
        
        while(i < oddStartIndex && j < n) {
            if(arr[i] % 2 != 0 && arr[j] % 2 == 0) {
                swap(arr, i, j);
            }
            else if(arr[j] % 2 != 0) {
                j++;
            }
            else if(arr[i] % 2 == 0) {
                i++;
            }
        }
        
        // Sorting Even-subarray
        sortDescending(arr, 0, oddStartIndex);
        
        // Sorting Odd-subarray
        sortDescending(arr, oddStartIndex, n);
    
        
        for(i=0; i<n; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}

