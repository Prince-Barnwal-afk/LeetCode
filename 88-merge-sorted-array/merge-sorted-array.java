class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int k = m - 1;
        int right = n - 1;
        int i = m + n - 1;

        while (right >= 0) {
            if (k >= 0 && nums1[k] > nums2[right]) {
                nums1[i] = nums1[k];
                k--;
            } else {
                nums1[i] = nums2[right];
                right--;
            }
            i--;
        }
    }
}