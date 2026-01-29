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
class FindElements {
     public TreeNode root;
    public FindElements(TreeNode root) {
        this.root=root;
        this.root.val=0;
        solve(this.root);
        
    }
    public void solve(TreeNode root){
        if(root==null) return;
        if(root.left==null && root.right==null) return;
        if(root.left!=null){
            root.left.val=2*root.val+1;
        }
        if(root.right!=null){
            root.right.val=2*root.val+2;
        }
        solve(root.left);
        solve(root.right);
        return;
    }
    public boolean traverse(TreeNode root, int target){
        if(root==null) return false;
        if(root.val==target) return true;
        return traverse(root.left,target) ||traverse( root.right,target);
    }
    
    public boolean find(int target) {
        return traverse(root,target);
    }
}

/**
 * Your FindElements object will be instantiated and called as such:
 * FindElements obj = new FindElements(root);
 * boolean param_1 = obj.find(target);
 */