class Solution {
    public int[] concatWithReverse(int[] nums) {
        int n = nums.length;
        int[] result = new int[2 * n];
        
        for (int i = 0; i < n; i++) {
            result[i] = nums[i];             // Fill left side (original order)
            result[2 * n - 1 - i] = nums[i]; 
               }
        
        return result;
    }
}