class Solution {
    public int solve(int [] piles, int [][] dp, int index1, int index2){
        if(index1>index2) return 0;
        if(dp[index1][index2]!=-1) return dp[index1][index2];
        int pickleft=piles[index1]+Math.min(solve(piles,dp,index1+2,index2),solve(piles,dp,index1+1,index2-1));
        int pickright= piles[index2]+Math.min(solve(piles,dp,index1+1,index2-1),solve(piles,dp,index1,index2-2));
        return dp[index1][index2]=Math.max(pickleft,pickright);
    }
    public boolean stoneGame(int[] piles) {
        int [][] dp = new int[piles.length][piles.length];
        for(int i=0;i<dp.length;i++){
            Arrays.fill(dp[i],-1);
        }
        int sum=0;
        for(int i=0;i<piles.length;i++){
            sum=sum+piles[i];
        }
        int maxA =solve(piles,dp,0,piles.length-1);
        return maxA>(sum-maxA);
    }
}