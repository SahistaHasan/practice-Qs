class Solution {
    public String largestGoodInteger(String num) {
        int j=0;
        StringBuilder sb = new StringBuilder();
        int i=1;
        String maxStr="";
       
        while(i<num.length()){
            while(i<num.length() && num.charAt(j)==num.charAt(i)){
                i++;
                
            }
        if(i-j>=3){
            sb.append(num.charAt(j));
            sb.append(num.charAt(j));
            sb.append(num.charAt(j));
            
            String current = sb.toString();
                if (maxStr.equals("") || current.compareTo(maxStr) > 0) {
                    maxStr = current;  // update max
                }
        }
        
            i++;
            j=i-1;
            sb.setLength(0);
        
        }
        return maxStr;
    }
}