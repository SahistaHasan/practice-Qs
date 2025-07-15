/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
 class Pair{
    TreeNode node;
    int level;
    Pair(TreeNode node, int level){
        this.node = node;
        this.level=level;
    }
 }
class Solution {
    public List<Integer> rightSideView(TreeNode root) {
       Queue<Pair>  que = new LinkedList<>();
       Map<Integer,Integer> map = new TreeMap<>();
       List<Integer> list = new ArrayList<>();
        if (root == null) return list;
       que.add(new Pair(root,0));
       while(!que.isEmpty()){
             int n = que.size();
             for(int i=0;i<n;i++){
             TreeNode pulled = que.peek().node;
             int row = que.peek().level;
             que.poll();
             
               if(!map.containsKey(row)){
                map.put(row,pulled.val);
               }

            
             if(pulled.right!=null){
                que.add(new Pair(pulled.right,row+1));
             }
             if(pulled.left!=null){
                que.add(new Pair(pulled.left,row+1));
             }
             }
       }
       for(Map.Entry<Integer,Integer> e: map.entrySet()){
        list.add(e.getValue());
       }
       return list;
    }
}