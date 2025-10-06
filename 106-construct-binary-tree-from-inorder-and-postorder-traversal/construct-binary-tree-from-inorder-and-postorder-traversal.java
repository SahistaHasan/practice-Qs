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
    public TreeNode build(int [] inorder, int[]postorder, Map<Integer,Integer> map, int inStart,int inEnd, int postStart, int postEnd){
             if(inStart>inEnd || postStart>postEnd){
                return null;
             }
             TreeNode root = new TreeNode(postorder[postEnd]);
             int index=map.get(postorder[postEnd]);
             root.left=build(inorder,postorder,map,inStart,index-1,postStart,postStart+(index-inStart)-1);
             root.right = build(inorder,postorder,map,index+1,inEnd,postStart + (index - inStart),postEnd-1);
             
             return root;
    }
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        Map<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<inorder.length;i++){
            map.put(inorder[i],i);
        }
        return build(inorder,postorder,map,0,inorder.length-1,0,postorder.length-1);
    }
}