class Solution {
    public boolean dfs(int node,int parent,int[]color, int[][]graph,List<List<Integer>> list){
        if(parent!=-1 && color[node]!=-1 ){
            if(color[node]==color[parent]) return false;
            else{
                return true;
            }
        }
        
        if(color[node]==-1 && parent!=-1 && color[parent]==0){
            color[node]=1;
        }
        else if(color[node]==-1 && parent!=-1 &&  color[parent]==1){
            color[node]=0;
        }
        for(int child : list.get(node)){
            if(!dfs(child,node,color,graph,list)){
                return false;
            }
        }
        return true;

    }
    public boolean isBipartite(int[][] graph) {
        List<List<Integer>> list=new ArrayList<>();
        for(int i=0;i<graph.length;i++){
            List<Integer> inner = new ArrayList<>();
            for(int j=0;j<graph[i].length;j++){
                inner.add(graph[i][j]);
            }
            list.add(new ArrayList<>(inner));
        }
       int [] color=new int[graph.length];
       for(int i=0;i<color.length;i++){
        color[i]=-1;
       }
       for(int i=0;i<graph.length;i++){
        if(color[i]==-1){
            color[i]=1;
            if(!dfs(i,-1,color,graph,list)){
               return false;
            }
        }
       }
       return true;

    }
}