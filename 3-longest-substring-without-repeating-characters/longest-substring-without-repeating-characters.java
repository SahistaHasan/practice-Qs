

class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        int i=0;
        int len=0;
        int count=0;
       for(int j=0;j<s.length();j++){
    
           map.put(s.charAt(j),map.getOrDefault(s.charAt(j),0)+1);
           count++; 
           if(!map.containsValue(2)){
            len=Math.max(len,count);
           }


           while(map.containsValue(2)){
            if(map.get(s.charAt(i))>1){
                map.put(s.charAt(i),map.get(s.charAt(i))-1);
                i++;
                count--;
            }
            else{
                map.remove(s.charAt(i));
                i++;
                count--;
            }
            
           } 
           
           
              
            }
            return len;
    }
}
