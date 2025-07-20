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
    int sum=0;
    public void nodes(TreeNode root){
            if(root==null) return;
             sum=sum+1;
             nodes(root.left);
             nodes(root.right);
             return;

    }
    public int countNodes(TreeNode root) {
        nodes(root);
        return sum;
    }
}