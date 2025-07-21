// Given an integer array arr of size N, sorted in ascending order 
// (with distinct values). Now the array is rotated between 1 to N 
// times which is unknown. Find the minimum element in the array. 

// Example 1:
// Input: nums = [3,4,5,1,2]
// Output: 1
// Explanation: The original array was [1,2,3,4,5] rotated 3 times.
    
// Example 2:
// Input: nums = [4,5,6,7,0,1,2]
// Output: 0
// Explanation: The original array was [0,1,2,4,5,6,7] and it was rotated 4 times.
    
// Example 3:
// Input: nums = [11,13,15,17]
// Output: 11
// Explanation: The original array was [11,13,15,17] and it was rotated 4 times.

// [4, 5, 6, 7, 8, 9, 0, 1, 2, 3]
// [5,1,2,3,4]
// [4,5,6,1,2,3]
// [4,5,1,2,3]

class Solution {
    public int findMin(int[] nums) {
        switch(nums.length) {
            case 1:
                return nums[0];
            case 2:
                if(nums[0] < nums[1]) {
                    return nums[0];
                }
                else {
                    return nums[1];
                }
            default:
                int left = 0, right = nums.length - 1, mid, smallValue = Integer.MAX_VALUE;
                while(left <= right) {
                    mid = left + (right - left) / 2;
                    smallValue = nums[mid];

                    if(nums[left] == nums[right]) {
                        left += 1;
                        right -= 1;
                    }
                    else if(nums[left] < nums[right]) {
                        if(nums[left] > nums[mid] && nums[mid] < nums[right]) {
                            right -= 1;
                        }
                        else {
                            right = mid - 1;
                        }
                    }
                    else {
                        if(nums[left] > nums[mid] && nums[mid] < nums[right]) {
                            left += 1;
                        }
                        else {
                            left = mid + 1;
                        }
                    }
                }
                return smallValue;
        }
    }
}