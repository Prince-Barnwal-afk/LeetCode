class Solution {
    public int countPrimes(int n) {
        boolean [] notprime = new boolean[n];

        for(int i = 2; i * i < n; i++){
            if(!notprime[i]){
                for(int j = i * i; j < n; j = j + i){
                    notprime[j] = true;
                }
            }
        }
        int count = 0;
        for(int i = 2; i < n; i++){
            if(!notprime[i]){
                count++;
            }
        }
        return count;
    }
}