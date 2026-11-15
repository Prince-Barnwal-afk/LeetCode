class Solution {
    public int numOfSubarrays(int[] arr) {
        int MOD = 1_000_000_007;

        int [] prifix = new int[arr.length+1];
        prifix[0] = 0;

        for(int i = 1; i <= arr.length; i++){
            prifix[i] = prifix[i - 1] + arr[i - 1];
        }

        int ans = 0;
        int odd = 0;
        int even = 0;

        for(int i = 0; i < prifix.length; i++){
            if(prifix[i] % 2 == 0){
                ans = (ans + odd) % MOD;
                even++;
            }else{
                ans = (ans + even) % MOD;
                odd++;
            }
        }
        return ans;
    }
}