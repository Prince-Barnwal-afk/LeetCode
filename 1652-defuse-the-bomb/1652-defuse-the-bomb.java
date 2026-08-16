class Solution {
    public int[] decrypt(int[] code, int k) {
        int n = code.length;
        int[] ans = new int[n];
        
        // Case 1: k is 0, return array of zeros
        if (k == 0) return ans;

        int l, r;
        
        // Initialize window boundaries using if-else
        if (k > 0) {
            // Next k elements: indices 1 to k
            l = 1;
            r = k;
        } else {
            // Previous |k| elements: indices n-|k| to n-1
            l = n + k; // equivalent to n - Math.abs(k)
            r = n - 1;
        }
        
        int sum = 0;
        // Calculate sum for the initial window
        for (int i = l; i <= r; i++) {
            sum += code[i];
        }

        // Slide the window across the array
        for (int i = 0; i < n; i++) {
            ans[i] = sum;
            
            // Remove the element leaving the window
            sum -= code[l % n];
            // Add the element entering the window
            sum += code[(r + 1) % n];
            
            // Move window pointers
            l++;
            r++;
        }
        
        return ans;
    }
}   