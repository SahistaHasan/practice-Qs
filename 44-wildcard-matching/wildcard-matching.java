class Solution {
    // public boolean solve(String s, String p, int index1, int index2, Boolean [][] dp){
    //     if(index2<0 && index1<0) return true;
    //     if(index2<0 && index1>=0) return false;
    //     if(index2>=0 && index1<0){
    //         for(int i=index2;i>=0;i--){
    //            if(p.charAt(i)!='*') return false;
    //         }
    //         return true;
    //     }
    //     if(dp[index1][index2]!=null) return dp[index1][index2];
    //     boolean match=false;
    //     boolean notmatch1=false;
    //     boolean notmatch2=false;
    //     if(s.charAt(index1)==p.charAt(index2) || p.charAt(index2)=='?'){
    //         match=solve(s,p,index1-1,index2-1,dp);
    //     }
    //     if(p.charAt(index2)=='*'){
    //         notmatch1=solve(s,p,index1-1,index2,dp);
    //         notmatch2=solve(s,p,index1,index2-1,dp);
    //     }
        
    //     return dp[index1][index2]=match || notmatch1 || notmatch2 || false;
    // }
    public boolean solve(String s, String p, Boolean [][] dp){
          dp[0][0]=true;
          for(int i=1;i<=s.length();i++){
            dp[i][0]=false;
          }
          for(int i=1;i<=p.length();i++){
            dp[0][i] = dp[0][i-1] && p.charAt(i-1)=='*';
}
          for(int i=1;i<=s.length();i++){
            for(int j=1;j<=p.length();j++){
                if(s.charAt(i-1)==p.charAt(j-1) || p.charAt(j-1)=='?'){
                    dp[i][j]=dp[i-1][j-1];
                }
                else if(p.charAt(j-1)=='*'){
                    dp[i][j]=dp[i-1][j] || dp[i][j-1];
                }
                else dp[i][j]=false;
            }
          }
          return dp[s.length()][p.length()];
    }
    public boolean isMatch(String s, String p) {
        Boolean [][] dp = new Boolean [s.length()+1][p.length()+1];
         return solve(s,p,dp);
    
    }
}