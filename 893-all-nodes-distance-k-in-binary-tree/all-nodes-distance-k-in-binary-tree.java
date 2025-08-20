/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
   public Map<TreeNode,TreeNode> bfs(TreeNode root, Map<TreeNode,TreeNode> map){
    Queue<TreeNode> que= new LinkedList<>();
    que.offer(root);
    while(!que.isEmpty()){
        int n=que.size();
        while(n!=0){
            TreeNode parent = que.poll();
            if(parent.right!=null){
                que.offer(parent.right);
                map.put(parent.right,parent);
            }
            if(parent.left!=null){
                que.offer(parent.left);
                map.put(parent.left,parent);
            }
            n--;
        }
    }
    return map;
   }
   
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        Map<TreeNode,TreeNode> map = new HashMap<>();
        bfs(root,map);
        //now travel bfs for finding node with distance k from target node
        Map<TreeNode,Boolean> map2 = new HashMap<>();
        Queue<TreeNode> que = new LinkedList<>();
        que.offer(target);
        int level=0;
        map2.put(target,true);
        while(!que.isEmpty()){
            int n =que.size();
            
            if(level==k) break;
            level++;
            while(n!=0){
               TreeNode prev=que.poll();
               if(prev.right!=null && map2.get(prev.right)==null){
                que.offer(prev.right);
                map2.put(prev.right,true);
               }
               if(prev.left!=null && map2.get(prev.left)==null){
                que.offer(prev.left);
                map2.put(prev.left,true);
               }
               if(map.get(prev)!=null && map2.get(map.get(prev))==null ){
                que.offer(map.get(prev));
                map2.put(map.get(prev),true);
               }
               n--;
            }
            
        }
       List<Integer> list = new ArrayList<>();

       
        for (TreeNode node : que) {
            list.add(node.val);
        }

        return list;
    }
}