class Solution {
    public boolean sorted(List<Integer> list){
        if(list.size()==1) return true;
       for(int i=1;i<list.size();i++){
        if(list.get(i)<list.get(i-1)){
            return false;
        }
       }
       return true;
    }
    public int minimumPairRemoval(int[] nums) {
        List<Integer> list = new ArrayList<>();
        for(int i=0;i<nums.length;i++){
            list.add(nums[i]);
        }
        int ops=0;
        boolean sort = sorted(list);
        int minsum=Integer.MAX_VALUE;
        while(!sort){
            minsum=Integer.MAX_VALUE;
            int minj=1;
            int mini=0;
            int j=1;
            for(int i=0;i<list.size()-1;i++){
                if(minsum>list.get(i)+list.get(j)){
                    minsum=list.get(i)+list.get(j);
                    mini=i;
                    minj=j;
                }
                j++;
        }
        list.set(mini,list.get(mini)+list.get(minj));
        ops++;
        list.remove(minj);
        sort=sorted(list);
        }
       return ops;
    }
}