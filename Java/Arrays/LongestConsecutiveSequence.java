class Solution {
    public int longestConsecutive(int[] nums) {
        int longestLength = 0, currentLength = 0, lastSmallest = Integer.MIN_VALUE, i;

        // Sorting the array
        Arrays.sort(nums);


        // Without considering the case of duplicate numbers

        for(i = 0; i<nums.length; i++) {
            if(nums[i]-1 == lastSmallest) {
                currentLength++;
                lastSmallest = nums[i];
            }
            else if(nums[i] == lastSmallest) {
                continue;
            }
            else {
                currentLength = 1;
                lastSmallest = nums[i];
            }

            longestLength = Math.max(longestLength, currentLength);
        }

        return longestLength;
    }
}