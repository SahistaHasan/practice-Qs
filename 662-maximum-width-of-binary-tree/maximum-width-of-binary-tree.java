class Pair {
    TreeNode node;
    int rank;

    Pair(TreeNode node, int rank) {
        this.node = node;
        this.rank = rank;
    }
}

class Solution {
    public int widthOfBinaryTree(TreeNode root) {
        if (root == null) return 0;

        Queue<Pair> que = new LinkedList<>();
        que.add(new Pair(root, 1));
        int maxwid = 0;

        while (!que.isEmpty()) {
            int size = que.size();
            int start = que.peek().rank;  
            int end = start;              

            for (int i = 0; i < size; i++) {
                Pair current = que.poll();
                TreeNode node = current.node;
                int rank = current.rank;

                end = rank; 

                if (node.left != null)
                    que.add(new Pair(node.left, rank * 2));
                if (node.right != null)
                    que.add(new Pair(node.right, rank * 2 + 1));
            }

            maxwid = Math.max(maxwid, end - start + 1);
        }

        return maxwid;
    }
}
