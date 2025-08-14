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
    boolean flag=true;
    public int recurse(TreeNode root){
        if(flag==false) return -1;
        if(root==null) return 0;
      int left=  recurse(root.left);
      int right=  recurse(root.right);
      if(Math.abs(left-right)>1){
        flag=false;
        return -1;
      }
      return 1+Math.max(left,right);
    }
    public boolean isBalanced(TreeNode root) {
        recurse(root);
        return flag;
    }
}