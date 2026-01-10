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
    public TreeNode reverseOddLevels(TreeNode root) {
        Queue<TreeNode> que = new LinkedList<>();
        List<List<Integer>> res = new ArrayList<>();
        que.add(root);
        List<Integer> list0 = new ArrayList<>();
        list0.add(root.val);
        res.add(list0);
        int  count=0;
        while(!que.isEmpty()){
          int n = que.size();
          List<Integer> list = new ArrayList<>();
          for(int i=0;i<n;i++){
            TreeNode curr = que.poll();
            if(curr.left!=null) {que.add(curr.left);
            list.add(curr.left.val);}
            if(curr.right!=null){ que.add(curr.right);
             list.add(curr.right.val);}
            
          }
          if(count%2==0){
            Collections.reverse(list);
          }
          res.add(list);
          count++;
        }
        que.add(root);
        int count2=0;
        while(!que.isEmpty()){
            int n = que.size();
            for(int i=0;i<n;i++){
                TreeNode curr= que.poll();
                if(count2%2!=0) curr.val = res.get(count2).get(i);
                if(curr.left!=null) que.add(curr.left);
                if(curr.right!=null) que.add(curr.right);
                
            }
            count2++;
        }
      return root;
    }
}