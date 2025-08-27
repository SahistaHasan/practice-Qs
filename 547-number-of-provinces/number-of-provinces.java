class Solution {
    public void bfs(int [][]isConnected, boolean []vis,List<List<Integer>> list,int i){
     Queue<Integer> que = new LinkedList<>();
     que.offer(i);
     while(!que.isEmpty()){
        int curr =que.poll();
        for(int neighbour : list.get(curr)){
            if(!vis[neighbour]){
               que.offer(neighbour);
               vis[neighbour]=true;
            }
        }
     }
    }
    public int findCircleNum(int[][] isConnected) {
        List<List<Integer>> list = new ArrayList<>();
        boolean [] vis = new boolean[isConnected.length];
        for(int p=0;p<isConnected.length;p++){
            list.add(new ArrayList<>());
        }
        for(int i=0;i<isConnected.length;i++){
            for(int j=0;j<isConnected[i].length;j++){
                if(isConnected[i][j]==1 && i!=j){
                list.get(i).add(j);
                list.get(j).add(i);
                }
            }
        }
        int provinces=0;
        for(int i=0;i<isConnected.length;i++){
           if(!vis[i]){
            provinces++;
            vis[i]=true;
            bfs(isConnected,vis,list,i);
           }
        }
         return provinces;
    }
}