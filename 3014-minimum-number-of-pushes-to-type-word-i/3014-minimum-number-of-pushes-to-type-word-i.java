class Solution {
    public int minimumPushes(String word) {
        int n = word.length();
        int totalPushes = 0;
        int currentPushCost = 1;
        
        // Loop through chunks of 8 letters
        while (n > 0) {
            int currentChunk = Math.min(n, 8);
            totalPushes += currentChunk * currentPushCost;
            n -= currentChunk;
            currentPushCost++; // Next set of keys will require one extra push
        }
        
        return totalPushes;
    }
}