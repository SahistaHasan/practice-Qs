class Solution {
    public int removeDuplicates(int[] nums) {
        int i=0;
        int j=0;
        int p=0;
        int counttwos=0;
        
        while(j<nums.length){
            while(j<nums.length && nums[j]==nums[i] ){
                    j++;
                    counttwos++;
                   
                 }
                 if(counttwos>=2) {
                    nums[p]=nums[i];
                    nums[p+1]=nums[i];
                    p=p+2;
                 }
                 else{
                    nums[p]=nums[i];
                    p++;
                 }
                 i=j;
                 counttwos=0;
                 
            }
            return p;
          
        
    }
}