class Solution {
    List<List<Integer>> list = new ArrayList<>();
    public void recurse(int[] candidates,int index,int target,List<Integer> inner){
        if(target<0) return;
        if(target==0) {
            list.add(new ArrayList<>(inner));
            return;
        }
        for(int i=index;i<candidates.length;i++){
            inner.add(candidates[i]);
            recurse(candidates,i,target-candidates[i],inner);
            inner.remove(inner.size()-1);
        }
        return;

    }
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<Integer> inner = new ArrayList<>();
        
            recurse(candidates,0,target,inner);
        
        return list;
    }
}