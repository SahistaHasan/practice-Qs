/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root==null) return "";
        Queue<TreeNode> que = new LinkedList<>();
        que.offer(root);
        StringBuilder sb = new StringBuilder();
        
        while(!que.isEmpty()){
            
            
           
            int n = que.size();
            for(int i=0;i<n;i++){
                TreeNode node=que.poll();
               if (node == null) {
                    sb.append("#,");
                    continue;
                }
                sb.append(node.val).append(",");
                que.offer(node.left);
                que.offer(node.right);
                 
            }
          
        }
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data.equals("")) return null;
         String[] values = data.split(",");
        Queue<TreeNode> que = new LinkedList<>();
        
           
            TreeNode origin = new TreeNode(Integer.parseInt(values[0]));
            que.offer(origin);
        
        int i=1;
        while(i<values.length && !que.isEmpty()){
            TreeNode root = que.poll();
            if(!values[i].equals("#")){
          
            TreeNode left=new TreeNode(Integer.parseInt(values[i]));
            que.offer(left);
            root.left=left;
            }
            i++;
            if(i<values.length && !values[i].equals("#")){
               
                TreeNode right=new TreeNode(Integer.parseInt(values[i]));
                que.offer(right);
                root.right=right;
            }
            i++;
        }
        return origin;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));