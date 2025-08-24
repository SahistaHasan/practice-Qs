class Solution {
    List<List<Integer>> list = new ArrayList<>();
    public void recurse(int n, int index, int k,List<Integer> inner){
       
       if(inner.size()==k) {
        list.add(new ArrayList<>(inner));
        return;
       }
       if(index>n) return;
       inner.add(index);
       recurse(n,index+1,k,inner);
       inner.remove(inner.size()-1);
       recurse(n,index+1,k,inner);
       return;
    }
    public List<List<Integer>> combine(int n, int k) {
        List<Integer> inner = new ArrayList<>();
        recurse(n,1,k,inner);
        return list;
    }
}