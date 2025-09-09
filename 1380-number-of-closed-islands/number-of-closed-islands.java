class Pair{
    int row;
    int col;
    Pair(int row, int col){
        this.row=row;
        this.col=col;
    }
}
    class Solution {
    
    public boolean bfs(boolean[][] vis, int r, int c, int [][]grid){
        boolean flag=true;
    Queue<Pair> que = new LinkedList<>();
    que.offer(new Pair(r,c));
    vis[r][c]=true;
    while(!que.isEmpty()){
        int n=que.size();
        for (int p=0;p<n;p++){
            int [] drow=new int[]{0,0,1,-1};
            int [] dcol =new int[]{1,-1,0,0};
            int currow=que.peek().row;
            int curcol=que.peek().col;
            que.poll();
            for(int i=0;i<4;i++){
                int _r=currow+drow[i];
                int _c=curcol+dcol[i];
                if(_r>=0 && _r<grid.length && _c>=0 && _c<grid[0].length && grid[_r][_c]==0 && vis[_r][_c]==false){
                     if(_r==0 || _r==grid.length-1 || _c==0 || _c==grid[0].length-1) flag= false;
                     que.offer(new Pair(_r,_c));
                     vis[_r][_c]=true;
                }
            }
        }
    }
    return flag;
    }
    public int closedIsland(int[][] grid) {
        boolean[][] vis=new boolean [grid.length][grid[0].length];
        int count=0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==0 && i!=0 && i!=grid.length-1 && j!=0 && j!=grid[0].length-1 && vis[i][j]==false){
                   if( bfs(vis,i,j,grid)){
                    count++;
                   }
                }
            }
        }
        return count;
    }
}