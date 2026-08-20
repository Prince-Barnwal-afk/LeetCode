class Solution {
    public int[] resultArray(int[] nums) {
        // Use ArrayLists for dynamic resizing
        List<Integer> arr1 = new ArrayList<>();
        List<Integer> arr2 = new ArrayList<>();
        
        arr1.add(nums[0]);
        arr2.add(nums[1]);
        
        for (int i = 2; i < nums.length; i++) {
            // Compare last elements
            if (arr1.get(arr1.size() - 1) > arr2.get(arr2.size() - 1)) {
                arr1.add(nums[i]);
            } else {
                arr2.add(nums[i]);
            }
        }
        
        // Concatenate arr2 to arr1
        arr1.addAll(arr2);
        
        // Convert List<Integer> back to int[]
        return arr1.stream().mapToInt(Integer::intValue).toArray();
    }
}   