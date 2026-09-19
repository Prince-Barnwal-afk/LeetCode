class Solution {
    public int maxScore(String s) {
        int totalOnes = 0;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '1') {
                totalOnes++;
            }
        }

        int maxScore = 0;
        int leftZeros = 0;
        int leftOnes = 0;

        for (int i = 0; i < s.length() - 1; i++) {
            if (s.charAt(i) == '0') {
                leftZeros++;
            } else {
                leftOnes++;
            }

            int rightOnes = totalOnes - leftOnes;
            int currentScore = leftZeros + rightOnes;

            if (currentScore > maxScore) {
                maxScore = currentScore;
            }
        }

        return maxScore;
    }
}