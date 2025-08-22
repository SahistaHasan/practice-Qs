class Solution {
    public int minimumArea(int[][] grid) {
        int left = grid[0].length-1;
        boolean found = false;
        for(int j=0;j<grid[0].length;j++){
            for(int i=0;i<grid.length;i++){
                if(grid[i][j]==1) {
                    left=j;
                    found=true;
                    break;
                }
            }
            if(found==true) break;
        }
        found=false;
        int right=0;
        for(int j=grid[0].length-1;j>=0;j--){
            for(int i=0;i<grid.length;i++){
                if(grid[i][j]==1) {
                    right=j;
                    found=true;
                    break;
                }
            }
            if(found==true) break;
        }
        found=false;
        int top=grid.length-1;
         for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==1) {
                    top=i;
                    found=true;
                    break;
                }
            }
            if(found) break;
        }
        found=false;
         int bottom =0;
        for(int i=grid.length-1;i>=0;i--){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==1) {
                    bottom=i;
                    found=true;
                    break;
                }
            }
            if(found) break;
        }
        return (right-left+1)*(bottom-top+1);
        
    }
}