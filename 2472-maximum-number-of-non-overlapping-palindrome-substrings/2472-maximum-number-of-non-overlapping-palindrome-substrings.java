class Solution {
    public int maxPalindromes(String s, int k) {
        int count = 0;
        int n = s.length();
        int i = 0;

        while (i <= n - k) {
            // Check if there's a valid palindrome of length k starting at i
            if (isPalindrome(s, i, i + k - 1)) {
                count++;
                i += k; // Jump past this palindrome to ensure non-overlapping
            } 
            // Check if there's a valid palindrome of length k + 1 starting at i
            else if (i + k < n && isPalindrome(s, i, i + k)) {
                count++;
                i += k + 1; // Jump past this palindrome
            } 
            // Neither found, step forward by 1
            else {
                i++;
            }
        }

        return count;
    }

    private boolean isPalindrome(String s, int l, int r) {
        while (l < r) {
            if (s.charAt(l) != s.charAt(r)) {
                return false;
            }
            l++;
            r--;
        }
        return true;
    }
}