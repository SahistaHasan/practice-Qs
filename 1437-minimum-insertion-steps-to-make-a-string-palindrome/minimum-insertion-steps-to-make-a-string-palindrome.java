class Solution {
    public int solve( String s1, String s2,int [][] dp){
      for(int i=0;i<=s1.length()-1;i++){
        dp[0][i]=0;
        dp[i][0]=0;
      }
      for(int i=1;i<=s1.length();i++){
        for(int j=1;j<=s2.length();j++){
            if(s1.charAt(i-1)==s2.charAt(j-1)){
                dp[i][j]=1+dp[i-1][j-1];
            }
            else{
                dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
            }
        }
      }
       return dp[s1.length()][s2.length()];
    }
    public int minInsertions(String s) {
         int [][] dp = new int[s.length()+1][s.length()+1];
        for(int i=0;i<dp.length;i++){
            Arrays.fill(dp[i],-1);
        }
        StringBuilder sb = new StringBuilder();
        sb.append(s);
        String s1 = sb.reverse().toString();
        return s.length()-solve(s1,s,dp);
    }
}