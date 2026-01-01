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
    public void dfs(TreeNode root, int deep,int depth,int val){
            if(root==null) return;
            if(deep==depth-1){
                TreeNode templeft=root.left;
                TreeNode tempright = root.right;
                TreeNode ntree1= new TreeNode(val);
                 TreeNode ntree2= new TreeNode(val);
                root.left=ntree1;
                root.right=ntree2;
                ntree1.left=templeft;
                ntree1.right=null;
                ntree2.right=tempright;
                ntree2.left=null;
                return;
            }
            
            dfs(root.left,deep+1,depth,val);
            dfs(root.right,deep+1,depth,val);
            return;

    }
    public TreeNode addOneRow(TreeNode root, int val, int depth) {
        if(depth==1){
            TreeNode ntree= new TreeNode(val);
            ntree.left=root;
            return ntree;
        }
        dfs(root,1,depth,val);
        return root;
    }
}