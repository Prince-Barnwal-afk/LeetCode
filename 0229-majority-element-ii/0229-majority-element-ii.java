class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int count1 = 0, count2 = 0;
        Integer cand1 = null, cand2 = null;
        
        for (int num : nums) {
            if (cand1 != null && num == cand1) {
                count1++;
            } else if (cand2 != null && num == cand2) {
                count2++;
            } else if (count1 == 0) {
                cand1 = num;
                count1 = 1;
            } else if (count2 == 0) {
                cand2 = num;
                count2 = 1;
            } else {
                count1--;
                count2--;
            }
        }
        
        count1 = 0;
        count2 = 0;
        for (int num : nums) {
            if (cand1 != null && num == cand1) count1++;
            if (cand2 != null && num == cand2) count2++;
        }
        
        List<Integer> result = new ArrayList<>();
        int threshold = nums.length / 3;
        
        if (cand1 != null && count1 > threshold) {
            result.add(cand1);
        }
        if (cand2 != null && count2 > threshold && !cand2.equals(cand1)) {
            result.add(cand2);
        }
        
        return result;
    }
}