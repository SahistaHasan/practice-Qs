class Solution {
    public void gameOfLife(int[][] board) {
            int [][] bd = new int[board.length][board[0].length]; 
            for(int i=0;i<board.length;i++){
                for(int j=0;j<board[0].length;j++){
                    bd[i][j]=board[i][j];
                }
            }
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                int count=0;
                
                int [] drow={0,0,1,-1,1,-1,1,-1};
                int [] dcol ={1,-1,0,0,1,-1,-1,1};
                for(int p=0;p<8;p++){
                    if(drow[p]+i>=0 && drow[p]+i<=board.length-1 && dcol[p]+j>=0 && dcol[p]+j<=board[0].length-1 && board[drow[p]+i][dcol[p]+j]==1){
                        count++;
                    }
                }
                 if(board[i][j]==0 && count==3) bd[i][j]=1;
                 else if(board[i][j]==1){
                    if(count<2) bd[i][j]=0;
                    else if(count==2 || count==3) continue;
                    else bd[i][j]=0;
                 }
                
            }
        }
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                board[i][j]=bd[i][j];
            }
        }
        return;
    }
}