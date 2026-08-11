import java.util.HashSet;

class Solution {
    public int missingInteger(int[] nums) {
        int n = nums.length;
        int sum = nums[0];
        int i = 1;

        // Extend the sequential prefix: nums[i] == nums[i-1] + 1
        while (i < n && nums[i] == nums[i - 1] + 1) {
            sum += nums[i];
            i++;
        }

        // Put all numbers in a set for O(1) lookups
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }

        // Find the smallest integer >= sum that's missing from nums
        while (set.contains(sum)) {
            sum++;
        }

        return sum;
    }
}