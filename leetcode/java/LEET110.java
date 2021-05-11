/**
 * LEET110
 */
import java.util.*;
public class LEET110 {    
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
        TreeNode root = buildTree(new Integer[] {3,9,20,null,null,15,7});
        System.out.println(isBalanced(root));
    }
    public static TreeNode buildTree(Integer[] root){
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
        return nodes[0];
    }
    public static boolean isBalanced(TreeNode root){
        return dfs(root) != -1;
    }
    public static int dfs(TreeNode root){
        if(root == null)
            return 0;
        
        int left = dfs(root.left);
        int right = dfs(root.right);

        if(left == -1 || right == -1 || Math.abs(left-right) > 1)
            return -1;

        return 1 + Math.max(left, right);
    }
    public static TreeNode mergeTrees2(TreeNode root1, TreeNode root2){
        if(root1 == null)
            return root2;
        if(root2 == null)
            return root1;
        Deque<TreeNode> q = new ArrayDeque<>();
        TreeNode root = new TreeNode(root1.val + root2.val);
        q.add(root);
        q.add(root1);
        q.add(root2);

        while(!q.isEmpty()){
            TreeNode r = q.removeFirst();
            TreeNode t1 = q.removeFirst();
            TreeNode t2 = q.removeFirst();

            if(t1.left != null && t2.left != null){
                r.left = new TreeNode(t1.left.val + t2.left.val);
                q.add(r.left); q.add(t1.left); q.add(t2.left);
            } else if(t1.left != null){
                r.left = t1.left;
            } else {
                r.left = t2.left;
            }

            if(t1.right != null && t2.right != null){
                r.right = new TreeNode(t1.right.val + t2.right.val);
                q.add(r.right); q.add(t1.right); q.add(t2.right);
            } else if(t1.right != null){
                r.right = t1.right;
            } else {
                r.right = t2.right;
            }
        }
        return root;
    }
}