class Solution {
    public int num(int sum,int [] nums){
        int total=0;
        int count=1;
        for(int i=0;i<nums.length;i++){
           if(total+nums[i]<=sum){
            total=total+nums[i];
            continue;
           }
           else{
            count++;
            total=nums[i];
           }
       
        }
            return count;
    }
    public int splitArray(int[] nums, int k) {
        int high=0;
        int low=-1;
        for(int i=0;i<nums.length;i++){
            high=high+nums[i];
            low=Math.max(low,nums[i]);
        }
        int ans=0;
        while(high>=low){
            int mid=(high+low)/2;
            int count=num(mid,nums);
            if(count<=k){
                high=mid-1;
                ans=mid;
            }
            else low=mid+1;
        }
        return ans;
        
    }
}