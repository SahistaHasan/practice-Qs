class Solution {
    Set<List<Integer>> list = new HashSet<>();
    public void recurse(int [] nums, int index, List<Integer> inner){
        if(index>=nums.length){
            if(inner.size()>=2){
                list.add(new ArrayList(inner));
                return;
            }
            else return;
        }
        inner.add(nums[index]);
        int j=index+1;
        for( j=index+1;j<nums.length;j++){
            if(nums[j]>=nums[index]){
                break;
            }
        }
        recurse(nums,j,inner);
        inner.remove(inner.size()-1);
        int i=index+1;
        for(i=index+1;i<nums.length;i++){
            if(inner.size()==0) break;
            if(nums[i]!=nums[index] && nums[i]>=inner.get(inner.size()-1)){
                break;
            }
        }
        recurse(nums,i,inner);
        return ;

    }
    public List<List<Integer>> findSubsequences(int[] nums) {
        List<Integer> inner = new ArrayList<>();
        recurse(nums,0,inner);
        return new ArrayList<>(list);

    }
}