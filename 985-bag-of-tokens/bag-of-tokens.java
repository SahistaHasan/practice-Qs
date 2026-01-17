class Solution {
    public int bagOfTokensScore(int[] tokens, int power) {
      int i=0;
      int j = tokens.length-1;
      int score=0;
      int max=0;
      Arrays.sort(tokens);
      while(i<=j){
        if(score==0){
            if(power-tokens[i]>=0){
                power=power-tokens[i];
                score++;
                i++;
                max=Math.max(score,max);
            }
            else{
                return max;
            }
           
        }
        else{
            if(power-tokens[i]>=0){
                score++;
                 power=power-tokens[i];
                max=Math.max(score,max);
                i++;
               
            }
            else{
                power=power+tokens[j];
                score--;
                j--;
            }
        }
      }
      return max;  
    }
}