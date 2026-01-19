class Solution {
     public int solve(int index1, int index2,String text1,String text2,int [][] dp){
        if(index1<0 || index2<0) return 0;
        int match=0;
        int notmatch1=0;
        int notmatch2=0;
        if(dp[index1][index2]!=-1) return dp[index1][index2];
        if(text1.charAt(index1)==text2.charAt(index2)){
             match = 1+solve(index1-1,index2-1,text1,text2,dp);
        }
        else{
            notmatch1=solve(index1-1,index2,text1,text2,dp);
            notmatch2=solve(index1,index2-1,text1,text2,dp);
        }
        return dp[index1][index2]=Math.max(match,Math.max(notmatch1,notmatch2));
    }
    public int minDistance(String word1, String word2) {
        int [][] dp = new int[word1.length()+1][word2.length()+1];
        for(int i=0;i<dp.length;i++){
            Arrays.fill(dp[i],-1);
        }
        return word1.length()+word2.length()-2*solve(word1.length()-1,word2.length()-1,word1,word2,dp);
    }
}