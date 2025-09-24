/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
    public Node connect(Node root) {
         Queue<Node> que = new LinkedList<>();
         if (root==null) return null;
        que.offer(root);
        while(!que.isEmpty()){
            int n = que.size();
            for(int i=0;i<n;i++){
                if(que.peek().left!=null){
                    que.offer(que.peek().left);
                }
                if(que.peek().right!=null){
                    que.offer(que.peek().right);
                }
                 if (i < n - 1) {
                     que.poll().next = que.peek();
                     // Next node in the queue
                } else {
                    que.poll().next = null; // Last node in level
                }

            }

        }
        return root;
    }
}