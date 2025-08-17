class Solution {
    public int numberOfSubstrings(String s) {
        Map<Character,Integer> map = new HashMap<>();
        int i=0;
        int count=0;
        for(int j=0;j<s.length();j++){
            map.put(s.charAt(j),map.getOrDefault(s.charAt(j),0)+1);
            if(!map.isEmpty() && map.getOrDefault('a',0)>=1 && map.getOrDefault('b',0)>=1 && map.getOrDefault('c',0)>=1){
                
                while(map.getOrDefault('a',0)!=0 && map.getOrDefault('b',0)!=0 && map.getOrDefault('c',0)!=0){
                    map.put(s.charAt(i),map.get(s.charAt(i))-1);
                    count=count+s.length()-j;
                  i++;
                }

            }
            

        }
        return count;
    }
}