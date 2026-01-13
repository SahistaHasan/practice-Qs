class Solution {
    public int minimumRounds(int[] tasks) {
       Map<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<tasks.length;i++){
          map.put(tasks[i],map.getOrDefault(tasks[i],0)+1);
        }
        int count=0;
        for(Map.Entry<Integer,Integer> e: map.entrySet()){
            if(e.getValue()==1) return -1;
            else if(e.getValue()==2) count++;
            else if(e.getValue()%3==0) count=count+e.getValue()/3;
            else if(e.getValue()%3==1) {
                  int threes=(e.getValue()/3)-1;
                  count=count+threes+(e.getValue()-threes*3)/2;
            }
            else{
                count=count+(e.getValue()/3)+1;
            }
        }
        return count;
    }
}