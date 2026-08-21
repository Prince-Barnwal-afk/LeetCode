class Solution {
    public int[] pivotArray(int[] nums, int pivot) {
        int n = nums.length;
        int[] result = new int[n];
        
        int left = 0;
        int right = n - 1;

        // Step 1: Place elements smaller than pivot from the front,
        // and elements greater than pivot from the back.
        for (int i = 0, j = n - 1; i < n; i++, j--) {
            if (nums[i] < pivot) {
                result[left++] = nums[i];
            }
            if (nums[j] > pivot) {
                result[right--] = nums[j];
            }
        }

        // Step 2: Fill the middle remaining slots with pivot values
        while (left <= right) {
            result[left++] = pivot;
        }

        return result;
    }
}