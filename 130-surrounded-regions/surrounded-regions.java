class Solution {
    public void dfs(char[][] board,int i,int j,boolean[][]vis){
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length) return;
        if(vis[i][j]) return;
        if(board[i][j]=='X') return;
        vis[i][j]=true;
        board[i][j]='S';
        int [] drow=new int []{1,-1,0,0};
        int [] dcol=new int []{0,0,1,-1};
        for(int p=0;p<4;p++){
            
            dfs(board,i+drow[p],j+dcol[p],vis);
        }
        return;
    }
    public void solve(char[][] board) {
        boolean [][] vis = new boolean[board.length][board[0].length];
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                if(board[i][j]=='O' && (i==0 || i==board.length-1 || j==0 || j==board[0].length-1)){
                    dfs(board,i,j,vis);
                }
            }
        }
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                if(board[i][j]=='S') board[i][j]='O';
                else if(board[i][j]=='O') board[i][j]='X';
            }
        }
        return;
    }
}