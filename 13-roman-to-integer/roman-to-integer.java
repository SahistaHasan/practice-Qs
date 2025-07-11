class Solution {
    

        
    public int romanToInt(String s) {

        
       int res=0;
       int i=0;
       if(s.length()==1) return map(s.charAt(0));
      while(i<s.length()-1){
        if(map(s.charAt(i))<map(s.charAt(i+1))){
            res=res+(map(s.charAt(i+1))-map(s.charAt(i)));
            i=i+2;
            if(i==s.length()-1){
                res=res+map(s.charAt(i));
                return res;
            }
        }
        else{
            if(i==s.length()-2){
                res=res+map(s.charAt(i))+map(s.charAt(i+1));
                return res;
            }
           else{res=res+(map(s.charAt(i)));
           i++;
           }
        }
       }
       return res;
    }

     public int map(char ch) {
        if (ch == 'I') {
            return 1;
        } else if (ch == 'V') {
            return 5;
        } else if (ch == 'X') {
            return 10;
        } else if (ch == 'L') {
            return 50;
        } else if (ch == 'C') {
            return 100;
        } else if (ch == 'D') {
            return 500;
        } else if (ch == 'M') {
            return 1000;
        } else {
            return 0;
        }
}
}