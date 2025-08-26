class Solution {
    public int areaOfMaxDiagonal(int[][] dimensions) {
        int maxarea=0;
        
        int maxdiagonal =0;
        for(int i=0;i<dimensions.length;i++){
            int diagonal=(dimensions[i][0]*dimensions[i][0] + dimensions[i][1]*dimensions[i][1]);
            int area = dimensions[i][0]*dimensions[i][1];
            if(diagonal>maxdiagonal){
                maxarea=area;
            }
            else if(diagonal==maxdiagonal){
                maxarea=Math.max(area,maxarea);
            }
            
            maxdiagonal=Math.max(diagonal,maxdiagonal);
           
            
            
        }
        return maxarea;
        
    }
}