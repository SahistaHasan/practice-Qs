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
    TreeNode res;
    int max=0;
    public int dfs(TreeNode root,int level){
        if(root==null) return level-1;
        
       int left= dfs(root.left,level+1);
       int right = dfs(root.right, level+1);
       int branchmax=Math.max(right,left);
       max=Math.max(max,branchmax);
       if(left==max && right==max) {
        res=root;
       }
       return branchmax;
    }
    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        dfs(root,1);
        return res;
    }
}