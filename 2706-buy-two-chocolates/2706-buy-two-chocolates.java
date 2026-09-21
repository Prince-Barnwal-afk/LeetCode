class Solution {
    public int buyChoco(int[] prices, int money) {
        Arrays.sort(prices);
        int cheapest = prices[0];
        int secondCheap = prices[1];

        if(cheapest + secondCheap <= money){
            money -= cheapest + secondCheap;
        }
        return money;
    }
}