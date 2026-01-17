class Solution {
     Set<String> set = new HashSet<>();
      Map<String,Integer> memo = new HashMap<>();
    public int solve(String s){
      if(memo.containsKey(s)) return memo.get(s);
      int res=1;
      for(int i=0;i<s.length();i++){
        String s1 = s.substring(0,i)+s.substring(i+1,s.length());
        if(set.contains(s1)){
           res=Math.max(res,1+solve(s1));
        }
      }
      memo.put(s,res);
      return res;
    }
    public int longestStrChain(String[] words) {
        for(int i=0;i<words.length;i++){
           set.add(words[i]);
        }
        int max=Integer.MIN_VALUE;
        for(int i=0;i<words.length;i++){
            max=Math.max(max,solve(words[i]));
        }
        return max;
    }
}