class Solution {
    public int minDeletionSize(String[] strs) {
        char compare=' ';
        int count=0;
        for(int i=0;i<strs[0].length();i++){
            for(int j=0;j<strs.length;j++){
                if(j==0) {
                    compare=strs[j].charAt(i);
                }
                else{
                    if(strs[j].charAt(i)<compare){
                        count++;
                        break;
                    }
                    else{
                        compare=strs[j].charAt(i);
                    }
                }
            }
        }
        return count;
    }
}