class Solution {
    public int findUnsortedSubarray(int[] nums) {
        int n = nums.length;

        int start = 0;
        int end = n - 1;

        // Find the first place where increasing order breaks
        while (start < n - 1 && nums[start] <= nums[start + 1]) {
            start++;
        }

        // Already sorted
        if (start == n - 1) {
            return 0;
        }

        // Find the last place where increasing order breaks
        while (end > 0 && nums[end - 1] <= nums[end]) {
            end--;
        }

        // Find min and max inside the unsorted portion
        int min = nums[start];
        int max = nums[start];

        for (int i = start; i <= end; i++) {
            min = Math.min(min, nums[i]);
            max = Math.max(max, nums[i]);
        }

        // Expand left
        while (start > 0 && nums[start - 1] > min) {
            start--;
        }

        // Expand right
        while (end < n - 1 && nums[end + 1] < max) {
            end++;
        }

        return end - start + 1;
    }
}