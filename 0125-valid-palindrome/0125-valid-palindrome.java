class Solution {
    public boolean isPalindrome(String s) {
        int l = 0, r = s.length() - 1;

        while (l < r) {
            char cl = s.charAt(l);
            char cr = s.charAt(r);

            if (!Character.isLetterOrDigit(cl)) { l++; continue; }
            if (!Character.isLetterOrDigit(cr)) { r--; continue; }

            if (Character.toLowerCase(cl) != Character.toLowerCase(cr)) {
                return false;
            }

            l++;
            r--;
        }

        return true;
    }
}