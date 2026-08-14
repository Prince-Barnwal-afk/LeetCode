class Solution {
    public int lengthOfLongestSubstring(String s) {
        int[] table = new int[128];
        for (int i = 0; i < 128; i++) {
            table[i] = -1;
        }

        int left = 0;
        int maxLength = 0;

        for (int right = 0; right < s.length(); right++) {
            char ch = s.charAt(right);

            if (table[ch] >= left) {
                left = table[ch] + 1;
            }

            table[ch] = right;
            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;
    }
}