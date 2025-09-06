class Solution {
    public boolean dfs(boolean[] vis,boolean [] path,int i, List<List<Integer>> list){
        if(path[i]) return true;
        if(vis[i]) return false;
        
        vis[i]=true;
        path[i]=true;
        for(int j=0;j<list.get(i).size();j++){
            
            if(dfs(vis,path,list.get(i).get(j),list)) return true;
           
        }
        path[i]=false;
        return false;
        
    }
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        boolean [] vis=new boolean[numCourses];
        boolean [] path = new boolean [numCourses];
        List<List<Integer>> list = new ArrayList<>();
        for(int i=0;i<numCourses;i++){
            List<Integer> inner = new ArrayList<>();
            list.add(inner);
        }
        for(int i=0;i<prerequisites.length;i++){
            list.get(prerequisites[i][1]).add(prerequisites[i][0]);
           
        }
        for(int i=0;i<list.size();i++){
            if(!vis[i]) {
                if(dfs(vis,path,i,list)){
                    return false;
                }
            }

        }
        return true;
    }
}