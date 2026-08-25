class Solution {
    public int missingMultiple(int[] nums, int k) {
        Set<Integer> set = new HashSet<>();
        for(int value : nums){
            set.add(value);
        }
        int candidate = k;

        while(set.contains(candidate)){
            candidate += k;
        }
        return candidate;
    }
}