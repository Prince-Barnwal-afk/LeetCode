class Solution {
    public int[] minOperations(String boxes) {
        int n = boxes.length();
        int[] answer = new int[n];

        // Pass 1: Left to Right
        // Move balls on the left of 'i' to index 'i'
        int balls = 0;
        int moves = 0;
        for (int i = 0; i < n; i++) {
            answer[i] += moves;
            balls += (boxes.charAt(i) - '0');
            moves += balls; // Each existing ball takes 1 step to reach the next index
        }

        // Pass 2: Right to Left
        // Move balls on the right of 'i' to index 'i'
        balls = 0;
        moves = 0;
        for (int i = n - 1; i >= 0; i--) {
            answer[i] += moves;
            balls += (boxes.charAt(i) - '0');
            moves += balls;
        }

        return answer;
    }
}