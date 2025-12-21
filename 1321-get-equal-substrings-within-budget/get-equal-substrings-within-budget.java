class Solution {
    public int equalSubstring(String s, String t, int maxCost) {
        int max=Integer.MIN_VALUE;
        int i=0;
        int score=0;
        for(int j=0;j<s.length();j++){
              score=score+Math.abs(s.charAt(j)-t.charAt(j));
              while(score>maxCost ){
                 score=score-Math.abs(s.charAt(i)-t.charAt(i));
                 i++;
              }
              max=Math.max(max,j-i+1);
        }
        return max;
    }
}