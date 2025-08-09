class Solution {
    public int recurse(List<List<Integer>> list, int i,int j,int[][]dp ){
        if(i>list.size()-1 || j>i  || j<0){
          return Integer.MAX_VALUE;
        }
        if(i==list.size()-1){
            return list.get(i).get(j);
        }
        if(dp[i][j]!=-2) return dp[i][j];
        int min=Integer.MAX_VALUE;
        
           int adj1=list.get(i).get(j)+recurse(list,i+1,j,dp);
           int adj2=list.get(i).get(j)+recurse(list,i+1,j+1,dp);
           dp[i][j]=Math.min(adj1,adj2);
        
        return dp[i][j];
        

    }
    public int minimumTotal(List<List<Integer>> triangle) {
      int n = triangle.size();
        int[][] dp = new int[n][n];

       
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], -2);
        }
        return recurse(triangle,0,0,dp);
     
}
}