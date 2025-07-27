class Solution {
    public int countHillValley(int[] nums) {
        int [][] arr= new int[nums.length][2];
        int left=-1;
        arr[0][0]=-1;
        arr[0][1]=-1;
        arr[nums.length-1][0]=-1;
        arr[nums.length-1][1]=-1;
        for(int i=1;i<nums.length-1;i++){
          if(nums[i]!=nums[i-1]){
            arr[i][0]=nums[i-1];
            left=nums[i-1];
          }
          else{
            arr[i][0]=left;
          }
        }
        int right=-1;
        for(int i=nums.length-2;i>0;i--){
            if(nums[i]!=nums[i+1]){
                arr[i][1]=nums[i+1];
                right=nums[i+1];
            }
            else{
                arr[i][1]=right;
                
            }
        }
int count=0;
        for(int i=1;i<nums.length-1;i++){
            if(arr[i][0]<nums[i] && arr[i][1]<nums[i] && arr[i][0]!=-1 && arr[i][1]!=-1){
                if(arr[i-1][0]!=arr[i][0] && arr[i-1][1]!=arr[i][1]){
                   count++;
                }
            }
            else if(arr[i][0]>nums[i] && arr[i][1]>nums[i] && arr[i][0]!=-1 && arr[i][1]!=-1){
                if(arr[i-1][0]!=arr[i][0] && arr[i-1][1]!=arr[i][1]){
                   count++;
                }
                
            }
        }
        return count;
    }
}