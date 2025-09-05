class Solution {
    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points,(a,b)->{
            return a[1]-b[1];
        });
        int count=1;
        int limit=points[0][1];
        
        for(int i=1;i<points.length;i++){
            if(limit >=points[i][0] && limit<=points[i][1] ){
                continue;
            }
            
            else{

                limit=points[i][1];
                count++;
            }
            
            
        }
        return count;
    }
}