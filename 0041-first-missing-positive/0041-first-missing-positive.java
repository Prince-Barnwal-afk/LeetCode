class Solution {
    public int firstMissingPositive(int[] nums) {
        int n = nums.length;

        // Step 1: Place each number in its target slot: nums[i] -> index nums[i] - 1
        int i = 0;
        while (i < n) {
            int correctIndex = nums[i] - 1;

            // Check if nums[i] belongs to [1, n] and is not already in its correct spot
            if (nums[i] > 0 && nums[i] <= n && nums[i] != nums[correctIndex]) {
                swap(nums, i, correctIndex);
            } else {
                i++;
            }
        }

        // Identify the first missing positive
        for (i = 0; i < n; i++) {
            if (nums[i] != i + 1) {
                return i + 1;
            }
        }

        //  If 1 through n are present, the answer is n + 1
        return n + 1;
    }

    private void swap(int[] nums, int first, int second) {
        int temp = nums[first];
        nums[first] = nums[second];
        nums[second] = temp;
    }
}