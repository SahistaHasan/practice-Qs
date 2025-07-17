class Solution {
    List<String> list = new ArrayList<>();
    public void all(int n ,StringBuilder  sb,int open,int close){
       if(sb.length()==2*n){
           list.add(sb.toString());
           return;
       }
       if(open!=0){
        all(n,sb.append("("),open-1,close);
          sb.deleteCharAt(sb.length() - 1);
       }
       if(close>open){
            all(n,sb.append(")"),open,close-1);
             sb.deleteCharAt(sb.length() - 1);
        }
        return ;
       
    }
    public List<String> generateParenthesis(int n) {
        int open=n;
        int close=n;
        StringBuilder sb = new StringBuilder();
          all(n,sb,open,close);
          return list;
    }
}