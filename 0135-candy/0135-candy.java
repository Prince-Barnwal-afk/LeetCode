class Solution {
    public int candy(int[] ratings) {
        int n = ratings.length;
        if (n == 0) return 0;

        int sum = 1; // Give 1 candy to the first child
        int i = 1;

        while (i < n) {
            // Case 1: Flat surface
            if (ratings[i] == ratings[i - 1]) {
                sum += 1;
                i++;
                continue;
            }

            // Case 2: Increasing slope
            int peak = 1;
            while (i < n && ratings[i] > ratings[i - 1]) {
                peak++;
                sum += peak;
                i++;
            }

            // Case 3: Decreasing slope
            int down = 1;
            while (i < n && ratings[i] < ratings[i - 1]) {
                sum += down;
                down++;
                i++;
            }

            // If the downward slope is longer or equal to the peak height,
            // we need to expand the peak height accordingly.
            if (down > peak) {
                sum += (down - peak);
            }
        }

        return sum;
    }
}
//This have time and space is complexity o(n) and o(1)
//This have time and space is complexity o(n) and o(n)
// import java.util.HashMap;
// import java.util.Map;

// class Solution {
//     public int largestInteger(int[] nums, int k) {
//         int n = nums.length;

//         // Case 1: k == n
//         if (k == n) {
//             int max = -1;
//             for (int num : nums) {
//                 max = Math.max(max, num);
//             }
//             return max;
//         }

//         // Case 2: k == 1
//         if (k == 1) {
//             Map<Integer, Integer> freq = new HashMap<>();
//             for (int num : nums) {
//                 freq.put(num, freq.getOrDefault(num, 0) + 1);
//             }
//             int max = -1;
//             for (Map.Entry<Integer, Integer> entry : freq.entrySet()) {
//                 if (entry.getValue() == 1) {
//                     max = Math.max(max, entry.getKey());
//                 }
//             }
//             return max;
//         }

//         // Case 3: 1 < k < n
//         Map<Integer, Integer> freq = new HashMap<>();
//         for (int num : nums) {
//             freq.put(num, freq.getOrDefault(num, 0) + 1);
//         }

//         int max = -1;
//         if (freq.get(nums[0]) == 1) {
//             max = Math.max(max, nums[0]);
//         }
//         if (freq.get(nums[n - 1]) == 1) {
//             max = Math.max(max, nums[n - 1]);
//         }

//         return max;
//     }
// }