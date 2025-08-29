class Solution {
    public void dfs(int[][] board,int i,int j,boolean[][]vis){
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length) return;
        if(vis[i][j]) return;
        if(board[i][j]==0) return;
        vis[i][j]=true;
        board[i][j]=2;
        int [] drow=new int []{1,-1,0,0};
        int [] dcol=new int []{0,0,1,-1};
        for(int p=0;p<4;p++){
            
            dfs(board,i+drow[p],j+dcol[p],vis);
        }
        return;
    }
    public int numEnclaves(int[][] grid) {
        boolean [][] vis = new boolean[grid.length][grid[0].length];
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==1 && (i==0 || i==grid.length-1 || j==0 || j==grid[0].length-1)){
                    dfs(grid,i,j,vis);
                }
            }
        }
        int count=0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==1) count++;
                
            }
        }
        return count;
    }
}