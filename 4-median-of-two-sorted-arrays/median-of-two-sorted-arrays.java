class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
      //using merge sort logic
      int ind1 = (nums1.length+nums2.length)/2;
      int ind2 =(nums1.length+nums2.length)/2 -1;
      int count=0;
      int i=0;
      int j=0;
      int elem1=-1;
      int elem2=-1;
      while(i<=nums1.length-1 && j<=nums2.length-1){
        if(nums1[i]<nums2[j]){
           
           
            if(count==ind1){
                 elem1=nums1[i];}
            else if(count==ind2) {
                elem2 = nums1[i];}
            i++;
             count++;
        }
        else if(nums2[j]<=nums1[i]){
         
        
            if(count==ind1) {
                 elem1=nums2[j];}
           else if(count==ind2){
                  elem2 = nums2[j];}
            j++;
            count++;
        }

      }  
      while(i<=nums1.length-1){
        
         if(count==ind1) {
             elem1=nums1[i];}
           else if(count==ind2) {
                 elem2 = nums1[i];}
            i++;
            count++;
        
      }
      while(j<=nums2.length-1){
         if(count==ind1) {
             elem1=nums2[j];}
           else if(count==ind2){
                  elem2 = nums2[j];}
            j++;
            count++;
      }

      if ((nums1.length+nums2.length)%2!=0){
        return elem1;
      }
      else{
        return ((double)elem2+elem1)/2;
      }
    }
}