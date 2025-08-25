class Solution {
     List<String> list = new ArrayList<>();
    public void recurse(String digits, Map<Character,String> map,int index,StringBuilder sb){
      if(index>=digits.length()){
       list.add(sb.toString());
       return;
      }
      for(int i=0;i<map.get(digits.charAt(index)).length();i++){
      sb.append(map.get(digits.charAt(index)).charAt(i));
      recurse(digits,map,index+1,sb);
      sb.deleteCharAt(sb.length()-1);
      }
      return;
    }
    public List<String> letterCombinations(String digits) {
        if(digits.length()==0 || digits==null) {
        return list;
        };
       
        Map<Character,String> map = new HashMap<>();
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");
        StringBuilder sb = new StringBuilder();
        recurse(digits,map,0,sb);
        return list;
    }
}