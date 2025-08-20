class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int el1=-1;
        int el2=-1;
        int count1=0;
        int count2=0;
        for(int i=0;i<nums.length;i++){
              if(count1==0 && el2!=nums[i]){
                el1=nums[i];
                count1=1;
              }
              else if(count2==0 && el1!=nums[i]){
                el2=nums[i];
                count2=1;
              }
              else if(nums[i]==el1){
                count1++;
              }
              else if(nums[i]==el2){
                count2++;
              }
              else{
                count1--;
                count2--;
              }
        }
        int testcount1=0;
        int testcount2=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==el1) testcount1++;
            else if(nums[i]==el2) testcount2++;
        }
        List<Integer> list = new ArrayList<>();
        if(testcount1>(nums.length)/3){
          list.add(el1);
        }
        if(testcount2>(nums.length)/3){
            list.add(el2);
        }
         
         return list;
    }
}