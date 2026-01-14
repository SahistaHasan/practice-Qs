class Solution {
    int mod = 1000000007;
    public long solve(long [] dp, int n, int index){
        if(index<=0) return 1;
        if(dp[index]!=-1) return dp[index];
        long pick = solve(dp,n,index-2);
        long npick = solve(dp,n,index-1);
        long res=(pick+npick)%mod;
        return dp[index]=res;
    }
    public int countHousePlacements(int n) {
        long [] dp = new long[n+1];
        Arrays.fill(dp,-1);
        long res = solve(dp,n,n)%mod*solve(dp,n,n)%mod;
        return (int)res;
    }
}