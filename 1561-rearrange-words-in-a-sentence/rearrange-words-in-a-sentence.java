class Solution {
    public String arrangeWords(String text) {
        String [] words= text.split(" ");
        words[0]=words[0].toLowerCase();
        Arrays.sort(words,(a,b)->a.length()-b.length());
        String sentence = String.join(" ",words);
        sentence = sentence.substring(0, 1).toUpperCase() + sentence.substring(1);
        return sentence;
    }
}