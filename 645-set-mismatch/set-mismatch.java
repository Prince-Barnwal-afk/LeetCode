class Solution {
    public int[] findErrorNums(int[] nums) {
        HashMap<Integer,Integer> map = new HashMap<>();
        int ans [] = new int[2];

        for(int i = 0; i < nums.length; i++){
            int key = nums[i];
            map.put(key, map.getOrDefault(key, 0) + 1);
        }
        for(int i = 1; i <= nums.length; i++){
            if(map.containsKey(i)  && map.get(i )> 1){
                ans[0] = i;
            }
            if(!map.containsKey(i)){
                ans[1] = i;
            }
        }
        return ans;
    }
}