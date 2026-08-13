class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> set = new HashSet<>();
        HashSet<Integer> resultSet = new HashSet<>();

        for (int num : nums1) {
            set.add(num);
        }

        for (int num : nums2) {
            if (set.contains(num)) {
                resultSet.add(num);
            }
        }

        int[] result = new int[resultSet.size()];
        int i = 0;

        for (int num : resultSet) {
            result[i] = num;
            i++;
        }

        return result;
    }
}

// can do using hasmap+arraylist but the complexity will be  O(m*N)
// class Solution {
//     public int[] intersection(int[] nums1, int[] nums2) {
//         HashMap<Integer, Integer> hs = new HashMap<>();
//         ArrayList<Integer> ans = new ArrayList<>();

//         // Store nums1
//         for (int i = 0; i < nums1.length; i++) {
//             hs.put(nums1[i], 1);
//         }

//         // Check nums2
//         for (int i = 0; i < nums2.length; i++) {
//             if (hs.containsKey(nums2[i]) && !ans.contains(nums2[i])) {
//                 ans.add(nums2[i]);
//             }
//         }

//         // Convert ArrayList to int[]
//         int[] result = new int[ans.size()];

//         for (int i = 0; i < ans.size(); i++) {
//             result[i] = ans.get(i);
//         }

//         return result;
//     }
// }