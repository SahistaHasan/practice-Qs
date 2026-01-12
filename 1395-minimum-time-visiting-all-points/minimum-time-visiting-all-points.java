class Solution {
    public int minTimeToVisitAllPoints(int[][] points) {
        int time=0;
        for(int i=0;i<points.length-1;i++){
            int x = points[i][0];
            int y = points[i][1];
            int target_x = points[i+1][0];
            int target_y = points[i+1][1];
            while(x!=target_x || y!=target_y){
            if(x<target_x) x++;
            else if(x>target_x) x--;

            if(y<target_y) y++;
            else if(y>target_y) y--;
            time++;
            }
        }
        return time;
    }
}