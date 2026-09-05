class Solution {
    public int[] findThePrefixCommonArray(int[] A, int[] B) {
        int n = A.length;
        int[] C = new int[n];
        int[] freq = new int[n + 1];
        int commonCount = 0;

        for (int i = 0; i < n; i++) {
            // Increment frequency for element in A
            freq[A[i]]++;
            if (freq[A[i]] == 2) {
                commonCount++;
            }

            // Increment frequency for element in B
            freq[B[i]]++;
            if (freq[B[i]] == 2) {
                commonCount++;
            }

            C[i] = commonCount;
        }

        return C;
    }
}