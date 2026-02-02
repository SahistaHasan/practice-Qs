class Solution {
    public int countones(String s){
       int count=0;
       for(int i=0;i<s.length();i++){
        if(s.charAt(i)=='1') count++;
       }
       return count;
    }
     public int countzeroes(String s){
       int count=0;
       for(int i=0;i<s.length();i++){
        if(s.charAt(i)=='0') count++;
       }
       return count;
    }
    public int solve(String [] strs, int index,int zeroes, int ones,int m, int n,int [][][] dp){
        if(zeroes>m || ones>n) return Integer.MIN_VALUE;
        if(index==strs.length) return 0; 

        if(dp[index][zeroes][ones]!=-1) return dp[index][zeroes][ones];
        int c1=countones(strs[index]);
        int c0=countzeroes(strs[index]);
        int pick=1+solve(strs,index+1,zeroes+c0,ones+c1,m,n,dp);
        int notpick =solve(strs,index+1,zeroes,ones,m,n,dp);
        return dp[index][zeroes][ones]=Math.max(pick,notpick);
    }
    public int findMaxForm(String[] strs, int m, int n) {
        int [][][] dp = new int[strs.length][m+1][n+1];
        for(int i=0;i<strs.length;i++){
            for(int j=0;j<=m;j++){
                for(int k=0;k<=n;k++){
                    dp[i][j][k]=-1;
                }
            }
        }
        return solve(strs,0,0,0,m,n,dp);

    }
}