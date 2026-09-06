class Solution {
    public int[] singleNumber(int[] nums) {
        // Step 1: XOR all elements to get (A ^ B)
        int xorResult = 0;
        for (int num : nums) {
            xorResult ^= num;
        }
        
        // Step 2: Manually find the position of the first set bit (1) from the right
        int shift = 0;
        while ((xorResult & (1 << shift)) == 0) {
            shift++;
        }
        int diffBit = 1 << shift; // Create a mask with only that single bit set
        
        // Step 3: Divide numbers into two groups and XOR within each group
        int a = 0;
        int b = 0;
        for (int num : nums) {
            if ((num & diffBit) == 0) {
                a ^= num;
            } else {
                b ^= num;
            }
        }
        
        return new int[]{a, b};
    }
}