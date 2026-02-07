class Solution {
    int max=0;
    public void solve(String s1, String s2,int [][] dp){
        for(int i=0;i<=s1.length();i++){
            dp[i][0]=0;
        }
        for(int i=0;i<=s2.length();i++){
            dp[0][i]=0;
        }
        for(int i=1;i<=s1.length();i++){
            for(int j=1;j<=s2.length();j++){
                if(s1.charAt(i-1)==s2.charAt(j-1)){
                    dp[i][j]=s1.charAt(i-1)+dp[i-1][j-1];
                    max=Math.max(dp[i][j],max);
                }
                else{
                    dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }
        return ;
    }
    public int minimumDeleteSum(String s1, String s2) {
        int [][] dp = new int[s1.length()+1][s2.length()+1];
        solve(s1,s2,dp);
        
        int total = 0;
        for (char c : s1.toCharArray()) total += c;
        for (char c : s2.toCharArray()) total += c;
        return total-2*max;
    }
}