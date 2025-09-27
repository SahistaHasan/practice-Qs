class Pair{
    int node;
    int dist;
    Pair(int node, int dist){
        this.node=node;
        this.dist=dist;
    }
    }
    class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        int [] dist=new int[n+1];
        Arrays.fill(dist,Integer.MAX_VALUE);
        dist[k] = 0;
        List<List<Pair>> list = new ArrayList<>();
        for(int i=0;i<=n;i++){
            List<Pair> inner=new ArrayList<>();
            list.add(inner);
        }
        for(int i=0;i<times.length;i++){
                
                list.get(times[i][0]).add(new Pair(times[i][1],times[i][2]));
            
        }
      PriorityQueue <Pair> que=new PriorityQueue<>((a, b) -> a.dist - b.dist);;
      que.offer(new Pair(k,0));
      while(!que.isEmpty()){
       Pair p = que.poll();
       int u=p.node;
       int d = p.dist;
       for(int i=0;i<list.get(u).size();i++){
        if(dist[list.get(u).get(i).node]>d+list.get(u).get(i).dist){
            dist[list.get(u).get(i).node]=d+list.get(u).get(i).dist;
            que.offer(new Pair(list.get(u).get(i).node,d+list.get(u).get(i).dist));
        }
       }
      }
      int ans = 0;
for(int i = 1; i <= n; i++) {  // from 1 to n, because nodes are 1-indexed
    if(dist[i] == Integer.MAX_VALUE) return -1;  // unreachable node
    ans = Math.max(ans, dist[i]);
}


        return ans; 
    }
}