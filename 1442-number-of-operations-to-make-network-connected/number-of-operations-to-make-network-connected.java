class Solution {
    public void dfs(int i, boolean []vis,List<List<Integer>> list){
       if(vis[i]==true) return ;
       vis[i]=true;
       for(int j=0;j<list.get(i).size();j++){
        dfs(list.get(i).get(j),vis,list);
       }
       return;
    }
    public int makeConnected(int n, int[][] connections) {
        if(connections.length<n-1) return -1;
        boolean [] vis = new boolean[n];
        List<List<Integer>> list = new ArrayList<>();
        for(int i=0;i<n;i++){
           List<Integer> inner = new ArrayList<>();
           list.add(inner);
        }
        for (int[] conn : connections) {
    list.get(conn[0]).add(conn[1]);
    list.get(conn[1]).add(conn[0]);
}
        int components=0;
               for (int i = 0; i < n; i++) {
            if (!vis[i]) {
                components++;
                dfs(i, vis, list);
            }
        }
                
           
       
        return components-1;
    }
}