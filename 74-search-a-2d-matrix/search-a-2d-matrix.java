class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int low=0;
        int high=(matrix.length*matrix[0].length)-1;
        while(high>=low){
            int mid=(high+low)/2;
            int _r=(mid/matrix[0].length);
            int _c=(mid%matrix[0].length);
            if(matrix[_r][_c]==target) return true;
            else if(matrix[_r][_c]>target){
                high=mid-1;
            }
            else{
                low=mid+1;
            }
        }
        return false;
    }
}