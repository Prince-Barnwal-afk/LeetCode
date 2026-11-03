class Solution {
    public int minMoves(int[] nums) {
        int max = nums[0];
        int ans = 0;

        for(int i = 0; i < nums.length; i++){
            if(nums[i] > max) max = nums[i];
        }
        for(int i = 0; i < nums.length; i++){
            ans += max - nums[i];
        }
        return ans;
    }
}