class Solution {
    // public int solve(String s, String t, int index1, int index2,int [][] dp){
    //   if(index2<0) return 1;
    //   if(index1<0) return 0;
    //   if(dp[index1][index2]!=-1) return dp[index1][index2];
    //   int match1=0;
    //   int match2=0;
    //   int notmatch=0;
    //   if(s.charAt(index1)==t.charAt(index2)){
    //        match1=solve(s,t,index1-1,index2-1,dp);
    //        match2=solve(s,t,index1-1,index2, dp);
    //   }
    //   else notmatch=solve(s,t,index1-1,index2,dp);
    //   return dp[index1][index2]=match1+match2+notmatch;
    // }
    
    public int solve(String s, String t,int [][] dp){
        for(int i=0;i<=s.length();i++){
            dp[i][0]=1;
    }
    for(int i=1;i<=t.length();i++){
        dp[0][i]=0;
    }
    for(int i=1;i<=s.length();i++){
        for(int j=1;j<=t.length();j++){
           if(s.charAt(i-1)==t.charAt(j-1)){
            dp[i][j]=dp[i-1][j-1]+dp[i-1][j];
           }
           else{
            dp[i][j]=dp[i-1][j];
           }
        }
    }
    return dp[s.length()][t.length()];

    }
    public int numDistinct(String s, String t) {
        int [][] dp = new int[s.length()+1][t.length()+1];
        // for(int i=0;i<dp.length;i++){
        //     Arrays.fill(dp[i],-1);
        // }
return solve(s,t,dp);
    }
}