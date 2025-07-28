class Solution {
   int count=0;
    public void subsets(int[]nums, int index,int max,int res){
        if(index==nums.length){
            
            if(res==max){
                count++;
                
            }
            return;
    }
    int curr=res;
    res=res|nums[index];
    subsets(nums,index+1,max,res);
    
    subsets(nums,index+1,max,curr);
    return;

    }
    public int countMaxOrSubsets(int[] nums) {
        int max=0;
        for(int i=0;i<nums.length;i++){
            max=max|nums[i];
        }
        subsets(nums,0,max,0);
        return count;
    }
}