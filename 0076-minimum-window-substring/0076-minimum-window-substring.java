public class Solution {
    public static String minWindow(String s, String t) {
        int n = s.length();
        int m = t.length();

        if (n < m) {
            return "";
        }

        // Frequency map array for ASCII characters
        int[] hash = new int[256];

        // Pre-insert frequencies of characters from string t
        for (int i = 0; i < m; i++) {
            hash[t.charAt(i)]++;
        }

        int l = 0;
        int r = 0;
        int minLen = Integer.MAX_VALUE;
        int sIndex = -1;
        int count = 0; // Number of matching characters from t found so far

        while (r < n) {
            // If the character at r was pre-inserted (or required), increment count
            if (hash[s.charAt(r)] > 0) {
                count++;
            }

            // Decrement frequency in map as we include s[r] in our window
            hash[s.charAt(r)]--;

            // When a valid window containing all characters of t is found
            while (count == m) {
                // Update the minimum window length and starting index
                if (r - l + 1 < minLen) {
                    minLen = r - l + 1;
                    sIndex = l;
                }

                // Shrink the window from the left
                hash[s.charAt(l)]++;
                
                // If frequency becomes > 0, it means we removed a character 
                // required by t, so decrement count
                if (hash[s.charAt(l)] > 0) {
                    count--;
                }

                l++;
            }

            r++;
        }

        // Return the minimum window substring if found, else empty string
        return sIndex == -1 ? "" : s.substring(sIndex, sIndex + minLen);
    }


}