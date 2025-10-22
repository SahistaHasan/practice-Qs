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
class Solution {
    public int sum(TreeNode root, Map<Integer,Integer> map){
        if(root==null) return 0;
        int left=sum(root.left,map);
        int right=sum(root.right,map);
        map.put(left+right+root.val,map.getOrDefault(left+right+root.val,0)+1);
        return left+right+root.val;

    }
    public int[] findFrequentTreeSum(TreeNode root) {
        Map<Integer, Integer> map = new HashMap<>();
        sum(root,map);
        int max=0;
        for(Map.Entry<Integer,Integer> e: map.entrySet()){
            max=Math.max(max,e.getValue());
        }
        List<Integer> list = new ArrayList<>();
        for(Map.Entry<Integer,Integer> e: map.entrySet()){
            if(e.getValue()==max) list.add(e.getKey());
        }
         int[] arr = list.stream().mapToInt(Integer::intValue).toArray();
         return arr;
    }
}