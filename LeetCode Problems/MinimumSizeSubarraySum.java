class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int minLength = Integer.MAX_VALUE, i, sum = 0, length = 0, j = 0;

        for(i=0; i<nums.length; i++) {
            sum += nums[i];
            length++;

            while(sum >= target) {
                minLength = Math.min(minLength, length);
                length--;
                sum -= nums[j];
                j++;
            }
        }

        return minLength == Integer.MAX_VALUE ? 0 : minLength;
    }
}