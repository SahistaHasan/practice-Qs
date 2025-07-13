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
    public int recurse(TreeNode root,int count,int max){
          if(root==null ){
            return 0;
        }
      
       
       int left = recurse(root.left,count,max);
       int right = recurse(root.right,count,max);
         count++;
        max=count+Math.max(left,right);
        return max;

    }
    
    public int maxDepth(TreeNode root) {
        return recurse(root,0,0);
    }
}