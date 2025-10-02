class Solution {
    public boolean recurse(int i, int j, String s,Boolean[][] memo){
       if(i>=j) return true;
       if(memo[i][j]!=null) return memo[i][j];
       if(s.charAt(i)!=s.charAt(j)) return memo[i][j]=false;
       return memo[i][j]=recurse(i+1,j-1,s,memo);
    }
    public String longestPalindrome(String s) {
        int start=0;
        int end=0;
        int maxlen=0;
        Boolean [][] memo=new Boolean[s.length()][s.length()];
        for(int i=0;i<s.length();i++){
            for(int j=i;j<s.length();j++){
                if(recurse(i,j,s,memo)){
                    if(j-i+1>maxlen){
                         maxlen=j-i+1;
                         start=i;
                         end=j;
                    }
                }
            }
        }
        return s.substring(start,end+1);
    }
}