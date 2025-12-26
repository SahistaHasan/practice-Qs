class Solution {
    public int bestClosingTime(String customers) {
        int pre_N=0;
        int suf_Y=0;
        int minindex=0;
        
        for(int i=0;i<customers.length();i++){
              if(customers.charAt(i)=='Y'){
                suf_Y++;
              }
        }
        int min=suf_Y+pre_N;
        
        for(int i=0;i<customers.length();i++){
           
            if(customers.charAt(i)=='N'){
                pre_N++;
            }
            else {
                suf_Y--;
            }
            int penalty=pre_N+suf_Y;
            System.out.print(penalty);
            if(min>penalty){
                minindex=i+1;
                min=Math.min(min,penalty);
            }
            
            
        }
        return minindex;
    }
}