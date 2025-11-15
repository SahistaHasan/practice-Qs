class Solution {
    public int[] shortestToChar(String s, char c) {
        int [] prefix = new int [s.length()];
        int [] suffix = new int [s.length()];
        int [] ans = new int [s.length()];
        int pre=Integer.MAX_VALUE;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)==c){
                pre=i;
            }
            if(pre==Integer.MAX_VALUE){
                prefix[i]=pre;
            }
            else prefix[i]=i-pre+1;
            
        }
        int suff=Integer.MAX_VALUE;
        for(int i=s.length()-1;i>=0;i--){
            if(s.charAt(i)==c){
                suff=i;
            }
            if(suff==Integer.MAX_VALUE){
                suffix[i]=suff;
            }
            else {
                suffix[i]=suff-i+1;
            }
        }
        for(int i=0;i<s.length();i++){
            ans[i]=Math.min(prefix[i],suffix[i])-1;
        }
        return ans;
    }
}