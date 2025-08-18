class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int leftsum=0;
        
        int rightsum=0;
        int max=0;
     for(int i=0;i<k;i++){
         leftsum=leftsum+cardPoints[i];
     }
     max=Math.max(max,leftsum);
     for(int i=0;i<k;i++){
        rightsum=rightsum+cardPoints[cardPoints.length-1-i];
        leftsum=leftsum-cardPoints[k-1-i];
        max=Math.max(leftsum+rightsum,max);
     }
     return max;
    }
}