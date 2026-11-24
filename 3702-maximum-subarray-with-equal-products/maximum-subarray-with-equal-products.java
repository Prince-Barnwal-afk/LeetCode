class Solution {
    public int maxLength(int[] nums) {
        int n = nums.length;
        int ans = 0;

        long maxLcm = 1;
        int maxVal = 0;
        for (int x : nums) {
            maxLcm = lcm(maxLcm, x);
            if (x > maxVal) {
                maxVal = x;
            }
        }
        long maxBound = maxLcm * maxVal;

        for (int i = 0; i < n; i++) {
            long prod = 1;
            long g = 0;
            long l = 1;
            for (int j = i; j < n; j++) {
                int x = nums[j];
                prod *= x;
                if (prod > maxBound) {
                    break;
                }
                g = gcd(g, x);
                l = lcm(l, x);
                if (prod == g * l) {
                    ans = Math.max(ans, j - i + 1);
                }
            }
        }

        return ans;
    }

    public static long gcd(long a, long b) {
        while (b != 0) {
            long t = a % b;
            a = b;
            b = t;
        }
        return a;
    }

    public static long lcm(long a, long b) {
        if (a == 0 || b == 0) {
            return 0;
        }
        return (a / gcd(a, b)) * b;
    }
}