class Solution {
    public int numberOfPairs(int[][] points) {
        Arrays.sort(points,(point1,point2)->{
            if(point1[0]!=point2[0]) return point1[0]-point2[0];
            return point2[1]-point1[1];
        });
        int count=0;
        boolean found=false;
        for(int i=0;i<points.length;i++){
            for(int j=i+1;j<points.length;j++){
                if(points[i][0]<=points[j][0] && points[j][1]<=points[i][1]){
                    found=false;
                      for(int p= 0; p < points.length; p++) {
                        if (p == i || p == j) continue;
                        if(points[p][0]<=points[j][0] && points[p][0]>=points[i][0] && points[p][1]<=points[i][1] && points[p][1]>=points[j][1]){
                           found=true;
                           break;
                        }
                        
                    }
                    if(found==false) count++;
                }
            }
        }
        return count;
    }
}