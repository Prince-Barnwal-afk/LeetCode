import java.util.HashMap;
import java.util.Map;

class Solution {
    public int largestInteger(int[] nums, int k) {
        int n = nums.length;

        // Case 1: k == n
        if (k == n) {
            int max = -1;
            for (int num : nums) {
                max = Math.max(max, num);
            }
            return max;
        }

        // Case 2: k == 1
        if (k == 1) {
            Map<Integer, Integer> freq = new HashMap<>();
            for (int num : nums) {
                freq.put(num, freq.getOrDefault(num, 0) + 1);
            }
            int max = -1;
            for (Map.Entry<Integer, Integer> entry : freq.entrySet()) {
                if (entry.getValue() == 1) {
                    max = Math.max(max, entry.getKey());
                }
            }
            return max;
        }

        // Case 3: 1 < k < n
        Map<Integer, Integer> freq = new HashMap<>();
        for (int num : nums) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }

        int max = -1;
        if (freq.get(nums[0]) == 1) {
            max = Math.max(max, nums[0]);
        }
        if (freq.get(nums[n - 1]) == 1) {
            max = Math.max(max, nums[n - 1]);
        }

        return max;
    }
}