class Solution {
    List<String> list = new ArrayList<>();
    StringBuilder sb = new StringBuilder();
    
    public void recurse(int index,int n){
        if(index>=n){
         String str = sb.toString();
         list.add(str);
         return;
        }
        
        if(index!=0 && sb.charAt(index-1)=='0'){
            sb.append('1');
            recurse(index+1,n);
            sb.deleteCharAt(sb.length()-1);
        }
        else{
            sb.append('1');
            recurse(index+1,n);
            sb.deleteCharAt(sb.length() - 1);
            sb.append('0');
            recurse(index+1,n);
            sb.deleteCharAt(sb.length()-1);

        }
        return;
    }
    public List<String> validStrings(int n) {
        recurse(0,n);
        return list;
    }
}