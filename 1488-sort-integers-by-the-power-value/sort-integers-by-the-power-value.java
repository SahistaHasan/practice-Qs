class Pair{
    int num;
    int val;
    Pair(int num, int val){
        this.num=num;
        this.val=val;
    }
}
class Solution {
    public int recurse(Map<Integer,Integer> map,int num){
        if(num==1){
          return 1;
        }
        if(!map.isEmpty() && map.containsKey(num)) return map.get(num);
        int ans;
        if(num%2!=0){
            ans=1+recurse(map,3*num+1);
        }
        else ans=1+recurse(map,num/2);
        map.put(num,ans);
        return ans;
    }
    public int getKth(int lo, int hi, int k) {
        Map<Integer,Integer> map = new HashMap<>();
        PriorityQueue<Pair> que = new PriorityQueue<>((a,b)->{
            if(a.val==b.val) return a.num-b.num;
            return a.val-b.val;
        });
        for(int i=lo;i<=hi;i++){
           que.offer(new Pair(i,recurse(map,i)));
        }
        while(k>1){
            que.poll();
            k--;
        }
        return que.peek().num;
    }
}