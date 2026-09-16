class Solution {
    public int compress(char[] chars) {
        int write = 0;
        int read = 0;  

        while (read < chars.length) {
            char currentChar = chars[read];
            int count = 0;

            // Count occurrences of the current character group
            while (read < chars.length && chars[read] == currentChar) {
                read++;
                count++;
            }

            // Write the character to the compressed position
            chars[write++] = currentChar;

            // If the group length is greater than 1, write its digits
            if (count > 1) {
                for (char c : Integer.toString(count).toCharArray()) {
                    chars[write++] = c;
                }
            }
        }

        return write; // The new length of the compressed array
    }
}