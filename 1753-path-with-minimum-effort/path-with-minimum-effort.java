class Pair{
    int dist;
    int x;
    int y;
    Pair(int dist,int x,int y){
        this.dist=dist;
        this.x=x;
        this.y=y;
    }
    }class Solution {
    public int minimumEffortPath(int[][] heights) {
        int [][] dist = new int[heights.length][heights[0].length];
        for(int i=0;i<dist.length;i++){
            Arrays.fill(dist[i],Integer.MAX_VALUE);
        }
        PriorityQueue<Pair> que = new PriorityQueue<>((a,b)->a.dist-b.dist);
        dist[0][0]=0;
        int [] drow={0,0,1,-1};
        int [] dcol={1,-1,0,0};
        que.offer(new Pair(0,0,0));
        while(!que.isEmpty()){
         Pair p =que.poll();
         int currx=p.x;
         int curry=p.y;
         int currdif=p.dist;
         for(int i=0;i<4;i++){
            int _x=currx+drow[i];
            int _y=curry+dcol[i];
            if(_x>=0 && _x<heights.length && _y>=0 && _y<heights[0].length ){
                int newEffort = Math.max(currdif, Math.abs(heights[currx][curry] - heights[_x][_y]));
                if (dist[_x][_y] > newEffort) {
                dist[_x][_y] = newEffort;
                que.offer(new Pair(newEffort, _x, _y));
                
            }
         }
        }
        }
return dist[heights.length-1][heights[0].length-1];
    }
}