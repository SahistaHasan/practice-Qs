class Solution {
    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        int i=0;
        int j=0;
        List<int []> list=new ArrayList<>();
        while(i!=firstList.length && j!=secondList.length){
            if (firstList[i][1] >= secondList[j][0] && secondList[j][1] >= firstList[i][0]) {
                int[] arr = new int[] {
                    Math.max(firstList[i][0], secondList[j][0]),
                    Math.min(firstList[i][1], secondList[j][1])
                };
                list.add(arr);
            }
            if (firstList[i][1] < secondList[j][1]) {
                i++;
            } else {
                j++;
            }
        
          
        }
          int[][] arr = list.toArray(new int[list.size()][]);
          return arr;
    }
}