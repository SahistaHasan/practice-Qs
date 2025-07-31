class Solution {
    int sum=0;
    public void subsets(int[] nums,int index ,int res){
      if(index==nums.length){
        sum=sum+res;
        return;
      }
      subsets(nums,index+1,res^nums[index]);
      subsets(nums,index+1,res);
      return;

      
    }
    public int subsetXORSum(int[] nums) {
        subsets(nums,0,0);
        return sum;
    }
}