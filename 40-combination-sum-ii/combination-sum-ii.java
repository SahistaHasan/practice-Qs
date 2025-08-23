class Solution {
     List<List<Integer>> list = new ArrayList<>();
    public void recurse(int[] candidates,int index,int target,List<Integer> inner){
        if(target==0) {
            list.add(new ArrayList<>(inner));
            return;
        }
        if(target<0 || index>=candidates.length) return;
        if(target==0) {
            list.add(new ArrayList<>(inner));
            return;
        }
            inner.add(candidates[index]);
            recurse(candidates,index+1,target-candidates[index],inner);
            inner.remove(inner.size()-1);

            int next=index+1;
        while(next<candidates.length && candidates[next]==candidates[index]) {
            next++; 
        }
            recurse(candidates,next,target,inner);
        
        return;

    }
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<Integer> inner = new ArrayList<>();
            Arrays.sort(candidates);
            recurse(candidates,0,target,inner);
        
        return list;
    }
}