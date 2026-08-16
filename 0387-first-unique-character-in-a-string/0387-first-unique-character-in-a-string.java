class Solution {
    public int firstUniqChar(String s) {
        int[] ans = new int[26];
        for(int i = 0; i < s.length(); i++){  
            char ch = s.charAt(i);
            ans[ch - 'a']++;
        }
        
        for(int i = 0; i < s.length(); i++){  
            char ch = s.charAt(i);
            if(ans[ch - 'a'] == 1){
                return i;  
            }
        }
        
        return -1;
    }
}   