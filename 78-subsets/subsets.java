class Solution {
    List<List<Integer>> list = new ArrayList<>();
    public void recurse(int index,int[] nums,List<Integer> inner){
        if(index==nums.length){
           
            list.add(new ArrayList<>(inner));
            return;
        }
        inner.add(nums[index]);
        recurse(index+1,nums,inner);
        inner.remove(inner.size()-1);
        recurse(index+1,nums,inner);
        return;
    }
    public List<List<Integer>> subsets(int[] nums) {
        List<Integer> inner = new ArrayList<>();
        recurse(0,nums,inner);
        return list;
    }
}