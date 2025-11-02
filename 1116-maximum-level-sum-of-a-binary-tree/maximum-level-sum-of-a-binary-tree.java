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
    public int maxLevelSum(TreeNode root) {
        Queue<TreeNode> que = new LinkedList<>();
        que.offer(root);
        int level = 1;
        int count = 1;
        int max = root.val;

        while (!que.isEmpty()) {
            int n = que.size();
            int sum = 0;

            for (int i = 0; i < n; i++) {
                TreeNode curr = que.poll();
                sum += curr.val; // ✅ fix: add current node’s value

                if (curr.left != null) que.offer(curr.left);
                if (curr.right != null) que.offer(curr.right);
            }

            if (sum > max) { // ✅ fix: check before incrementing count
                max = sum;
                level = count;
            }

            count++; // ✅ move to next level after processing current one
        }

        return level;
    }
}
