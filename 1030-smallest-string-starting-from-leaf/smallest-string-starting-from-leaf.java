class Solution {

    private String smallest = null;

    public void recurse(TreeNode root, StringBuilder sb) {
        if (root == null) return;

        sb.append((char)('a' + root.val));

        if (root.left == null && root.right == null) {
            String candidate = new StringBuilder(sb).reverse().toString();
            if (smallest == null || candidate.compareTo(smallest) < 0) {
                smallest = candidate;
            }
        }

        recurse(root.left, sb);
        recurse(root.right, sb);

        sb.deleteCharAt(sb.length() - 1); // backtrack
    }

    public String smallestFromLeaf(TreeNode root) {
        recurse(root, new StringBuilder());
        return smallest;
    }
}
