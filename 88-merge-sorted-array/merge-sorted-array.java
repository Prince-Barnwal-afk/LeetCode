class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int right = nums2.length-1;
        int k = nums1.length - nums2.length - 1;
        int i = nums1.length-1;

        while(i >= 0){
            while(right >= 0 && k >= 0){
                if(nums1[k] <= nums2[right] && right >= 0){
                    nums1[i] = nums2[right];
                    right--;
                    i--;
                }
                else{
                    nums1[i] = nums1[k];
                    k--;
                    i--;
                }
            }
            while(k >= 0){
                nums1[i] = nums1[k];
                k--;
                i--;
            }
            while(right >= 0){
                nums1[i] = nums2[right];
                right--;
                i--;
            }
        }
    }
}