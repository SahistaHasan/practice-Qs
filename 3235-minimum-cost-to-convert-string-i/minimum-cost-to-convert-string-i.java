class Solution {
    public long minimumCost(String source, String target, char[] original, char[] changed, int[] cost) {
        long [][] dist = new long[26][26];
        for(int i=0;i<26;i++){
            for(int j=0;j<26;j++){
                if(i==j) {
                    dist[i][j]=0;
                    continue;
                }
                dist[i][j]=Integer.MAX_VALUE;
            }
        }
        for(int i=0;i<original.length;i++){
            int u = original[i]-'a';
            int v = changed[i]-'a';
            dist[u][v] = Math.min(dist[u][v], cost[i]);


        }
        for(int i=0;i<dist.length;i++){
            for(int j=0;j<dist.length;j++){
                for(int k=0;k<dist.length;k++){
                    if(dist[j][i]<Integer.MAX_VALUE && dist[i][k]<Integer.MAX_VALUE)
                    dist[j][k]=Math.min(dist[j][k],dist[j][i]+dist[i][k]);
                }
            }
        }
        long totalcost=0;
        for(int i=0;i<source.length();i++){
            int u=source.charAt(i)-'a';
            int v = target.charAt(i)-'a';
            if(dist[u][v]>=Integer.MAX_VALUE) return -1;
            totalcost=totalcost+dist[u][v];
        }
        return totalcost;
    }
}