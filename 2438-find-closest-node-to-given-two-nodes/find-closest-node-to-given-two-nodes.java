class Pair{
    int node;
    int distance;
    Pair(int node, int distance){
       this.node=node;
       this.distance=distance;
    }
}
class Solution {
    List<List<Integer>> list = new ArrayList<>();
    public void bfs(int [] dist, int node){
        Queue<Pair> que = new LinkedList<>();
        que.add(new Pair(node,0));
        while(!que.isEmpty()){
           Pair parent = que.poll();
           for(int i=0;i<list.get(parent.node).size();i++){
            if(dist[list.get(parent.node).get(i)]==Integer.MAX_VALUE){
                que.add(new Pair(list.get(parent.node).get(i),parent.distance+1));
                dist[list.get(parent.node).get(i)]=parent.distance+1;
            }
           }
        }
        return;
    }
    public int closestMeetingNode(int[] edges, int node1, int node2) {
        int [] dist1= new int[edges.length];
        int [] dist2= new int[edges.length];
        Arrays.fill(dist1,Integer.MAX_VALUE);
        Arrays.fill(dist2,Integer.MAX_VALUE);
        dist1[node1]=0;
        dist2[node2]=0;
        for(int i=0;i<edges.length;i++){
            list.add(new ArrayList<>());
        }
        for(int i=0;i<edges.length;i++){
            if(edges[i]==-1) continue;
            list.get(i).add(edges[i]);
    }
        bfs(dist1,node1);
        bfs(dist2,node2);
        int node=-1;
        int min=Integer.MAX_VALUE;
        for(int i=0;i<dist1.length;i++){
           if(dist1[i]!=Integer.MAX_VALUE && dist2[i]!=Integer.MAX_VALUE){
              if(Math.max(dist1[i],dist2[i])<min){
                node=i;
                min=Math.max(dist1[i],dist2[i]);
              }
           }
        }
        return node;
    }
}