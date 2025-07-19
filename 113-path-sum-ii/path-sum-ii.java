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
    List<List<Integer>> list = new ArrayList<>();
    int sum=0;
    public void recurse(TreeNode root,int target,List<Integer> inner){
      if(root==null) return;
      sum=sum+root.val;
      inner.add(root.val);
      if(sum==target && root.right==null && root.left==null) {
        list.add(new ArrayList<>(inner));
      }
      recurse(root.left,target,inner);
      recurse(root.right,target,inner);


      inner.remove(inner.size()-1);
      sum=sum-root.val;

      
    }
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<Integer> list1 = new ArrayList<>();
        recurse(root,targetSum,list1);
        return list;
    }
}