import java.util.Arrays;

class Solution {
    public int minimizeSum(int[] nums) {
        int n = nums.length;
        if (n <= 3) {
            return 0;
        }

        Arrays.sort(nums);

        int changeTwoLargest = nums[n - 3] - nums[0];
        int changeTwoSmallest = nums[n - 1] - nums[2];
        int changeOneEach = nums[n - 2] - nums[1];

        return Math.min(changeTwoLargest, Math.min(changeTwoSmallest, changeOneEach));
    }
}