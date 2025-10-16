class Solution {
    public List<Integer> partitionLabels(String s) {
        Map<Character,Integer> map = new HashMap<>();
        List<Integer> list = new ArrayList<>();
        for(int i=0;i<s.length();i++){
            map.put(s.charAt(i),i);
        }
        int start=0;
        int max=Integer.MIN_VALUE;
        for(int i=0;i<s.length();i++){
            max=Math.max(max,map.get(s.charAt(i)));
            if(map.get(s.charAt(i))==max && i==max){
                list.add(i-start+1);
                max=Integer.MIN_VALUE;
                start=i+1;
                continue;
            }
            
            
        }
return list;
    }
}