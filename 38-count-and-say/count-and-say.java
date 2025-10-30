class Solution {
    public String countAndSay(int n) {
        StringBuilder sb = new StringBuilder();
        for (int i=0;i<n;i++){
            StringBuilder in = new StringBuilder();
            if(i==0){
                in.append(1);
                sb.append(in);
                continue;
            }
            int j=0;
            while(j<sb.length()){
                char curr=sb.charAt(j);
                int count=0;
                while(j<sb.length() && curr==sb.charAt(j)){
                    count++;
                    j++;
                }
                in.append(count);
                in.append(curr);
                
            }
            sb.setLength(0);
             sb.append(in);
        }
        return sb.toString();
    }
}