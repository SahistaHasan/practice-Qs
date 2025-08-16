class Solution {
    public int maximum69Number (int num) {
        int n = num;
        int count=0;
        while(n!=0){
            n=n/10;
            count++;
        }
      
        int max=num;
        for(int i=0;i<count;i++){
            StringBuilder sb = new StringBuilder();
            String val=String.valueOf(num);
            sb.append(val);
            if(sb.charAt(i)=='6'){
            sb.setCharAt(i, '9'); 
            }
            else{
                sb.setCharAt(i, '6'); 
            }
            String val2=sb.toString();
            Integer nums=Integer.valueOf(val2);
            max=Math.max(max,nums);

        }
        return max;
    }
}