class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int i=0;
        int len=0;
        int sum=0;
        int min=Integer.MAX_VALUE;
        for(int j=0;j<cardPoints.length;j++){
            sum=sum+cardPoints[j];
            len++;
           if(len==cardPoints.length-k) min=Math.min(min,sum);
           while(i<cardPoints.length && len>cardPoints.length-k){
               sum=sum-cardPoints[i];
               len--;
               i++;
               
           }
           if(len==cardPoints.length-k) min=Math.min(min,sum);
          
          
        }
        int total = Arrays.stream(cardPoints).sum();
        return total-min;
    }
}