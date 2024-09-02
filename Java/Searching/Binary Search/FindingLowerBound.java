// You are given an array 'arr' sorted in non-decreasing order and a number 'x'. You must return the index of the lower bound of 'x'.

// Note:
// 1. For a sorted array 'arr', 'lower_bound' of a number 'x' is defined as the smallest index 'idx' such that the value 'arr[idx]' is not less than 'x'.If all numbers are smaller than 'x', then 'n' should be the 'lower_bound' of 'x', where 'n' is the size of array.

// Example:
// Input: ‘arr’ = [1, 2, 2, 3] and 'x' = 0

// Output: 0

// Explanation: Index '0' is the smallest index such that 'arr[0]' is not less than 'x'.
// Explanation Of Sample Input 1 :
// Index '0' is the smallest index such that 'arr[0]' is not less than 'x'.


// Sample Input 2:
// 6
// 1 2 2 3 3 5
// 2
// Sample Output 2:
// 1
// Sample Input 3:
// 6
// 1 2 2 3 3 5
// 7
// Sample Output 3:
// 6



public class Solution {
    public static int lowerBound(int []arr, int n, int x) {
        if(n == 1) {
            return 0;
        }

        if(arr[n-1] < x) {
            return n;
        }

        int start = 0;
        int end = n - 1;
        int mid = 0;
        int result = 0;

        while(start <= end) {
            mid = start + (end - start) / 2;

            if(arr[mid] < x) {
                start = mid + 1;
            }
            else {
                end = mid - 1;
                result = mid;
            }
        }

        return result;
    }
}