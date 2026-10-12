
class Solution {
    public int maxSum(List<Integer> nums, int k) {
        int[] counts = new int[32];
        for (int num : nums) {
            int temp = num;
            int i = 0;
            while (temp > 0) {
                if (temp % 2 != 0) {
                    counts[i]++;
                }
                temp /= 2;
                i++;
            }
        }

        long[] built = new long[k];
        for (int i = 31; i >= 0; i--) {
            int count = counts[i];
            long powerOfTwo = 1;
            for (int p = 0; p < i; p++) {
                powerOfTwo *= 2;
            }
            for (int j = 0; j < k && count > 0; j++) {
                built[j] += powerOfTwo;
                count--;
            }
        }

        long mod = 1_000_000_007;
        long total = 0;
        for (int i = 0; i < k; i++) {
            total = (total + (built[i] * built[i]) % mod) % mod;
        }

        return (int) total;
    }
}