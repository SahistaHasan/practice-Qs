class Solution {
    public int magicalString(int n) {
        StringBuilder sb = new StringBuilder();
        sb.append("122");
        int pos=2;
        int count=1;
        if(n==1 || n==2 || n==3) return 1;
        
        n=n-3;
        
        while(n>0){
             if(sb.charAt(pos)=='2' ){
                if(sb.charAt(sb.length()-1)=='2'){
                sb.append("11");
                if (n >= 2) {
                    count += 2;
                    n -= 2;
                } else { 
                    count += 1; 
                    n = 0;
                }
                }
                else{
                    sb.append("22");
                    n=n-2;
                }
             }
             else{
                if(sb.charAt(sb.length()-1)=='2'){
                sb.append("1");
                n=n-1;
                count++;
                }
                else{
                    sb.append("2");
                    n=n-1;
                }
             }
             pos++;
            
        }
        return count;
    }
}