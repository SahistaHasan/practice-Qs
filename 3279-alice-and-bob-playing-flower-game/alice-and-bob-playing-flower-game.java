class Solution {
    public long flowerGame(int n, int m) {
        
       long Neven=(n)/2;
       long Modd=(m+1)/2;
       long Meven=m/2;
       long Nodd=(n+1)/2;
        return Neven*Modd + Meven*Nodd;
    }
}