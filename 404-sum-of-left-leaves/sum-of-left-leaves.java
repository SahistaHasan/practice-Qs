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
    public int recurse(TreeNode root, boolean state){
        if(root==null) return 0;
        if(root.left==null && root.right==null){
           if(state==true) return root.val;
           else return 0;
        }

        int count1=recurse(root.left,true);
        int count2=recurse(root.right,false);
        return count1+count2;
    }
    public int sumOfLeftLeaves(TreeNode root) {
       return  recurse(root,false);
    }
}