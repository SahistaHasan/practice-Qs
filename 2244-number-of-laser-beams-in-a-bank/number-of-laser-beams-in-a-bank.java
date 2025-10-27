class Solution {
    public int numberOfBeams(String[] bank) {
        List<Integer> list = new ArrayList<>();
        for(int i=0;i<bank.length;i++){
            int count=0;
            for (int j=0;j<bank[i].length();j++){
                if(bank[i].charAt(j)=='1') count++;
            }
             if(count > 0) list.add(count);
        }
        int res=0;
        for(int i=0;i<list.size()-1;i++){
            res=res+(list.get(i)*list.get(i+1));
        }
        return res;
    }
}