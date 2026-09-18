class Solution {
    public boolean isStrictlyPalindromic(int n) {
        int base = 0;
        int rem = 0;
        int placeValue = 1;

        for(int i = 2; i <= n-2; i++){
            int x = n;
            while(x > 0){
                rem = x % i;
                base += rem * placeValue;
                placeValue *= 10;
                x /= i; 
            }
            if(isPalindrome(base) == false) return false;
        }
        return true;
    }

    public boolean isPalindrome(int base){
        int reverse = 0;
        int x = base;
        while(x>0){
            int digit = x % 10;
            reverse = reverse * 10 + digit;
            x = x / 10;
        }
        if(reverse == base) return true;
        else return false;
    }
}