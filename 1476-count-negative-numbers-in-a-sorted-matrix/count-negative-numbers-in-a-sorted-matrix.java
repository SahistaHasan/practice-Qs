class Solution {
    public int countNegatives(int[][] grid) {
        
        int count=0;
        for(int i=0;i<grid[0].length;i++){
            int ans=-1;
            int high = grid.length-1;
            int low=0;
            if(grid[grid.length-1][i]>=0) continue;
        while(high>=low){
           int mid = (high+low)/2;
           if(grid[mid][i]>=0){
              low=mid+1;
           }
           else{
            ans=mid;
            high=mid-1;
           }
        }
        count=count+grid.length-ans;
    }
    return count;
    }
}