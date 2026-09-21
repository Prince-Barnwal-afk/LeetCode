
class Solution {
    public long[] resultArray(int[] nums, int k) {
        int n = nums.length;

        // Output array storing total counts for each remainder x from 0 to k-1
        long[] result = new long[k];

        // Stores remainder counts ending at previous indices
        long[] prev_count = new long[k];

        for (int i = 0; i < n; i++) {
            // Stores remainder counts ending at current index i
            long[] curr_count = new long[k];

            // 1. Single element subarray ending at index i
            int curr_rem = nums[i] % k;
            curr_count[curr_rem]++;

            // 2. Extend subarrays ending at i-1 with current element nums[i]
            for (int old_rem = 0; old_rem < k; old_rem++) {
                if (prev_count[old_rem] > 0) {
                    int new_rem = (int) ((1L * old_rem * nums[i]) % k);
                    curr_count[new_rem] += prev_count[old_rem];
                }
            }

            // 3. Accumulate current counts into total result
            for (int x = 0; x < k; x++) {
                result[x] += curr_count[x];
            }

            // Move curr_count to prev_count for next iteration
            prev_count = curr_count;
        }

        return result;
    }
}
