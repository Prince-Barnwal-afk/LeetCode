

class Solution {
    public int minPairSum(int[] nums) {
        // Step 1: Sort the array
        Arrays.sort(nums);
        
        int left = 0;
        int right = nums.length - 1;
        int maxPairSum = 0;
        
        // Step 2: Pair smallest with largest using two pointers
        while (left < right) {
            int currentSum = nums[left] + nums[right];
            maxPairSum = Math.max(maxPairSum, currentSum);
            left++;
            right--;
        }
        
        return maxPairSum;
    }
}