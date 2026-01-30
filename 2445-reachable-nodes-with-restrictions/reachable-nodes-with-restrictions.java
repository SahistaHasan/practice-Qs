class Solution {
    Set<Integer> set= new HashSet<>();
    public void dfs(int node,boolean [] vis,List<List<Integer>> list){
        if(vis[node]) return;
        if(set.contains(node)) return;
        vis[node]=true;
        for(int i=0;i<list.get(node).size();i++){
            dfs(list.get(node).get(i),vis,list);
        }
        return;
    }
    public int reachableNodes(int n, int[][] edges, int[] restricted) {
       
        for(int i=0;i<restricted.length;i++){
            set.add(restricted[i]);
        }
        boolean [] vis = new boolean [n];
        List<List<Integer>> list = new ArrayList<>();
        for(int i=0;i<n;i++){
           list.add(new ArrayList<>());
        }
        for(int i=0;i<edges.length;i++){
            list.get(edges[i][0]).add(edges[i][1]);
            list.get(edges[i][1]).add(edges[i][0]);
        }
        dfs(0,vis,list);
        int count=0;
        for(int i=0;i<vis.length;i++){
            if(vis[i]) count++;
        }
        return count;
    }
}