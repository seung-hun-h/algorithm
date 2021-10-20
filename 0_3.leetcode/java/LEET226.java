/**
 * LEET226
 */
public class LEET226 {    
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
        Integer[] root = {5,4,5,1,1,5};
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
        System.out.println(invertTree(nodes[0]));
    }
    static int longest = 0;
    public static TreeNode invertTree(TreeNode root){
        return dfs(root);
    }
    public static TreeNode dfs(TreeNode node){
        if(node == null)
            return null;

        TreeNode left = dfs(node.left), right = dfs(node.right);
        node.right = left; node.left = right;
        return node;
    }
}