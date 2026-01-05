class DisjointSet{
    List<Integer> rank = new ArrayList<>();
    List<Integer> parent = new ArrayList<>();
      public DisjointSet(int n){
        for(int i=0;i<=n;i++){
            rank.add(0);
            parent.add(i);
        }
      }
      public int findUPar(int node){
        if(node==parent.get(node)){
            return node;
        }
        int ulp = findUPar(parent.get(node));
        parent.set(node,ulp);
        return ulp;
      }
      public void DisjointUnion(int u, int v){
        int upar=findUPar(u);
        int vpar=findUPar(v);
        if(upar==vpar) return;
        if(rank.get(upar)>rank.get(vpar)){
            parent.set(vpar,upar);
        }
        else if (rank.get(upar)<rank.get(vpar)){
            parent.set(upar,vpar);
        }
        else{
            parent.set(upar,vpar);
            rank.set(vpar,rank.get(vpar)+1);
        }
      }
}
class Solution {
    public int removeStones(int[][] stones) {
       int maxCol=0;
       int maxRow=0;
       for(int i=0;i<stones.length;i++){
        maxRow=Math.max(maxRow,stones[i][0]);
        maxCol=Math.max(maxCol,stones[i][1]);
       } 
      DisjointSet ds = new DisjointSet(maxRow+maxCol+2);
      HashMap<Integer,Integer> map = new HashMap<>();
      for(int i=0;i<stones.length;i++){
        int nodeRow=stones[i][0];
        int nodeCol = stones[i][1]+maxRow+1;
        ds.DisjointUnion(nodeRow,nodeCol);
        map.put(nodeCol,0);
        map.put(nodeRow,0);

      }
      int count=0;
      for(Map.Entry<Integer,Integer> e:map.entrySet()){
           if(ds.findUPar(e.getKey())==e.getKey()){
            count++;
           }
         
      }
        return stones.length-count;
    }
}