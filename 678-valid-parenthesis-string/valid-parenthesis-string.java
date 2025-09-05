class Solution {
    Map<String,Boolean> map = new HashMap<>();
    public boolean recurse( int index,int close,int open,String s){
        if(close>open) return false;
        if(index>=s.length()){
            if(open==close) return true;
            else return false;
        }
        boolean res=true;
         String sb = index + "," + open + "," + close;
        if(map.containsKey(sb)) return map.get(sb);
        if(s.charAt(index)=='('){
            
            open++;
          res=  recurse(index+1,close,open,s);
        }
        else if(s.charAt(index)==')'){
            
            close++;
           res= recurse(index+1,close,open,s);
        }
        else{
            
         boolean op=  recurse(index+1,close,open+1,s);
            
         boolean  cl= recurse(index+1,close+1,open,s);
            
          boolean none= recurse(index+1,close,open,s);
            res=op||cl||none;
            
            
        }
        map.put(sb,res);
        return res;
    }
    public boolean checkValidString(String s) {
         
        return recurse(0,0,0,s);
    }
}