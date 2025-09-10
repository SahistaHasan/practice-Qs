class Solution {
    List<Integer> res=new ArrayList<>();
    public int dfs(List<List<Integer>> list, boolean [] vis, boolean[]path, int [] safenode,int i ){
        if(safenode[i]==1 || safenode[i]==0) return safenode[i];
         if(vis[i] && path[i]) {
            safenode[i]=0;
            return safenode[i];
         }
         vis[i]=true;
         path[i]=true;
        
         for(int p=0;p<list.get(i).size();p++){
            if(dfs(list,vis,path,safenode,list.get(i).get(p))==0){
                safenode[i]=0;
                return 0;
            }
           
         }
         path[i]=false;
         safenode[i]=1;
         res.add(i);
         return 1;


    }
    public List<Integer> eventualSafeNodes(int[][] graph) {
        boolean []vis=new boolean[graph.length];
        boolean []path=new boolean[graph.length];
        int []safenode=new int[graph.length];
        for(int i=0;i<safenode.length;i++){
            safenode[i]=-1;
        }
        List<List<Integer>> list=new ArrayList<>();
        for(int i=0;i<graph.length;i++){
            List<Integer> inner = new ArrayList<>();
            for(int nodes:graph[i]){
                inner.add(nodes);
            }
            list.add(inner);
        }
        for(int i=0;i<list.size();i++){
           if(!vis[i]){
            dfs(list,vis,path,safenode,i);
           }
        }
         Collections.sort(res);
         return res;
    }
}