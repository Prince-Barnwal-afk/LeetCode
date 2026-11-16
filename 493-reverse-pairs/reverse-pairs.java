class Solution {
    public int reversePairs(int[] nums) {
        return mergeSort(nums, 0, nums.length - 1);
    }
    public static int mergeSort(int [] nums, int low, int high){
        int ans = 0;
        if(low >= high) return 0; 
        int mid = low + (high - low) / 2;

        ans += mergeSort(nums, low, mid);
        ans += mergeSort(nums, mid+1, high);

        ans += merge(nums, low, mid, high);
        return ans;
    }
    public static int merge(int [] nums, int low, int mid, int high){
        int right = mid+1;
        int ans = 0;
        for(int left = low; left <= mid; left++){
            while(right <= high && nums[left] > 2L * nums[right]){
                right++;
            }
            ans += right - (mid +1);
        }
        int left = low;
        int[] temp = new int[high - low + 1];
        right = mid + 1;
        int index = 0;

        while (left <= mid && right <= high) {

            if (nums[left] <= nums[right]) {
                temp[index++] = nums[left++];
            } else {
                temp[index++] = nums[right++];
            }
        }

        while (left <= mid) {
            temp[index++] = nums[left++];
        }

        while (right <= high) {
            temp[index++] = nums[right++];
        }
        for (int i = 0; i < temp.length; i++) {
            nums[low + i] = temp[i];
        }

        return ans;
    }
}