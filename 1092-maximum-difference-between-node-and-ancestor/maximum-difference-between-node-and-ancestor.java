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
    int max=0;
    public int[] recurse(TreeNode root){
        if(root==null) return new int[]{Integer.MAX_VALUE,Integer.MIN_VALUE};
        int [] left = recurse(root.left);
        int [] right = recurse(root.right);
        int mini = Math.min(root.val, Math.min(left[0], right[0]));
        int maxi = Math.max(root.val, Math.max(left[1], right[1]));
        max = Math.max(max, Math.max(Math.abs(maxi - root.val), Math.abs(mini - root.val)));
        
        
        
        return new int[]{Math.min(root.val,mini),Math.max(root.val,maxi)};
    }
    public int maxAncestorDiff(TreeNode root) {
        recurse(root);
        return max;
    }
}