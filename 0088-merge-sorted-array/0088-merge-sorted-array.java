class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {

        int[] temp = new int[m + n];

        int L = 0; // Pointer for nums1
        int R = 0; // Pointer for nums2
        int i = 0; // Pointer for temp

        // Compare elements from both arrays
        while (L < m && R < n) {
            if (nums1[L] <= nums2[R]) {
                temp[i] = nums1[L];
                L++;
            } else {
                temp[i] = nums2[R];
                R++;
            }
            i++;
        }

        // Copy remaining elements of nums1
        while (L < m) {
            temp[i] = nums1[L];
            L++;
            i++;
        }

        // Copy remaining elements of nums2
        while (R < n) {
            temp[i] = nums2[R];
            R++;
            i++;
        }

        // Copy temp back into nums1
        for (int j = 0; j < m + n; j++) {
            nums1[j] = temp[j];
        }
    }
}