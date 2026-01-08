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
    int mod=1000000007;
    long max=Integer.MIN_VALUE;
    public long total(TreeNode root){
        if(root==null) return 0;
        long left = total(root.left);
        long right = total(root.right);
        return root.val+left+right;
    }
    public long solve(TreeNode root,long total){
        if(root==null) return 0;
        long left = solve(root.left,total);
        long right = solve(root.right,total);
        long sum =(root.val+left+right)%mod;
        max=(Math.max(max,((total-sum)*sum)));
        return root.val+left+right;
    }
    public int maxProduct(TreeNode root) {
        long total = (total(root));
        solve(root,total);
        return (int)(max%mod);
    }
}