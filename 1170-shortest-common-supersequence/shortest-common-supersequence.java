class Solution {
    public int solve (String s1, String s2, int[][]dp){
        for(int i=0;i<=s1.length();i++){
            dp[i][0]=0;
        }
        for(int i=0;i<=s2.length();i++){
           dp[0][i]=0;
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
    public String shortestCommonSupersequence(String str1, String str2) {
        int [][] dp = new int[str1.length()+1][str2.length()+1];
        String s1=str1;
        String s2=str2;
        solve(s1,s2,dp);
        int i=s1.length();
        int j=s2.length();
        StringBuilder sb = new StringBuilder();
        while(i>0 && j>0){
            if(s1.charAt(i-1)==s2.charAt(j-1)){
                sb.append(s1.charAt(i-1));
                i--;
                j--;
            }
            else{
                if(dp[i-1][j]>dp[i][j-1]){
                    sb.append(s1.charAt(i-1));
                    i=i-1;
                }
                else {
                    sb.append(s2.charAt(j-1));
                    j=j-1;
                }
            }
        }
        while(i!=0 || j!=0){
            if(i!=0){
                sb.append(s1.charAt(i-1));
                i=i-1;
            }
            else{
                sb.append(s2.charAt(j-1));
                j=j-1;
            }
        }
        return sb.reverse().toString();
    }
}