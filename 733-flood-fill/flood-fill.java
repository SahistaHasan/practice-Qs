class Pair{
    int row;
    int col;
    Pair(int row, int col){
        this.row=row;
        this.col=col;
    }
}
class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        Queue<Pair> que = new LinkedList<>();
        int ogcolor=image[sr][sc];
        boolean[][]vis=new boolean[image.length][image[0].length];
        que.offer(new Pair(sr,sc));
        while(!que.isEmpty()){
            int r=que.peek().row;
            int c=que.peek().col;
            que.poll();
            int []drow=new int[]{1,-1,0,0};
            int []dcol=new int[]{0,0,-1,1};
            for(int i=0;i<4;i++){
                int _r=r+drow[i];
                int _c=c+dcol[i];
                if(_r>=0 && _r<image.length && _c>=0 && _c<image[0].length && image[_r][_c]==ogcolor && !vis[_r][_c]){
                    que.offer(new Pair(_r,_c));
                    vis[_r][_c]=true;
                    image[_r][_c]=color;
                }
            }
        }
        image[sr][sc]=color;
        return image;
    }
}