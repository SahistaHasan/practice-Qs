class Solution {
    public int compareVersion(String version1, String version2) {
        int i=0;
        int j=0;
        StringBuilder sb1= new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        while(i<version1.length() || j<version2.length()){
               while(i<version1.length() && version1.charAt(i)!='.'){
                sb1.append(version1.charAt(i));
                i++;
               }
               while(j<version2.length() && version2.charAt(j)!='.'){
                sb2.append(version2.charAt(j));
                j++;
               }
               int one = sb1.length() > 0 ? Integer.parseInt(sb1.toString()) : 0;
               int two = sb2.length() > 0 ? Integer.parseInt(sb2.toString()) : 0;
               if(i==version1.length() && j==version2.length()){
                if(one==two) return 0;
               }
               if(one>two) return 1;
               else if(one<two) return -1;
               
               sb1.delete(0, sb1.length());
               sb2.delete(0, sb2.length());
              i++;
              j++;
        }
        return 0;
    }
}