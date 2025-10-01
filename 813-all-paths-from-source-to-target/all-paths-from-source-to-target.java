class Solution {
    List<List<Integer>> list =new ArrayList<>();
    public void dfs(int[][] graph,int node,List<Integer> inner,boolean []vis){
       if(node==graph.length-1){
        list.add(new ArrayList<>(inner));
        return;
       }
       for(int i=0;i<graph[node].length;i++){
        if(vis[graph[node][i]]==false){
        inner.add(graph[node][i]);
        vis[graph[node][i]]=true;
         dfs(graph,graph[node][i],inner,vis);
         inner.remove(inner.size()-1);
         vis[graph[node][i]]=false;
        }
       }
       
       return;
    }
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<Integer> inner = new ArrayList<>();
        boolean [] vis = new boolean[graph.length];
        inner.add(0);
        dfs(graph,0,inner,vis);
        return list;
    }
}