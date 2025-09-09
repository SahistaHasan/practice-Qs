class Pair{
    int row;
    int col;

    Pair(int row, int col){
        this.row=row;
        this.col=col;
        }
        }
    class Solution {
    List<List<Integer>> outer = new ArrayList<>();
    public void bfs(boolean[][]vis, int r, int c, int[][]land){
        Queue<Pair> que = new LinkedList<>();
        que.offer(new Pair(r,c));
        vis[r][c]=true;
         int minRow = r;
        int minCol = c;
        int maxRow = r;
        int maxCol = c;
        
        while(!que.isEmpty()){
           
           int n =que.size();
           for(int p=0;p<n;p++){
            int [] drow=new int[]{0,0,1,-1};
            int [] dcol =new int[]{-1,1,0,0};
            int currrow=que.peek().row;
            int currcol=que.peek().col;
            que.poll();
            minRow=Math.min(minRow,currrow);
            minCol=Math.min(minCol,currcol);
            maxRow=Math.max(maxRow,currrow);
            maxCol=Math.max(maxCol,currcol);
            for(int i=0;i<4;i++){
                int _r=currrow+drow[i];
                int _c=currcol+dcol[i];
                if(_r>=0 && _r<land.length && _c>=0 && _c<land[0].length && land[_r][_c]==1 && vis[_r][_c]==false){
                    que.offer(new Pair(_r,_c));
                    vis[_r][_c]=true;
                }
            }
           }
           
        }
        List<Integer> list = new ArrayList<>();
        list.add(minRow);
        list.add(minCol);
        list.add(maxRow);
        list.add(maxCol);
       
        outer.add(new ArrayList<>(list));
        return;
    }
    public int[][] findFarmland(int[][] land) {
        boolean [][] vis = new boolean [land.length][land[0].length];
        for(int i=0;i<land.length;i++){
            for (int j=0;j<land[0].length;j++){
                if(land[i][j]==1 && vis[i][j]==false){
                    bfs(vis,i,j,land);
                }
            }
        }
        int[][] result = new int[outer.size()][4];
        for (int i = 0; i < outer.size(); i++) {
            List<Integer> farmland = outer.get(i);
            for (int j = 0; j < 4; j++) {
                result[i][j] = farmland.get(j);
            }
        }
        return result;
    }
}