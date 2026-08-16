import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.Map;

class Solution {
    public boolean wordPattern(String pattern, String s) {
        String[] arr = s.split(" ");
        
        // 1. Check length mismatch
        if (pattern.length() != arr.length) return false;

        Map<Character, String> map = new HashMap<>();
        Set<String> usedWords = new HashSet<>();

        for (int i = 0; i < pattern.length(); i++) {
            char ch = pattern.charAt(i);
            String word = arr[i];

            if (map.containsKey(ch)) {
                // If char already mapped, it must map to the SAME word
                if (!map.get(ch).equals(word)) {
                    return false;
                }
            } else {
                // If char is new, the word must NOT be already used by another char
                if (usedWords.contains(word)) {
                    return false;
                }
                // Establish new mapping
                map.put(ch, word);
                usedWords.add(word);
            }
        }
        return true;
    }
}   