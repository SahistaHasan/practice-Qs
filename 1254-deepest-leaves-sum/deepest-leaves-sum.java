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
    public int deepestLeavesSum(TreeNode root) {
        Queue<TreeNode> que=new LinkedList<>();
        int res=0;
        que.offer(root);
        while(!que.isEmpty()){
            int n=que.size();
            res=0;
            for(int i=0;i<n;i++){
                TreeNode curr=que.poll();
                 res=res+curr.val;
                 if(curr.left!=null) que.offer(curr.left);
                 if(curr.right!=null) que.offer(curr.right);
            }
        }
        return res;
    }
}