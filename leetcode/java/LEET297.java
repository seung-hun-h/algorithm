/**
 * LEET297
 */
import java.util.*;
public class LEET297 {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
    public static class Codec {

        public String serialize(TreeNode root) {
            StringBuilder sb = new StringBuilder("# ");
            Queue<TreeNode> q = new LinkedList<>();
            q.add(root);

            while(!q.isEmpty()){
                TreeNode node = q.poll();

                if(node != null){
                    q.add(node.left);
                    q.add(node.right);

                    sb.append(node.val);
                } else {
                    sb.append("#");
                }
                sb.append(" ");
            }

            return sb.toString().trim();
        }
    
        // Decodes your encoded data to tree.
        public TreeNode deserialize(String data) {
            if(data.equals("# #")){
                return null;
            }
            Queue<TreeNode> q = new LinkedList<>();
            String[] nodes = data.split(" ");
            TreeNode root = new TreeNode(Integer.parseInt(nodes[1]));
            int index = 2;
            q.add(root);

            while(!q.isEmpty()){
                TreeNode node = q.poll();
                if(!nodes[index].equals("#")){
                    node.left = new TreeNode(Integer.parseInt(nodes[index]));
                    q.add(node.left);
                }
                index++;

                if(!nodes[index].equals("#")){
                    node.right = new TreeNode(Integer.parseInt(nodes[index]));
                    q.add(node.right);
                }
                index++;
            }
            return root;
        }     // Encodes a tree to a single string.
   
    }
    
    
}