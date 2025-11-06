class Solution {
    List<String> list = new ArrayList<>();
    public void recurse(String s, int index,StringBuilder sb){
        if(index>=s.length()){
            list.add(sb.toString());
            return;
        }
        if(s.charAt(index)>='0' && s.charAt(index)<='9'){
          sb.append(s.charAt(index));
          recurse(s,index+1,sb);
          sb.deleteCharAt(sb.length()-1);
        }
        else {
            sb.append(s.charAt(index));
            recurse(s,index+1,sb);
            sb.deleteCharAt(sb.length()-1);
             if (Character.isLowerCase(s.charAt(index))) {
            sb.append(Character.toUpperCase(s.charAt(index)));
           } else {
            sb.append(Character.toLowerCase(s.charAt(index)));
          }
          recurse(s,index+1,sb);
          sb.deleteCharAt(sb.length()-1);

        }
        return;
    }
    public List<String> letterCasePermutation(String s) {
        StringBuilder sb = new StringBuilder();
        recurse(s,0,sb);
        return list;
    }
}