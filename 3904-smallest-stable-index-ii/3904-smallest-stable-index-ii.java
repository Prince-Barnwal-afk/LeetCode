class Solution {
    public int firstStableIndex(int[] nums, int k) {
        int n = nums.length;
        int[] minFromIndex = new int[n];
        
        int minElement = Integer.MAX_VALUE;
        for (int i = n - 1; i >= 0; i--) {
            minElement = Math.min(minElement, nums[i]);
            minFromIndex[i] = minElement;
        }

        int maxElement = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            maxElement = Math.max(maxElement, nums[i]);

            if (maxElement - minFromIndex[i] <= k) {
                return i;
            }
        }

        return -1;
    }
}