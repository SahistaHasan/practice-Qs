class Solution {
    public int findJudge(int n, int[][] trust) {
        int sum=0;
       Map<Integer,Integer> map = new HashMap<>();
       Map<Integer,Integer> map2 = new HashMap<>();
       for(int i=0;i<trust.length;i++){
        map.put(trust[i][0],map.getOrDefault(trust[i][0],0)+1);
        map2.put(trust[i][1],map2.getOrDefault(trust[i][1],0)+1);
       } 
       for(Map.Entry<Integer,Integer> e:map.entrySet()){
        sum=sum+e.getKey();
       }
      int candidate = (n*(n+1))/2 - sum;
        if(!map.containsKey(candidate) && map2.getOrDefault(candidate,0) == n-1){
            return candidate;
        }
       return -1;
    }
}