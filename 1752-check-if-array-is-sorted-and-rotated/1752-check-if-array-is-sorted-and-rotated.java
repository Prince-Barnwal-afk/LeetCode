class Solution {
    public boolean check(int[] nums) {
        int n = nums.length;
        int drop = 1;
        while(drop < n && nums[drop] >= nums[drop-1]){
            drop++;
        }
        if(drop == n) return true;
        
        if(nums[n - 1] > nums[0]) return false;
        int j = drop;
        while(j+1<n){
            if(nums[j]>nums[j+1]) return false;
            j++;
        }
        return true;
    }
}