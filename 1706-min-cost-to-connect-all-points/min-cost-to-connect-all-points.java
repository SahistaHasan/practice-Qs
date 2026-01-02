class Pair{
    int node;
    int dist;
    Pair(int node, int dist){
        this.node=node;
        this.dist=dist;
    }
}
class Solution {
    public int minCostConnectPoints(int[][] points) {
        boolean [] vis = new boolean[points.length];
        PriorityQueue<Pair> que = new PriorityQueue<>((a,b)->a.dist-b.dist);
        que.add(new Pair(0,0));
        int sum=0;
        while(!que.isEmpty()){
            Pair p = que.poll();
            if(vis[p.node]){
                continue;
            }
            vis[p.node]=true;
            sum=sum+p.dist;
            for(int i=0;i<points.length;i++){
                if(!vis[i]){
                    int distance = Math.abs(points[p.node][0]-points[i][0])+Math.abs(points[p.node][1]-points[i][1]);
                    que.add(new Pair(i,distance));
                }
            }
        }
        return sum;
    }
}