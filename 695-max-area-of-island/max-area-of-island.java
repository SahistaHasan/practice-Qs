class Pair{
    int i;
    int j;
    Pair(int i,int j){
        this.i=i;
        this.j=j;

    }
    }
    
    
    class Solution {
    public int bfs(int i, int j, int[][] grid, boolean [][] vis){
        int count=1;
      Queue<Pair> que=new LinkedList<>();
      que.offer(new Pair(i,j));
      vis[i][j]=true;
      while(!que.isEmpty()){
        int n=que.size();
        for(int p=0;p<n;p++){
            int []drow=new int[]{1,-1,0,0};
            int []dcol=new int[]{0,0,1,-1};
            int row=que.peek().i;
            int col=que.peek().j;
            que.poll();
            for(int q=0;q<4;q++){
                int _r=row+drow[q];
                int _c=col+dcol[q];
                if( _r>=0 && _r<grid.length && _c>=0 && _c<grid[0].length && grid[_r][_c]==1 && !vis[_r][_c] ){
                    vis[_r][_c]=true;
                    que.offer(new Pair(_r,_c));
                    count++;
                }
            }
        }
      }
      return count;
    }
    public int maxAreaOfIsland(int[][] grid) {
       
        boolean [][] vis=new boolean[grid.length][grid[0].length];
        int max=0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(!vis[i][j] && grid[i][j]==1){
                   max=Math.max(max,bfs(i,j,grid,vis));
                }
            }
        }
        return max;
    }
}