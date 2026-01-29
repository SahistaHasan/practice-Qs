class Solution {
    public void dfs(List<List<Integer>> list,int node, List<Integer> ans){
       
       
       for(int i=0;i<list.get(node).size();i++){
        if(ans.contains(list.get(node).get(i))) continue;
        ans.add(list.get(node).get(i));
           dfs(list,list.get(node).get(i),ans);
       }
       return;
    }
    public List<List<Integer>> getAncestors(int n, int[][] edges) {
        List<List<Integer>> adj = new ArrayList<>();
        List<List<Integer>> indegree = new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
            indegree.add(new ArrayList<>());
        }
        for(int i=0;i<edges.length;i++){
            adj.get(edges[i][0]).add(edges[i][1]);
        }
        for(int i=0;i<adj.size();i++){
            for(int j=0;j<adj.get(i).size();j++){
                indegree.get(adj.get(i).get(j)).add(i);
            }
        }
        List<List<Integer>> ans = new ArrayList<>();
        for(int i=0;i<indegree.size();i++){
             List<Integer> inner = new ArrayList<>();
            dfs(indegree,i,inner);
            Collections.sort(inner);
            ans.add(inner);
        }
        return ans;
    }
}