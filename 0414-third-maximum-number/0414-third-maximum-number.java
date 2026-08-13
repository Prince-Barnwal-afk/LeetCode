class Solution {
    public int thirdMax(int[] nums) {
        // Use long to handle Integer.MIN_VALUE in the input array
        long max1 = Long.MIN_VALUE; // First largest
        long max2 = Long.MIN_VALUE; // Second largest
        long max3 = Long.MIN_VALUE; // Third largest

        for (int num : nums) {
            // Skip duplicates
            if (num == max1 || num == max2 || num == max3) {
                continue;
            }

            if (num > max1) {
                // Shift values down: max1 -> max2 -> max3
                max3 = max2;
                max2 = max1;
                max1 = num;
            } else if (num > max2) {
                // Shift values down: max2 -> max3
                max3 = max2;
                max2 = num;
            } else if (num > max3) {
                // Update third largest only
                max3 = num;
            }
        }

        // If max3 was never updated, return the maximum (max1)
        // Check if the third maximum was ever found
if (max3 == Long.MIN_VALUE) {
    // Case: Fewer than 3 distinct numbers exist.
    // Requirement: Return the maximum number instead.
    return (int) max1;
} else {
    // Case: 3 distinct numbers were found.
    // Requirement: Return the third maximum.
    return (int) max3;
}   
    }
}   