class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> hs = new HashMap<>();
        ArrayList<Integer> ans = new ArrayList<>();

        // Store frequency of nums1
        for (int i = 0; i < nums1.length; i++) {
            if (!hs.containsKey(nums1[i])) {
                hs.put(nums1[i], 1);
            } else {
                hs.put(nums1[i], hs.get(nums1[i]) + 1);
            }
        }

        // Check nums2
        for (int i = 0; i < nums2.length; i++) {
            if (hs.containsKey(nums2[i]) && hs.get(nums2[i]) > 0) {
                ans.add(nums2[i]);

                // Consume one occurrence
                hs.put(nums2[i], hs.get(nums2[i]) - 1);
            }
        }

        // ArrayList<Integer> → int[]
        int[] result = new int[ans.size()];

        for (int i = 0; i < ans.size(); i++) {
            result[i] = ans.get(i);
        }

        return result;
    }
}