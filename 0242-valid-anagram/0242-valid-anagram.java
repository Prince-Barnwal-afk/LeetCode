import java.util.HashMap;

class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        HashMap<Character, Integer> hashMap = new HashMap<>();

        // Count frequency of characters in s
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (!hashMap.containsKey(ch)) {
                hashMap.put(ch, 1);
            } else {
                hashMap.put(ch, hashMap.get(ch) + 1);
            }
        }

        // Decrease frequency using t
        for (int i = 0; i < t.length(); i++) {
            char ch = t.charAt(i);

            if (!hashMap.containsKey(ch)) {
                return false;
            }

            hashMap.put(ch, hashMap.get(ch) - 1);

            if (hashMap.get(ch) == 0) {
                hashMap.remove(ch);
            }
        }

        return hashMap.isEmpty();
    }
}