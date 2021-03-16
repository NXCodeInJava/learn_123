class Solution {
    public int maxProfit(int[] prices) {
        // 是知道后面每一天的价格的
        // 在同一天可以先卖再买
        int maxProfit = 0;
        for(int n =0; n<prices.length-1;n++){
            if(prices[n+1]>prices[n]){
                maxProfit+=prices[n+1]-prices[n];
            }                        
        }
        return maxProfit;
    }
}