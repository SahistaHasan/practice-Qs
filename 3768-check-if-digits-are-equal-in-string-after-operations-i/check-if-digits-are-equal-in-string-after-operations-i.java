class Solution {
    public boolean hasSameDigits(String s) {
        int count=0;
        StringBuilder sb = new StringBuilder();
        sb.append(s);
        while(sb.length()!=0){
            String temp=sb.toString();
            if(temp.length()==2){
                if(temp.charAt(0)==temp.charAt(1)) return true;
                else return false;
            }
            sb.setLength(0);
            for(int i=1;i<temp.length();i++){
                int res = (temp.charAt(i-1)-'0'+temp.charAt(i)-'0')%10;
                sb.append(res);
            }
        }
        return false;
    }
}