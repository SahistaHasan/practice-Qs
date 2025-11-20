class Solution {
    public int removeDuplicates(int[] nums) {
        int i=0;
        int j=0;
        while(i<nums.length && j<nums.length){
            int k=0;
            int no = nums[j];
            while(j<nums.length && nums[j]==no){
                j++;
                k++;
                if(k<=2){
                    nums[i]=no;
                    i++;
                }
            }
            
            
            

        }
        return i;
    }
}