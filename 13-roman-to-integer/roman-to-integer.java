class Solution {
    public int romanToInt(String s) {
        Map<Character,Integer> map = new HashMap<>();
       map.put('I',1);
       map.put('V',5);
       map.put('X',10);
       map.put('L',50);
       map.put('C',100);
       map.put('D',500);
       map.put('M',1000);
       int res=0;
       int i=0;
       if(s.length()==1) return map.get(s.charAt(0));
      while(i<s.length()-1){
        if(map.get(s.charAt(i))<map.get(s.charAt(i+1))){
            res=res+(map.get(s.charAt(i+1))-map.get(s.charAt(i)));
            i=i+2;
            if(i==s.length()-1){
                res=res+map.get(s.charAt(i));
                return res;
            }
        }
        else{
            if(i==s.length()-2){
                res=res+map.get(s.charAt(i))+map.get(s.charAt(i+1));
                return res;
            }
           else{res=res+(map.get(s.charAt(i)));
           i++;
           }
        }
       }
       return res;
    }
}