class Solution {
    public String longestCommonPrefix(String[] strs) {

        if (strs == null || strs.length == 0) {
            return "";
        }

        // Use the first string as the reference
        for (int i = 0; i < strs[0].length(); i++) {

            char currentChar = strs[0].charAt(i);

            // Compare this character with every other string
            for (int j = 1; j < strs.length; j++) {

                // If current string is shorter
                if (i == strs[j].length()) {
                    return strs[0].substring(0, i);
                }

                // If characters don't match
                if (strs[j].charAt(i) != currentChar) {
                    return strs[0].substring(0, i);
                }
            }
        }

        return strs[0];
    }
}