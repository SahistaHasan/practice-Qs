class Solution {
    List<List<String>> list = new ArrayList<>();
    public boolean palindrome(String s, int start, int end){
       while(start <= end){
           if(s.charAt(start++) != s.charAt(end--)) return false;
        }
        return true;
    }
    public void recurse(String s, int index,List<String> inner){
      if(index==s.length()){
        list.add(new ArrayList<>(inner));
        return;
      }
      for(int i=index;i<s.length();i++){
             if(palindrome(s,index,i)){
                inner.add(s.substring(index,i+1));
                recurse(s,i+1,inner);
                inner.remove(inner.size()-1);

             }
      }
      return;
    }
    public List<List<String>> partition(String s) {
        List<String> inner = new ArrayList<>();
        recurse(s,0,inner);
        return list;
    }
}