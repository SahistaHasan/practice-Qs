class Solution {
    List<List<Integer>> list = new ArrayList<>();
    public void recurse(int[] nums,int target,int index,List<Integer> inner){
        if(target==0){
            list.add(new ArrayList<>(inner));

            return;
        }
        if(index>nums.length-1 || target<0){
            return;
        }
        inner.add(nums[index]);
        recurse(nums,target-nums[index],index,inner);
        inner.remove(inner.size()-1);
       
        recurse(nums,target,index+1,inner);
        
        return;
    }
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
       List<Integer> list1 = new ArrayList<>();
         recurse(candidates,target,0,list1);
         return list;
    }
}