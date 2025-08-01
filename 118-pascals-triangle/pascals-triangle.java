class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> list = new ArrayList<>();
        int rows=1;
        List<Integer> one=new ArrayList<>();
        one.add(1);
        list.add(one);
        rows++;
        while(rows<=numRows){
            int iter=rows-2;
            List<Integer> inner=new ArrayList<>();
            inner.add(1);
            
            for(int i=0;i<iter;i++){
                int j=i+1;
                inner.add(list.get(iter).get(i)+list.get(iter).get(j));
               

            }
            inner.add(1);
            list.add(inner);
            rows++;

        }
        return list;
    }
}