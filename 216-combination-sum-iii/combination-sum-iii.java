class Solution {
     List<List<Integer>> list=new ArrayList<>();
    public void recurse(int k, int sum,int index, int n, List<Integer> inner){
        

        if(inner.size()==k && sum==n){
            list.add(new ArrayList<>(inner));
            return;
        }
         if(sum>n || index>9 || inner.size()>=k) return;
        
       
        //pick
        inner.add(index);
        sum=sum+index;
        recurse(k,sum,index+1,n,inner);
        //backtrack
        inner.remove(inner.size()-1);
        sum=sum-index;
        //not pick
        recurse(k,sum,index+1,n,inner);

        return;
    }
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<Integer> inner = new ArrayList<>();
       recurse(k,0,1,n,inner);
       return list;
    }
}