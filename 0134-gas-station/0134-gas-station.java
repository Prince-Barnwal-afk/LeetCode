class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
       int start = 0;
       int curGas = 0;
       int totalgas = 0;
       int totalcost = 0;

       for(int i = 0; i<cost.length; i++){
            totalgas += gas[i];
            totalcost += cost[i];

            curGas += gas[i] - cost[i];
            if(curGas<0){
                start = i+1;
                curGas = 0;
            }
       } 
       if(totalgas<totalcost){
            return -1;
       }
       return start;
    }
}