class Solution {
    public int minAddToMakeValid(String s) {
       Stack<Character> stack=new Stack<>();
       int i=0;
       int count=0;
        for( i=0;i<s.length();i++){
            char ch =s.charAt(i);
            if(ch=='(') stack.push('(');
            else if (ch==')' && stack.isEmpty()){
                count++;
            }
            else{
            stack.pop();
            }
        }
        while(!stack.isEmpty()){
            stack.pop();
            count++;
        }
        if(i<s.length()){
         count=count+s.length()-i;
        }
        return count;
    }
}