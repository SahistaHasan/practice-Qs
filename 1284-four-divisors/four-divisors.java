class Solution {
    public int sumFourDivisors(int[] nums) {
        int sum=0;
        for(int i=0;i<nums.length;i++){
            int count=2;
            int innersum=1+nums[i];
            for(int j=2;j<=Math.sqrt(nums[i]);j++){
                if(nums[i]%j==0) {
                    int other=nums[i]/j;
                    if(other==j){
                        count++;
                        innersum=innersum+j;
                    }
                    else{
                        count=count+2;
                        innersum=innersum+j+nums[i]/j;
                    }
                }
            }
            if(count==4) sum=innersum+sum;
        }
        return sum;
    }
}