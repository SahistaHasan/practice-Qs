class Solution {
    public int removeCoveredIntervals(int[][] intervals) {
        int prev=0;
        Arrays.sort(intervals,(a,b)->{
            if(a[0]==b[0]) return b[1]-a[1];
            return a[0]-b[0];
        });
        int count=0;;
        for(int i=1;i<intervals.length;i++){
            if(intervals[i][0]==intervals[prev][0]) {
               if(intervals[i][1]<=intervals[prev][1]){
                count++;
               }
            }
            else if(intervals[i][1]<=intervals[prev][1]){
                count++;
                continue;
            }
            else prev=i;
           
        }
        return intervals.length-count;
    }
}