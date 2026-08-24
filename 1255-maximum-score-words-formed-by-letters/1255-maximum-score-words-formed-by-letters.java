class Solution {
    public int maxScoreWords(String[] words, char[] letters, int[] score) {
        // Step 1: Store the frequency of each character available in 'letters'
        int[] count = new int[26];
        for (char c : letters) {
            count[c - 'a']++;
        }
        
        // Step 2: Start backtracking from index 0
        return solve(0, words, count, score);
    }

    private int solve(int i, String[] words, int[] count, int[] score) {
        // Base case: If we've processed all words, maximum additional score is 0
        if (i >= words.length) return 0;

        // Option 1: Skip the current word (words[i]) and move to the next
        int ans = solve(i + 1, words, count, score);

        // Option 2: Try to include the current word (words[i])
        int s = 0; // Tracks the score contribution of words[i]
        boolean possible = true;
        int[] clone = count.clone(); // Clone count array to avoid mutating state for other branches

        // Validate if words[i] can be built using available letters
        for (char c : words[i].toCharArray()) {
            if (clone[c - 'a'] > 0) {
                s += score[c - 'a']; // Add letter score
                clone[c - 'a']--;    // Consume one instance of the letter
            } else {
                possible = false;    // Not enough letters available
                break;
            }
        }

        // If words[i] can be formed, compare score of taking it vs skipping it
        if (possible) {
            ans = Math.max(ans, s + solve(i + 1, words, clone, score));
        }

        return ans; // Return maximum score attainable from index i onwards
    }
}