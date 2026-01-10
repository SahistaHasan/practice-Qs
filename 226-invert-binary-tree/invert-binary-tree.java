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
    public void construct(TreeNode root){
        if(root==null) return;
        TreeNode left=root.left;
        TreeNode right = root.right;
        root.left=right;
        root.right=left;
        construct(root.left);
        construct(root.right);
        return;
    }
    public TreeNode invertTree(TreeNode root) {
        construct(root);
        return root;
    }
}