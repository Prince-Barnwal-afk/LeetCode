class Solution {
    public void nextPermutation(int[] nums) {
        int n =  nums.length;
        int indexi = -1;

        for(int i = n-2; i >= 0; i--){
            if(nums[i] < nums[i+1]){
                indexi = i;
                break;
            }
        }
        if(indexi == -1){
            reverse(nums, 0 , n-1);
            return;
        }
        for(int i = n-1; i > indexi; i--){
            if(nums[i] > nums[indexi]){
                int tmep = nums[i];
                nums[i] = nums[indexi];
                nums[indexi] = tmep;
                break;
            }
        }
        reverse(nums, indexi+1, n-1);
    }
    public static void reverse(int [] nums, int left, int right){
        while(left < right){
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
            left++;
        right--;
        }
    }
}