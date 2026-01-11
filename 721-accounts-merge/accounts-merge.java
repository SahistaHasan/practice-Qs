class DisjointSet{
    List<Integer> parent = new ArrayList<>();
    List<Integer> rank = new ArrayList<>();
    public DisjointSet(int n){
        for(int i=0;i<=n;i++){
            rank.add(0);
            parent.add(i);
        }
    }
    public int findUPar(int node){
        if(parent.get(node)==node) return node;
        int ulp = findUPar(parent.get(node));
        parent.set(node,ulp);
        return ulp;
    }
    public void Union(int u, int v){
      int ul_u = findUPar(u);
       int ul_v = findUPar(v);
       if(ul_u==ul_v) return;
       if(rank.get(ul_u)>rank.get(ul_v)){
        parent.set(ul_v,ul_u);

       }
       else if(rank.get(ul_v)>rank.get(ul_u)){
        parent.set(ul_u,ul_v);
       }
       else{
        parent.set(ul_u,ul_v);
        rank.set(ul_v,rank.get(ul_v)+1);
       }
       
    }
}
class Solution {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        Map<String ,Integer> map = new HashMap<>();
        DisjointSet ds = new DisjointSet(accounts.size());
        for(int i=0;i<accounts.size();i++){
            for(int j=1;j<accounts.get(i).size();j++){
                if(!map.containsKey(accounts.get(i).get(j))){
                    map.put(accounts.get(i).get(j),i);
                }
                else{
                    ds.Union(i,map.get(accounts.get(i).get(j)));
                }
            }
        }
        List<List<String>> list = new ArrayList<>();
        for(int i=0;i<accounts.size();i++){
            List<String> inner = new ArrayList<>();
            list.add(inner);
        }
        for( Map.Entry<String,Integer> e: map.entrySet()){
            list.get(ds.findUPar(e.getValue())).add(e.getKey());
        }
        List<List<String>> ans = new ArrayList<>();
        for(int i=0;i<list.size();i++){
            if(list.get(i).size()==0) continue;
            Collections.sort(list.get(i));
            List<String> inn = new ArrayList<>();
            inn.add(accounts.get(i).get(0));
            for(int j=0;j<list.get(i).size();j++){
                inn.add(list.get(i).get(j));
            }
            ans.add(new ArrayList<>(inn));
        }
        return ans;
    }
}