class Solution {
    public int[][] merge(int[][] intervals) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(intervals,(a,b)->{
            if(a[0]==b[0]) return a[1]-b[1];
            return a[0]-b[0];
        });
        int start=intervals[0][0];
        int end=intervals[0][1];
        for(int j=1;j<intervals.length;j++){
           if(intervals[j][0]<=end){
            end=Math.max(end,intervals[j][1]);
            start=Math.min(start,intervals[j][0]);
           }
           else{
            List<Integer> inner = new ArrayList<>();
            inner.add(start);
            inner.add(end);
            list.add(inner);
            start=intervals[j][0];
            end=intervals[j][1];
           }
        }
        List<Integer> inner = new ArrayList<>();
        inner.add(start);
        inner.add(end);
        list.add(inner);

 int[][] result = new int[list.size()][list.get(0).size()];
         for (int i = 0; i < list.size(); i++) {
            List<Integer> row = list.get(i);
            for (int j = 0; j < list.get(0).size(); j++) {
                result[i][j] = row.get(j);
            }
        }
return result;
    }
}