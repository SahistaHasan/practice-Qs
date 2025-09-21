class Solution {
    public int maxProfit(int[] prices) {
        int sum=0;
        int sell=0;
        for(int i=prices.length-1;i>=0;i--){
            if(prices[i]>sell){
                sell=prices[i];
            }
            else{
                sum=sum+(sell-prices[i]);
                sell=prices[i];
            }
        }
        return sum;
    }
}