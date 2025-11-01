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
    public int findBottomLeftValue(TreeNode root) {
        Queue<TreeNode> que=new LinkedList<>();
        TreeNode curr=new TreeNode(-1);
        que.offer(root);
        while(!que.isEmpty()){
            int n = que.size();
            
            for(int i=0;i<n;i++){
                 curr=que.peek();
               if(curr.right!=null) que.offer(curr.right);
                if(curr.left!=null) que.offer(curr.left);
               que.poll();
            }
        }
        return curr.val;
        
    }
}