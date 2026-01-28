class Solution {
    // public int solve(int [] prices, int index, int buy,int no,int [][][]dp){
    //    if(no==0) return 0;
    //    if(index==prices.length) return 0;
    //     if(dp[index][buy][no]!=-1) return dp[index][buy][no];
    //     int prices1=0;
    //     int prices2=0;
    //     if(buy==1){
    //         prices1=-prices[index]+solve(prices,index+1,0,no,dp);
    //         prices2=solve(prices,index+1,1,no,dp);
    //     }
    //     else{
    //         prices1 = prices[index]+solve(prices,index+1,1,no-1,dp);
    //         prices2=solve(prices,index+1,0,no,dp);
    //     }
    //     return dp[index][buy][no]=Math.max(prices1,prices2);
    // }
     public int solve(int [] prices,int [][][] dp){
        // for(int i=0;i<dp.length;i++){
        //     for(int j=0;j<dp[i].length;j++){
        //         dp[i][j][0]=0;
        //     }
        // }
        // for(int i=0;i<dp.length;i++){
        //     for(int j=0;j<dp[i].length;j++){
        //         if(i==prices.length){
        //             dp[i][j][1]=0;
        //             dp[i][j][2]=0;
        //         }
        //     }
        // }
        for(int i=prices.length-1;i>=0;i--){
          for(int j=0;j<2;j++){
            for(int k=1;k<=2;k++){
                if(j==1){
                    dp[i][j][k]=Math.max(-prices[i]+dp[i+1][0][k],dp[i+1][1][k]);
                }
                else{
                    dp[i][j][k]=Math.max(prices[i]+dp[i+1][1][k-1],dp[i+1][0][k]);
                }
            }
          }
        }
        return dp[0][1][2];
     }
    public int maxProfit(int[] prices) {
        int [][][] dp = new int[prices.length+1][2][3];
//         for (int i = 0; i < dp.length; i++) {
//            for (int j = 0; j < dp[i].length; j++) {
//                 Arrays.fill(dp[i][j], -1);
//     }
// }
         return solve(prices,dp);
        
    }
}