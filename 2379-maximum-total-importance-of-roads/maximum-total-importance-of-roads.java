class Pair{
    int node;
    int outdegree;
    Pair(int node, int outdegree){
        this.node=node;
        this.outdegree=outdegree;
    }
}
class Solution {
    public long maximumImportance(int n, int[][] roads) {
        List<List<Integer>> list = new ArrayList<>();
        for(int i=0;i<n;i++){
            List<Integer> inner = new ArrayList<>();
            list.add(inner);
        }
        for(int i=0;i<roads.length;i++){
            list.get(roads[i][0]).add(roads[i][1]);
            list.get(roads[i][1]).add(roads[i][0]);
        }
        PriorityQueue<Pair> que = new PriorityQueue<>((a,b)->b.outdegree-a.outdegree);
        for(int i=0;i<list.size();i++){
            que.add(new Pair(i,list.get(i).size()));
        }
        int [] values = new int[n];
        int ini=n;
        for(int i=0;i<n;i++){
            Pair p = que.poll();
            values[p.node]=ini;
            ini--;
        }
        long sum=0;
        for(int i=0;i<roads.length;i++){
            sum=sum+values[roads[i][1]]+values[roads[i][0]];
        }

     return sum;
    }
}