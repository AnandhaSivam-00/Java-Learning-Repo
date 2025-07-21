// Given an array of integers nums sorted in non-decreasing order, 
// find the starting and ending position of a given target value.

// If target is not found in the array, return [-1, -1].

// You must write an algorithm with O(log n) runtime complexity.

// Example 1:

// Input: nums = [5,7,7,8,8,10], target = 8
// Output: [3,4]
// Example 2:

// Input: nums = [5,7,7,8,8,10], target = 6
// Output: [-1,-1]
// Example 3:

// Input: nums = [], target = 0
// Output: [-1,-1]

class Solution {
    public int[] searchRange(int[] nums, int target) {
        if(nums.length == 0) {
            return new int[]{-1, -1};
        }

        int leftIndex = -1, rightIndex = -1;
        rightIndex = searchDirection(nums, target, true);
        if(rightIndex != -1) {
            leftIndex = searchDirection(nums, target, false);
        }

        return new int[]{leftIndex, rightIndex};
    }

    public int searchDirection(int[] nums, int target, boolean searchRight) {
        int left = 0, right = nums.length - 1, mid, index = -1;

        while(left <= right) {
            mid = left + (right - left) / 2;
            if(nums[mid] == target) {
                index = mid;
                if(searchRight) {
                    left = mid + 1;
                }
                else {
                    right = mid - 1;
                }
            }
            else if(nums[mid] < target) {
                left = mid + 1;
            }
            else {
                right = mid - 1;
            }
        }

        return index;
    }
}