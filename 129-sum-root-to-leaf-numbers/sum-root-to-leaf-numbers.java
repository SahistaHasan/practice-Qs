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
    public void sum(TreeNode root,int sum){
               if(root==null) return;
               if(root.left==null && root.right==null){
                sum=sum*10+root.val;
                max=max+sum;
                return ;
               }
               sum=sum*10+root.val;
              sum(root.left,sum);
              sum(root.right,sum);
              
               return ;
    }
    public int sumNumbers(TreeNode root) {
        int sum=0;
        sum(root,sum);
        return max;
    }
}