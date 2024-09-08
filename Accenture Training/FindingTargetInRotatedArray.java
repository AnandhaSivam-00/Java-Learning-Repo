// In the context of a sorted and rotated array containing duplicate elements, 
// your objective is to devise an algorithm capable of efficiently identifying 
// a specified element within the rotated array. The algorithm is required to achieve this 
// task with a time complexity of O(log n). Additionally, 
// it is important to output the index where the key exists, and if there 
// are multiple valid answers, any of them can be printed. Design a solution that 
// meets these criteria and successfully locates the specified element in the given 
// rotated array.

// Example:
// Input: arr[] = {3, 3, 3, 1, 2, 3}, key = 3 

// Output: 0 
// arr[0] = 3

// Input: arr[] = {3, 3, 3, 1, 2, 3}, key = 11 

// Output: -1 
// 11 is not present in the given array. 

// Input: arr[] = {6, 7, 0, 1, 2, 4, 5}, key = 7 

// Output: 1




import java.util.*;

public class FindingTargetInRotatedArray {
  protected static int findTarget(int[] arr, int target, int start, int end) {


    // If the array contains only one element
    if(nums.length == 1) {
        if(nums[0] == target) {
            return 0;
        }
        else {
            return -1;
        }
    }

    
    while(start < end) {
      int mid = start + (end - start) / 2;

      // Finding the first occurance if the duplicate is present
      // if(arr[mid] == target) {
      //   return mid;
      // }
      if(arr[0] <= arr[mid]) {
        
        // When middle element is on the non-rotated portion of the array.
        // Check if the target is also on the non-rotated portion and adjust 
        // end accordingly.
        
        if(target >= arr[0] && target <= arr[mid]) {
          end = mid;
        }
        else {
          start = mid + 1;
        }
      }
      else {
        
        // When middle element is on the rotated portion of the array.
        // Check if the target is also on the rotated portion and 
        // adjust start accordingly.

        if(target > arr[mid] && target <= arr[arr.length - 1]) {
          start = mid + 1;
        }
        else {
          end = mid;
        }
      }
    }
    return arr[start] == target ? start : -1;
  }
  
  public static void main(String args[]) {
    Scanner sc = new Scanner(System.in);

    int n = sc.nextInt(), i;
    int arr[] = new int[n];

    for(i=0; i<n; i++) {
      arr[i] = sc.nextInt();
    }

    int key = sc.nextInt();

    System.out.println(findTarget(arr, key, 0, n-1));
  }
}