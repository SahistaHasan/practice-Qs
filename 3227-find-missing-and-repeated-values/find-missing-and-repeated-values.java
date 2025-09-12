class Solution {
    public int[] findMissingAndRepeatedValues(int[][] grid) {
        int sum=0;
        int repeated=0;
        Map <Integer,Integer> map = new HashMap<>();
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                sum=sum+grid[i][j];
                map.put(grid[i][j],map.getOrDefault(grid[i][j],0)+1);
                if(map.get(grid[i][j])>1){
                    repeated=grid[i][j];
                }
            }
        }
        int [] arr = new int[2];
        arr[0]=repeated;
        int n=grid[0].length*grid[0].length;
        arr[1]=((n)*(n+1))/2 -(sum-repeated);
        return arr;
    }
}