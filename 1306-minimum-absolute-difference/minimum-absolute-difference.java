class Solution {
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        Arrays.sort(arr);
        int diff=Integer.MAX_VALUE;
        for(int i=1;i<arr.length;i++){
           if(Math.abs(arr[i]-arr[i-1])<diff){
            diff=Math.abs(arr[i]-arr[i-1]);
           }
        }
        
        List<List<Integer>> list = new ArrayList<>();
        for(int i=1;i<arr.length;i++){
            if(Math.abs(arr[i]-arr[i-1])==diff){
                List<Integer> inner = new ArrayList<>();
                inner.add(arr[i-1]);
                inner.add(arr[i]);
                list.add(inner);
            }
        }
        return list;
    }
}