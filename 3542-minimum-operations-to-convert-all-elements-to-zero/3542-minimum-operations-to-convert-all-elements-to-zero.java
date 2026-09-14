class Solution {
    public int minOperations(int[] nums) {
        Stack<Integer> stack = new Stack<>();
        int operation = 0;
        for(int i = 0; i < nums.length; i++){
            while(!stack.empty() && stack.peek() > nums[i]){
                stack.pop();
            }
            if(nums[i] == 0){
                continue;
            }
            if(stack.empty() || stack.peek() < nums[i]){
                stack.push(nums[i]);
                operation++;
            }
        }
        return operation;
    }
}