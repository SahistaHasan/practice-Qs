class Solution {
    public int[] productQueries(int n, int[][] queries) {
        int MOD = 1_000_000_007;
        StringBuilder sb = new StringBuilder();
       while(n!=0){
        int rem=n%2;
           sb.append(rem);
          n=n/2;
          
       } 
       String str=sb.toString();
       List<Double> list=new ArrayList<>();
       for(int i=0;i<str.length();i++){
        if(str.charAt(i)=='1'){
       double sum= Math.pow(2,i);
          list.add(sum);
        }
       }
       int [] res= new int[queries.length];
       for(int i=0;i<queries.length;i++){
           res[i]=1;
           for(int j=queries[i][0];j<=queries[i][queries[i].length-1];j++){
              res[i] = (int)((res[i] * list.get(j)) % MOD);
           }
       }
       return res;
    }
}