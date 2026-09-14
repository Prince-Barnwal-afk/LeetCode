class Solution {
    public int bagOfTokensScore(int[] tokens, int power) {
        int res = 0; int score = 0;
        int l = 0; int r = tokens.length-1;

        Arrays.sort(tokens);

        while(l <= r){
            if(power >= tokens[l]){
                power -= tokens[l];
                score += 1;
                l++;
                res = Math.max(res,score);
            }
            else if(score > 0){
                power += tokens[r];
                r--;
                score -= 1;
            }else{
                break;
            }
        }
        return res;
    }
}