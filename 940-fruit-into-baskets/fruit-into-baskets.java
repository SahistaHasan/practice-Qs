class Solution {
    public int totalFruit(int[] fruits) {
        Map<Integer,Integer> map = new HashMap<>();
        int i=0;
        int len=0;
        int max=0;
        for(int j=0;j<fruits.length;j++){
            map.put(fruits[j],map.getOrDefault(fruits[j],0)+1);
            while(map.size()>2){
                if(map.get(fruits[i])>1){
                map.put(fruits[i],map.get(fruits[i])-1);
                }
                else{
                    map.remove(fruits[i]);
                }
                i++;
                
            }
            len=j-i+1;
            max=Math.max(max,len);
        }
        return max;
    }
}