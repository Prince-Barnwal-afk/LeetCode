class Solution {
    public boolean checkIfPangram(String sentence) {
         boolean [] seen = new boolean[26];
         int count = 0;

         if(sentence.length() < 26) return false;

         for(int i = 0; i < sentence.length() ; i++){
            int index = sentence.charAt(i) - 'a' ;
            if(!seen[index]){
                seen[index] = true;
                count++;
                if(count == 26) return true;
            }
         }
         return false;
    }
}