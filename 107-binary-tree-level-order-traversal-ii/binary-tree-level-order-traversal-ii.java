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
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        Queue<TreeNode> que= new LinkedList<>();
        List<List<Integer>> list=new ArrayList<>();
        if (root == null) return list;
        que.offer(root);
        while(!que.isEmpty()){
            
            int n =que.size();
            List<Integer> inner=new ArrayList<>();
            for(int i=0;i<n;i++){
                TreeNode curr=que.poll();
                
                inner.add(curr.val);
                if(curr.left!=null){
                    que.offer(curr.left);
                }
                if(curr.right!=null){
                    que.offer(curr.right);
                }
            }
            list.add(new ArrayList<>(inner));
        }
         Collections.reverse(list);
         return list;
    }
}