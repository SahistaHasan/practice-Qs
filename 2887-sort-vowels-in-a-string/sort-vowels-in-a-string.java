class Solution {
    public String sortVowels(String s) {
        PriorityQueue<Character> pq=new PriorityQueue<>();
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='a' || s.charAt(i)=='e' || s.charAt(i)=='i' || s.charAt(i)=='o' || s.charAt(i)=='u' || s.charAt(i)=='A' || s.charAt(i)=='E' || s.charAt(i)=='O' || s.charAt(i)=='I' || s.charAt(i)=='U'){
            pq.offer(s.charAt(i));
            }
        }
        for(int i=0;i<s.length();i++){
             if(s.charAt(i)=='a' || s.charAt(i)=='e' || s.charAt(i)=='i' || s.charAt(i)=='o' || s.charAt(i)=='u' || s.charAt(i)=='A' || s.charAt(i)=='E' || s.charAt(i)=='O' || s.charAt(i)=='I' || s.charAt(i)=='U'){
                sb.append(pq.poll());
             }
             else{
                sb.append(s.charAt(i));
             }
        }
       return sb.toString();

    }
}