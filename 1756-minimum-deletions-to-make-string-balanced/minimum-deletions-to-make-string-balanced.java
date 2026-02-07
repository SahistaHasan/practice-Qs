class Solution {
    public int minimumDeletions(String s) {
        int countB=0;
        int deletions=0;
        int ans=-1;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='a' && countB>0){
                deletions++;
                deletions=Math.min(deletions,countB);
            }
            else if(s.charAt(i)=='b'){
                countB++;
                deletions=Math.min(deletions,countB);
            }
        }
        return deletions;
    }
}