/**
 * LEET104
 */
import java.util.*;
public class LEET104 {    
//   Definition for a binary tree node.
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
  public static void main(String[] args){
    Integer[] root = {3,9,20,null,null,15,7};
    TreeNode[] nodes = new TreeNode[root.length];
    for(int i=0;i<root.length;i++){
        if(root[i] == null){
            nodes[i] = null;
        } else {
            nodes[i] = new TreeNode(root[i]);
        }
    }

    for(int i=0;i<nodes.length;i++){
        if(nodes[i] == null) continue;
        TreeNode cur_node = nodes[i];
        int left = i*2+1, right = i*2+2;

        if(left < nodes.length && nodes[left] != null){
            cur_node.left = nodes[left];
        }
        if(right < nodes.length && nodes[right] != null){
            cur_node.right = nodes[right];
        }
    }
    System.out.println(maxDepth(nodes[0]));
  }
  public static int maxDepth(TreeNode root){
    if(root == null)
        return 0;

    int depth = 0;
    Deque<TreeNode> q = new ArrayDeque<>();
    q.add(root);

    while(!q.isEmpty()){
        depth++;
        
        int iter = q.size();
        for(int i=0;i<iter;i++){
            TreeNode cur_root = q.removeFirst();

            if(cur_root.left != null){
                q.add(cur_root.left);
            }
            if(cur_root.right != null){
                q.add(cur_root.right);
            }
        }
    }
    return depth;
  }
}