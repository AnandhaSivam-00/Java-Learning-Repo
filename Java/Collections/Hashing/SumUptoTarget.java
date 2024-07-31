class Solution {
    public int[] twoSum(int[] nums, int target) {
        int result[] = new int[2];
        HashMap<Integer,Integer> hashmap = new HashMap<>();
        int key;
        for(int i=0; i<nums.length; i++){
            key = target-nums[i];
            if(hashmap.containsKey(key)){
                result[0] = hashmap.get(key);
                result[1] = i;
                return result;
            }
            hashmap.put(nums[i], i);
        }
        return result;
    }
}

// 2 --> 7
// 7 --> 2