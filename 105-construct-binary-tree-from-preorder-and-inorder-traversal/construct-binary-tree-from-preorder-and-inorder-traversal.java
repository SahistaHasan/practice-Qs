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
    public TreeNode recurse(int[] preorder, int preStart, int preEnd,int [] inorder, int inStart, int inEnd, Map<Integer,Integer> map){
        if(preStart>preEnd || inStart>inEnd) return null;
      TreeNode root = new TreeNode(preorder[preStart]);
      int index=map.get(root.val);
      int left=index-inStart;
      root.left=recurse(preorder,preStart+1,preStart+left,inorder,inStart,index-1,map);
      root.right=recurse(preorder,preStart+left+1,preEnd,inorder,index+1,inEnd,map);
      return root;
    }
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<inorder.length;i++){
            map.put(inorder[i],i);
        }
        return recurse(preorder,0,preorder.length-1,inorder,0,inorder.length-1,map);
    }
}