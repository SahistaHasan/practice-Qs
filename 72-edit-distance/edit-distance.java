class Solution {
    public int solve(String s1, String s2, int index1, int index2, int [][] dp){
        if(index1<0) return index2+1;
        if(index2<0) return index1+1;
        if(dp[index1][index2]!=-1) return dp[index1][index2];
        int match=Integer.MAX_VALUE;
        int notmatch1=Integer.MAX_VALUE;
        int notmatch2=Integer.MAX_VALUE;
        int notmatch3=Integer.MAX_VALUE;
        if(s1.charAt(index1)==s2.charAt(index2)){
             match=solve(s1,s2,index1-1,index2-1,dp);
        }
        else{
            notmatch1=1+solve(s1,s2,index1,index2-1,dp); //insert
            notmatch2=1+solve(s1,s2,index1-1,index2,dp); //delete
            notmatch3=1+solve(s1,s2,index1-1,index2-1,dp); //replace
        }
        return dp[index1][index2]=Math.min(match,Math.min(notmatch1,Math.min(notmatch2,notmatch3)));

    }
    public int minDistance(String word1, String word2) {
        int [][] dp = new int[word1.length()+1][word2.length()+1];
        for(int i=0;i<dp.length;i++){
            Arrays.fill(dp[i],-1);
        }
        return solve(word1,word2,word1.length()-1,word2.length()-1,dp);
    }
}